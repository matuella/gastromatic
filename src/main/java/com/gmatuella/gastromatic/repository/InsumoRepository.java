package com.gmatuella.gastromatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Insumo;

@RepositoryRestResource
public interface InsumoRepository extends JpaRepository<Insumo, Long>{

}