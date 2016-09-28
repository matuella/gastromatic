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
import com.gmatuella.gastromatic.entity.Requisicao;
import com.gmatuella.gastromatic.service.CursoRepository;
import com.gmatuella.gastromatic.service.RequisicaoRepository;

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
	public void findRequisicao(@RequestParam(value = "reqId") Long reqId) {
		reqRepo.findOne(reqId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void addRequisicao(@RequestBody Requisicao req) {
		reqRepo.save(req);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Requisicao> listRequisicoes() {
		return (List) reqRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Requisicao editCurso(@RequestBody Requisicao req) {
		return reqRepo.save(req);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{reqId}", consumes = "application/json")
	public void deleteCurso(@RequestParam(value = "reqId") Long reqId) {
		reqRepo.delete(reqId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/teste", produces = "application/json")
	public Requisicao teste() {
		return new Requisicao();
	}

}
