package com.gmatuella.gastromatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Receita;

@RepositoryRestResource
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}