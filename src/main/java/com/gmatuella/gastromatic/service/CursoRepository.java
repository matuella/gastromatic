package com.gmatuella.gastromatic.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gmatuella.gastromatic.entity.Curso;

@RepositoryRestResource
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long>{

//	public List<Curso> listAll() {
//		final EntityManager em = emf.createManager();
//		final List<Curso> allCursos = em.createQuery(("FROM " + Curso.class.getName())).getResultList();
//		return allCursos;
//	}
}
