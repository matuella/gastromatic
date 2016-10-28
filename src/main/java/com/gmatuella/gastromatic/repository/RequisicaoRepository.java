package com.gmatuella.gastromatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Requisicao;

@RepositoryRestResource
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long>{

}
