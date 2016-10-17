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
import com.gmatuella.gastromatic.entity.Roteiro;
import com.gmatuella.gastromatic.repository.CursoRepository;
import com.gmatuella.gastromatic.repository.RoteiroRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/roteiro")
public class RoteiroResource {

	@Autowired
	private RoteiroRepository roteiroRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/find/{roteiroId}", produces = "application/json")
	public Roteiro findRoteiro(@PathVariable(value = "roteiroId") Long roteiroId)  {
		return roteiroRepo.findOne(roteiroId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Roteiro addRoteiro(@RequestBody Roteiro roteiro) {
		return roteiroRepo.save(roteiro);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Roteiro> listRoteiros() {
		return (List<Roteiro>) roteiroRepo.findAll();
	}

	@RequestMapping(value = "/delete/{roteiroId}", method = RequestMethod.DELETE)
	public void deleteRoteiro(@PathVariable(value = "roteiroId") Long roteiroId) {
		roteiroRepo.delete(roteiroId);
	}

}
