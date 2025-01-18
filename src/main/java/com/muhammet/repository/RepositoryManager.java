package com.muhammet.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class RepositoryManager<T> implements Repository<T>{
    private final EntityManagerFactory emf;
    private EntityManager em;
    public RepositoryManager(){
        emf = Persistence.createEntityManagerFactory("hr");
    }
    private void beginTransaction(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    private void commitTransaction(){
        em.getTransaction().commit();
        em.close();
    }
    public T save(T t) {
        beginTransaction();
        em.persist(t);
        commitTransaction();
        return t;
    }
    public T update(T t) {
        beginTransaction();
        em.merge(t);
        commitTransaction();
        return t;
    }
    public boolean delete(T t){
        beginTransaction();
        em.remove(t);
        commitTransaction();
        return true;
    }

    public boolean delete(Long id) {
        return false;
    }

    public List<T> findAll() {
        return List.of();
    }
}
