package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.service.CursoRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/cursos")
public class CursoResource {

	@Autowired
	private CursoRepository cursoRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/findCurso/{cursoId}", produces = "application/json")
	public void findCurso(@RequestParam(value = "cursoId") Long cursoId) {
		cursoRepo.findOne(cursoId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addCurso", consumes = "application/json")
	public void addCurso(@RequestParam(value = "curso") Curso curso) {
		cursoRepo.save(curso);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listCursos", produces = "application/json")
	public List<Curso> listCursos() {
		return (List) cursoRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editCurso", produces = "application/json", consumes = "application/json")
	public Curso editCurso(@RequestParam(value = "curso") Curso curso) {
		return cursoRepo.save(curso);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCurso/{cursoId}", consumes = "application/json")
	public void deleteCurso(@RequestParam(value = "cursoId") Long cursoId) {
		cursoRepo.delete(cursoId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/teste", produces = "application/json")
	public Curso teste() {
		return new Curso();
	}

}
