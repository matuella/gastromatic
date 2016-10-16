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

import com.gmatuella.gastromatic.entity.Aula;
import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.entity.Receita;
import com.gmatuella.gastromatic.entity.Roteiro;
import com.gmatuella.gastromatic.repository.AulaRepository;
import com.gmatuella.gastromatic.repository.CursoRepository;
import com.gmatuella.gastromatic.repository.ReceitaRepository;
import com.gmatuella.gastromatic.repository.RoteiroRepository;

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
	public void findAula(@PathVariable(value = "receitaId") Long receitaId) {
		receitaRepo.findOne(receitaId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public void addAula(@RequestBody Receita receita) {
		receitaRepo.save(receita);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Receita> listAulas() {
		return (List<Receita>) receitaRepo.findAll();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Receita editAula(@RequestBody Receita receita) {
		return receitaRepo.save(receita);
	}

	@RequestMapping(value = "/delete/{receitaId}", method = RequestMethod.DELETE, consumes = "application/json")
	public void deleteAula(@PathVariable(value = "receitaId") Long receitaId) {
		receitaRepo.delete(receitaId);
	}

}
