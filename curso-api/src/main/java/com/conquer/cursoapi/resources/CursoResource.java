package com.conquer.cursoapi.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquer.conquerutils.dto.CursoDto;
import com.conquer.cursoapi.services.CursoService;
import com.google.gson.Gson;

@RestController
public class CursoResource {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarCurso(@RequestBody CursoDto curso, HttpServletRequest request){
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(curso));
		
		//Deve ser implementado aqui um sistema de reserva de matrícula para alterar a situação da matrícula antes de efetuar a venda e uma task para liberar as reservas expiradas
		if(cursoService.registrarCurso(curso)) {
			return ResponseEntity.ok().body(curso);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao registrar curso.");
		}
		
	}
	
	@GetMapping(value = "/consultar", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> consultarCurso(@RequestParam("codigo") String codigoCurso){
		
		CursoDto cursoDto = this.cursoService.consultarCurso(codigoCurso);
		
		return ResponseEntity.ok().body(cursoDto);
	}
}
