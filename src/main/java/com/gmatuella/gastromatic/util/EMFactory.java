package com.gmatuella.gastromatic.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Guilherme Matuella
 */
public final class EMFactory {

    private static EMFactory instance;
    private final EntityManagerFactory factory;

    public static synchronized EMFactory getInstance() {
        if (instance == null) {
            instance = new EMFactory();
        }
        return instance;
    }

    private EMFactory() {
        this.factory = Persistence.createEntityManagerFactory("GastromaticPU");
    }

    public EntityManager createManager() {
        return factory.createEntityManager();
    }

}
