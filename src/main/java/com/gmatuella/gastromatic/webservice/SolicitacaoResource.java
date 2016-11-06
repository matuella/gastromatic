package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Solicitacao;
import com.gmatuella.gastromatic.repository.SolicitacaoRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/solicitacoes")
public class SolicitacaoResource {

	@Autowired
	private SolicitacaoRepository solicitacaoRepo;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Solicitacao> listSolicitacoes() {
		return (List<Solicitacao>) solicitacaoRepo.findAll();
	}

}
