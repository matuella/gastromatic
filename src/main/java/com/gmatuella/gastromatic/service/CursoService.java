package com.gmatuella.gastromatic.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.util.EMFactory;

@Service
public class CursoService {
	
	private EMFactory emf;
	
	public CursoService(){
		this.emf = EMFactory.getInstance();
	}

	public void save(final Curso curso) {
		final EntityManager em = emf.createManager();
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
		em.close();
	}

	public void edit(final Curso curso) {
		final EntityManager em = emf.createManager();
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(final Curso curso) {
		emf.createManager().remove(curso);
	}

	public Curso find(final Integer cursoId) {
		return emf.createManager().find(Curso.class, cursoId);
	}

	public List<Curso> listAll() {
		final EntityManager em = emf.createManager();
		final List<Curso> allCursos = em.createQuery(("FROM " + Curso.class.getName())).getResultList();
		return allCursos;
	}
}
