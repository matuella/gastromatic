package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
	@Autowired
	private CursoRepository cursoRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/find/{roteiroId}", produces = "application/json")
	public void findCurso(@RequestParam(value = "roteiroId") Long roteiroId) {
		roteiroRepo.findOne(roteiroId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public void addRoteiro(@RequestBody Roteiro roteiro) {
		roteiroRepo.save(roteiro);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Roteiro> listRoteiros() {
		return (List<Roteiro>) roteiroRepo.findAll();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Roteiro editRoteiro(@RequestBody Roteiro roteiro) {
		return roteiroRepo.save(roteiro);
	}

	@RequestMapping(value = "/delete/{roteiroId}", method = RequestMethod.DELETE, consumes = "application/json")
	public void deleteRoteiro(@RequestParam(value = "roteiroId") Long roteiroId) {
		roteiroRepo.delete(roteiroId);
	}

}
