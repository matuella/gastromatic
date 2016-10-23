package com.gmatuella.gastromatic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Receita;
import com.gmatuella.gastromatic.repository.ReceitaRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/receitas")
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/{receitaId}", produces = "application/json")
	public Receita findReceita(@PathVariable(value = "receitaId") Long receitaId) {
		return receitaRepo.findOne(receitaId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Receita saveReceita(@RequestBody Receita receita) {
		return receitaRepo.save(receita);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Receita> listReceitas() {
		return (List<Receita>) receitaRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{receitaId}")
	public void deleteReceita(@PathVariable(value = "receitaId") Long receitaId) {
		receitaRepo.delete(receitaId);
	}

}
