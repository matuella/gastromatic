package com.gmatuella.gastromatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Solicitacao;

@RepositoryRestResource
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

}
