package com.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo1.service.TaskService;

/**
 * 
 * @since 07-11-2020
 * @author Angel Lara
 *
 */
@RestController
@Component
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	/**
	 * Endpoint que procesa el archivo y guarda el nuevo con las palabras coincidentes
	 * 
	 * @param archivo
	 * @param listaPalabras
	 * @param nombreArchivoSalida
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/archivo")
	public List<String> subidaArchivo(@RequestParam("archivo") MultipartFile archivo, 
									  @RequestParam("listaPalabras") List<String> listaPalabras,
									  @RequestParam("nombreArchivoSalida") String nombreArchivoSalida) throws Exception {
		return taskService.procesarArchivo(archivo, listaPalabras, nombreArchivoSalida);
	}
}
