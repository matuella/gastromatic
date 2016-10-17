package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.repository.CursoRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/curso")
public class CursoResource {

	@Autowired
	private CursoRepository cursoRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/find/{cursoId}", produces = "application/json")
	public Curso findCurso(@PathVariable(value = "cursoId") Long cursoId) {
		return cursoRepo.findOne(cursoId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Curso addCurso(@RequestBody Curso curso) {
		return cursoRepo.save(curso);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Curso> listCursos() {
		return cursoRepo.findAllByOrderByNomeAsc();
	}

	@RequestMapping(value = "/deleteCurso/{cursoId}", method = RequestMethod.DELETE)
	public void deleteCurso(@PathVariable(value = "cursoId") Long cursoId) {
		cursoRepo.delete(cursoId);
	}

}
