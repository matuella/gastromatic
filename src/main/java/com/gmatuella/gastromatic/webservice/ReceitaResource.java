package com.gmatuella.gastromatic.webservice;

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
@RequestMapping(value = "/receita")
public class ReceitaResource {

	@Autowired
	private ReceitaRepository receitaRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/find/{receitaId}", produces = "application/json")
	public Receita findReceita(@PathVariable(value = "receitaId") Long receitaId) {
		return receitaRepo.findOne(receitaId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Receita addReceita(@RequestBody Receita receita) {
		return receitaRepo.save(receita);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Receita> listReceitas() {
		return (List<Receita>) receitaRepo.findAll();
	}

	@RequestMapping(value = "/delete/{receitaId}", method = RequestMethod.DELETE)
	public void deleteReceita(@PathVariable(value = "receitaId") Long receitaId) {
		receitaRepo.delete(receitaId);
	}

}
