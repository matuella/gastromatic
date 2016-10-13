package com.gmatuella.gastromatic.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Curso;

@RepositoryRestResource
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long>{

	public List<Curso> findAllByOrderByNomeAsc();
}