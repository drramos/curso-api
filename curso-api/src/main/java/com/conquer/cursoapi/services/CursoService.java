package com.conquer.cursoapi.services;

import org.springframework.stereotype.Service;

import com.conquer.conquerutils.dto.CursoDto;

@Service
public class CursoService {

	public boolean registrarCurso(CursoDto curso) {
//		Aqui ficara a classe de negócio que validará os dados informados, 
//		criará uma entidade e subsequentemente efetuará a inclusão através da persistência
		return true;
		
	}
	
	public CursoDto consultarCurso(String codigoCurso) {
		CursoDto cursoDto = new CursoDto();
//		Aqui ficará a chamada à classe de negócio ou persistência necessária para buscar o curso na base de dados
		
		return cursoDto;
	}
}
