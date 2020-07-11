package com.demo1.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo1.utils.Constantes;

/**
 * 
 * @since 07-11-2020
 * @author Angel Lara
 *
 */
@Service
@Component
public class TaskService {

	public List<String> procesarArchivo(MultipartFile archivo, List<String> listaPalabras, String nombreArchivoSalida) throws Exception {
		try {
			if(!archivo.getContentType().equalsIgnoreCase("text/plain") || archivo.isEmpty()) {
				throw new Exception("Archivo vacío o no soportado");
			}
			
			List<String> listaArchivo = new ArrayList<String>();
			String linea;
			InputStream archivoIStream = archivo.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(archivoIStream));
			
			while((linea = buffer.readLine()) != null) {
				listaArchivo.add(linea);
			}
			
			listaPalabras.retainAll(listaArchivo);
			if(!listaPalabras.isEmpty()) {
				FileWriter writer = new FileWriter(nombreArchivoSalida + Constantes.EXT_TEXT);
				for(String palabra : listaPalabras) {
					writer.write(palabra + System.lineSeparator());
				}
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPalabras;
	}
}
