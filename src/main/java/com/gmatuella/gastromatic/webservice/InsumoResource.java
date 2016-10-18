package com.gmatuella.gastromatic.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmatuella.gastromatic.entity.Insumo;
import com.gmatuella.gastromatic.repository.InsumoRepository;

/**
 * REST Web Service
 *
 * @author Guilherme Matuella
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/insumos")
public class InsumoResource {

	@Autowired
	private InsumoRepository insumoRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/{insumoId}", produces = "application/json")
	public Insumo findInsumo(@PathVariable(value = "insumoId") Long insumoId) {
		return insumoRepo.findOne(insumoId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Insumo saveInsumo(@RequestBody Insumo insumo) {
		return insumoRepo.save(insumo);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Insumo> listInsumos() {
		return (List<Insumo>) insumoRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{insumoId}")
	public void deleteInsumo(@PathVariable(value = "insumoId") Long insumoId) {
		insumoRepo.delete(insumoId);
	}

}
