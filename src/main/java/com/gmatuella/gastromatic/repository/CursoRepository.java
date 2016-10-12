package com.gmatuella.gastromatic.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Curso;

@RepositoryRestResource
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long>{

}
