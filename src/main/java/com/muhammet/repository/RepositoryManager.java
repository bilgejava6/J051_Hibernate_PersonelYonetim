package com.muhammet.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

    public List<T> findAll(T t) {
        /**
         * Select * from tbl?????
         */
        beginTransaction();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // bir sorgu oluşturmak için kullanılacak entity istiyor. (Tablo seçildi)
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) cb.createQuery(t.getClass());
        // select (*), fields
        Root<T> root = (Root<T>) criteriaQuery.from(t.getClass()); // from table
        // select * from table
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
