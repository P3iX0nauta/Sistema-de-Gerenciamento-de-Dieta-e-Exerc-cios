package br.edu.ifba.saj.ads.poo.javafxjpa.Classes;

import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.EmailJaCadastradoException;
import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.SenhaIncorretaException;
import br.edu.ifba.saj.ads.poo.javafxjpa.Exceptions.UsuarioNaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UsuarioDAO {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static void salvarUsuario(Usuario usuario) throws EmailJaCadastradoException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // ver se o email já está cadastrado
        if (emailJaCadastrado(usuario.getEmail())) {
            throw new EmailJaCadastradoException("Este email já está cadastrado.");
        }

        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static boolean emailJaCadastrado(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);

        Long count = query.getSingleResult();
        entityManager.close();

        return count > 0;
    }

    public static Usuario autenticarUsuario(String email, String senha) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
        query.setParameter("email", email);

        Usuario usuario;
        try {
            usuario = query.getSingleResult();
        } catch (NoResultException ex) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }

        if (!usuario.getSenha().equals(senha)) {
            throw new SenhaIncorretaException("Senha incorreta.");
        }

        entityManager.close();
        return usuario;
    }
}
