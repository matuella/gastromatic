package com.gmatuella.gastromatic.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gmatuella.gastromatic.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long>{

//	public List<Curso> listAll() {
//		final EntityManager em = emf.createManager();
//		final List<Curso> allCursos = em.createQuery(("FROM " + Curso.class.getName())).getResultList();
//		return allCursos;
//	}
}
