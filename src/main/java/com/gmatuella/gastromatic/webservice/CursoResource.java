package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.service.CursoService;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@RequestMapping("curso")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	public CursoResource() {
	}

	@RequestMapping(method = RequestMethod.GET, name = "/addCurso/{cursoId}", produces = "application/json")
	public void findCurso(@RequestParam(value = "cursoId") Integer cursoId) {
		cursoService.find(cursoId);
	}	
	
	@RequestMapping(method = RequestMethod.POST, name = "/addCurso", consumes = "application/json")
	public void addCurso(@RequestParam(value = "curso") Curso curso) {
		cursoService.save(curso);
	}

	@RequestMapping(method = RequestMethod.GET, name = "/listCursos", produces = "application/json")
	public List<Curso> listCursos() {
		return cursoService.listAll();
	}

	@RequestMapping(method = RequestMethod.POST, name = "/editCurso", consumes = "application/json")
	public void editCurso(@RequestParam(value = "curso") Curso curso) {
		cursoService.edit(curso);
	}

	@RequestMapping(method = RequestMethod.DELETE, name = "/deleteCurso/{cursoId}", consumes = "application/json")
	public void deleteCurso(@RequestParam(value = "cursoId") Integer cursoId){
		cursoService.delete(cursoService.find(cursoId));
	}
	
	@RequestMapping("/teste")
	public String teste() {
		return "teste";
	}

}
