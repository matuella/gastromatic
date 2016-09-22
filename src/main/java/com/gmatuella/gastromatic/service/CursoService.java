package com.gmatuella.gastromatic.service;

import com.gmatuella.gastromatic.entity.Curso;
import com.gmatuella.gastromatic.util.EMFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Guilherme Matuella
 */
@Stateless
@XmlRootElement
public class CursoService {

    private final EMFactory emf;

    public CursoService() {
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
    
    public Curso find(final Curso curso) {
        return emf.createManager().find(Curso.class, curso.getId());
    }

    public List<Curso> listAll() {
        final EntityManager em = emf.createManager();
        final List<Curso> allCursos = em.createQuery(("FROM " + Curso.class.getName())).getResultList();
        return allCursos;
    }
}
