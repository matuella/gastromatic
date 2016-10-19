package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Requisicao;
import com.gmatuella.gastromatic.repository.RequisicaoRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/requisicoes")
public class RequisicaoResource {

	@Autowired
	private RequisicaoRepository reqRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/{reqId}", produces = "application/json")
	public void findRequisicao(@PathVariable(value = "reqId") Long reqId) {
		reqRepo.findOne(reqId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Requisicao saveRequisicao(@RequestBody Requisicao req) {
		return reqRepo.save(req);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Requisicao> listRequisicoes() {
		return (List<Requisicao>) reqRepo.findAll();
	}

}
