package com.gjw.opiniao.util.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.*;

public class Upload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public void deletarArquivo(String nomeArquivo, Diretorio diretorio) {
		File arquivo = new File(diretorio.getDescricao() + nomeArquivo);
        arquivo.delete();
	}
	
	public Boolean verificarExisteArquivo(FileUploadEvent event, Diretorio diretorio){
		Boolean retorno = false;
		
		UploadedFile uf = event.getFile();   
        String nomeArquivo = uf.getFileName();   
        String[] vetor = nomeArquivo.split("\\\\");
        int tam = vetor.length;
        
        File f = new File(diretorio.getDescricao() + vetor[tam-1]);
        
        if(f.exists()){
        	retorno = true;
        }
        
        return retorno;
	}
	
	public Boolean verificarExisteArquivo(FileUploadEvent event, Diretorio diretorio, String identificadorArquivo){
		Boolean retorno = false;
		
		UploadedFile uf = event.getFile();   
        String nomeArquivo = identificadorArquivo + uf.getFileName();  
        String[] vetor = nomeArquivo.split("\\\\");
        int tam = vetor.length;
        
        File f = new File(diretorio.getDescricao() + vetor[tam-1]);   
        
        if(f.exists()){
        	retorno = true;
        }
        
        return retorno;
	}	
	
	public String upload(FileUploadEvent event, Diretorio diretorio) throws FileNotFoundException, IOException {
		UploadedFile uf = event.getFile();   
        String arquivo = uf.getFileName();   
        String[] vetor = arquivo.split("\\\\");
        int tam = vetor.length;
        
        File f = new File(diretorio.getDescricao() + vetor[tam-1]);   
               
        OutputStream os = null;   
        InputStream is = null;   
        
        try {   
            is = uf.getInputStream();   
            byte[] b = new byte[is.available()];   
            os = new FileOutputStream(f);   
            
            while (is.read(b) > 0) {   
                os.write(b);   
            }                 
        } catch (IOException ex) {   
            ex.printStackTrace();   
        } finally {   
            try {   
                os.flush();   
                os.close();   
                is.close();   
            } catch (IOException ex) {   
                ex.printStackTrace();   
            }
        }
	        
		return diretorio.getDescricao() + vetor[tam-1];
	}
	
	public String upload(FileUploadEvent event, Diretorio diretorio, String nomeArquivo) throws FileNotFoundException, IOException {
		UploadedFile uf = event.getFile();   
        String arquivo = nomeArquivo + uf.getFileName().substring(uf.getFileName().lastIndexOf('.'));
        String[] vetor = arquivo.split("\\\\");
        int tam = vetor.length;
        
        File f = new File(diretorio.getDescricao() + vetor[tam-1]);    
               
        OutputStream os = null;   
        InputStream is = null;   
        
        try {   
            is = uf.getInputStream();   
            byte[] b = new byte[is.available()];   
            os = new FileOutputStream(f);   
            
            while (is.read(b) > 0) {   
                os.write(b);   
            }                 
        } catch (IOException ex) {   
            ex.printStackTrace();   
        } finally {   
            try {   
                os.flush();   
                os.close();   
                is.close();   
            } catch (IOException ex) {   
                ex.printStackTrace();   
            }
        }
	        
        return diretorio.getDescricao() + vetor[tam-1];
	}
	
}
