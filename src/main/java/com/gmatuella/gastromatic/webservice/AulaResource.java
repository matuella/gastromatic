package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Aula;
import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.entity.Roteiro;
import com.gmatuella.gastromatic.repository.AulaRepository;
import com.gmatuella.gastromatic.repository.CursoRepository;
import com.gmatuella.gastromatic.repository.RoteiroRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/aula")
public class AulaResource {

	@Autowired
	private AulaRepository aulaRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/find/{aulaId}", produces = "application/json")
	public void findAula(@RequestParam(value = "aulaId") Long aulaId) {
		aulaRepo.findOne(aulaId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public void addAula(@RequestBody Aula aula) {
		aulaRepo.save(aula);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Aula> listAulas() {
		return (List<Aula>) aulaRepo.findAll();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Aula editAula(@RequestBody Aula aula) {
		return aulaRepo.save(aula);
	}

	@RequestMapping(value = "/delete/{aulaId}", method = RequestMethod.DELETE, consumes = "application/json")
	public void deleteAula(@RequestParam(value = "aulaId") Long aulaId) {
		aulaRepo.delete(aulaId);
	}

}
