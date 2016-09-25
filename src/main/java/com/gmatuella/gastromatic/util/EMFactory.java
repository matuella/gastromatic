package com.gmatuella.gastromatic.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Scope;

/**
 * @author Guilherme Matuella
 */
public final class EMFactory {

	private static final String PERSISTENCE_UNIT = "gPU";
    private static EMFactory instance;
    private final EntityManagerFactory factory;

    public static synchronized EMFactory getInstance() {
        if (instance == null) {
            instance = new EMFactory();
        }
        return instance;
    }

    private EMFactory() {
        this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    public EntityManager createManager() {
        return factory.createEntityManager();
    }

}
