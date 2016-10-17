package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Aula;
import com.gmatuella.gastromatic.repository.AulaRepository;

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
	public Aula findAula(@PathVariable(value = "aulaId") Long aulaId) {
		return aulaRepo.findOne(aulaId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Aula addAula(@RequestBody Aula aula) {
		return aulaRepo.save(aula);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Aula> listAulas() {
		return (List<Aula>) aulaRepo.findAll();
	}

	@RequestMapping(value = "/delete/{aulaId}", method = RequestMethod.DELETE)
	public void deleteAula(@PathVariable(value = "aulaId") Long aulaId) {
		aulaRepo.delete(aulaId);
	}

}
