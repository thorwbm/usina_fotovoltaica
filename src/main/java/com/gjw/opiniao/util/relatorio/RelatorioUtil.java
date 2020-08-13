package com.gjw.opiniao.util.relatorio;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.gjw.opiniao.service.NegocioException;
import com.gjw.opiniao.util.upload.Diretorio;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

@SuppressWarnings("deprecation")
public class RelatorioUtil implements Work, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Inject
	private FacesContext facesContext;
	
	private HttpServletResponse response;
	private Map<String, Object> parametros;
	private String nomeRelatorioJasper;
	private String nomeRelatorioSaida;
	@SuppressWarnings("rawtypes")
	private JRExporter exportador;
	private String extensaoRelatorioExportado;
	private boolean relatorioGerado;
	
	public void gerarRelatorio(Map<String, Object> parametros, String nomeRelatorioJasper, String nomeRelatorioSaida, String tipo) throws NegocioException {
		this.parametros = parametros;
		this.nomeRelatorioJasper = nomeRelatorioJasper;
		this.nomeRelatorioSaida = nomeRelatorioSaida;
		this.parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
		this.parametros.put("SUBREPORT_DIR", Diretorio.RELATORIO.getDescricao());

		this.configuraPeloTipo(tipo);
		this.initConnection();
	}
	
	public boolean isRelatorioGerado() {
		return relatorioGerado;
	}

	private void configuraPeloTipo(String tipo) {
		if (tipo.equals("pdf")) {
			this.exportador = new JRPdfExporter();
			this.extensaoRelatorioExportado = "pdf";
		}  else if (tipo.equals("xls")) {
			this.exportador = new JRXlsExporter();
			this.extensaoRelatorioExportado = "xls";
		} else if (tipo.equals("rtf")) {
			this.exportador = new JRRtfExporter();
			this.extensaoRelatorioExportado = "rtf";
		}
	}

	private void initConnection() {
		Session session = manager.unwrap(Session.class);
		session.doWork(this);
	}

	@Override
	public void execute(Connection connection) throws SQLException {
		try {

			InputStream relatorioStream = new FileInputStream(Diretorio.RELATORIO.getDescricao() + nomeRelatorioJasper);
			JasperPrint print = JasperFillManager.fillReport(relatorioStream, this.parametros, connection);


			this.relatorioGerado = print.getPages().size() > 0;

			if (this.relatorioGerado) {
				response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				
				exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);

				response.setContentType("application/"+ this.extensaoRelatorioExportado);
				response.setHeader("Content-Disposition","inline; filename=\"" + this.nomeRelatorioSaida+ "." + this.extensaoRelatorioExportado + "\"");
				
				exportador.exportReport();
			}
		} catch (Exception e) {
			throw new SQLException("Erro ao executar relatório", e);
		}
	}

}