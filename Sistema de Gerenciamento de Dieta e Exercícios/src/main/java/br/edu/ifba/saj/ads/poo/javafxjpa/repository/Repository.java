package br.edu.ifba.saj.ads.poo.javafxjpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

import br.edu.ifba.saj.ads.poo.javafxjpa.Classes.Usuario;

public class Repository {

    private EntityManagerFactory sessionFactory;

    public Repository() {
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setUp() throws Exception {
        sessionFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public Usuario create(Usuario usuario) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuario;
    }

    public Usuario read(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        return entityManager.find(Usuario.class, id);
    }

    public List<Usuario> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public Usuario update(Usuario usuario) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        usuario = entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return usuario;
    }

    public void delete(Usuario usuario) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        usuario = entityManager.merge(usuario);
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Long count() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Usuario.class)));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
