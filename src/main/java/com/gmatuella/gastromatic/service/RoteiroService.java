package com.gmatuella.gastromatic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Roteiro;
import com.gmatuella.gastromatic.repository.RoteiroRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/roteiros")
public class RoteiroService {

	@Autowired
	private RoteiroRepository roteiroRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/{roteiroId}", produces = "application/json")
	public Roteiro findRoteiro(@PathVariable(value = "roteiroId") Long roteiroId)  {
		return roteiroRepo.findOne(roteiroId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Roteiro saveRoteiro(@RequestBody Roteiro roteiro) {
		return roteiroRepo.save(roteiro);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Roteiro> listRoteiros() {
		return (List<Roteiro>) roteiroRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{roteiroId}")
	public void deleteRoteiro(@PathVariable(value = "roteiroId") Long roteiroId) {
		roteiroRepo.delete(roteiroId);
	}

}
