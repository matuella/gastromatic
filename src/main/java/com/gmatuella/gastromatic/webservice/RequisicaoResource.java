package com.gmatuella.gastromatic.webservice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Requisicao;
import com.gmatuella.gastromatic.entity.RequisicaoInsumo;
import com.gmatuella.gastromatic.entity.Solicitacao;
import com.gmatuella.gastromatic.repository.InsumoRepository;
import com.gmatuella.gastromatic.repository.RequisicaoInsumoRepository;
import com.gmatuella.gastromatic.repository.RequisicaoRepository;
import com.gmatuella.gastromatic.repository.SolicitacaoRepository;

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
	private RequisicaoRepository requisicaoRepo;
	@Autowired
	private SolicitacaoRepository solicitacaoRepo;
	@Autowired
	private RequisicaoInsumoRepository reqInsRepo;
	@Autowired
	private InsumoRepository insumoRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/{reqId}", produces = "application/json")
	public void findRequisicao(@PathVariable(value = "reqId") Long reqId) {
		requisicaoRepo.findOne(reqId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void saveRequisicao(@RequestBody List<RequisicaoInsumo> requisicoesInsumo) {

		Requisicao requisicao = new Requisicao();
		requisicao.setDataRequisicao(LocalDateTime.now());
		Requisicao persistedRequisicao = requisicaoRepo.save(requisicao);
		
		Solicitacao persistedSolicitacao = solicitacaoRepo.save(new Solicitacao());
		
		requisicoesInsumo.forEach(reqIns -> {
			reqIns.setInsumo(insumoRepo.findOne(reqIns.getInsumo().getId()));
			reqIns.setRequisicao(persistedRequisicao);
			reqIns.setSolicitacao(persistedSolicitacao);
			
			reqInsRepo.save(reqIns);
		});
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Requisicao> listRequisicoes() {
		return (List<Requisicao>) requisicaoRepo.findAll();
	}

}
