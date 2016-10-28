package com.gmatuella.gastromatic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Curso;

@RepositoryRestResource
public interface CursoRepository extends JpaRepository<Curso, Long>{

	public List<Curso> findAllByOrderByNomeAsc();
}