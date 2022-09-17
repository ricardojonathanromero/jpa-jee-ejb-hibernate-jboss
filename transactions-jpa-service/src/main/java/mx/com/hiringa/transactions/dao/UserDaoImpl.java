package mx.com.hiringa.transactions.dao;

import mx.com.hiringa.transactions.domain.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("unchecked")
@Stateless
public class UserDaoImpl implements UserDao {
    @PersistenceContext(name = "persistence")
    EntityManager em;

    @Override
    public List<User> findAll() { return em.createNamedQuery("FindAllUsers").getResultList(); }

    @Override
    public void createUser(User user) { em.persist(user); }

    @Override
    public void updateUser(User user) { em.merge(user); }

    @Override
    public void deleteUser(User user) { em.remove(em.merge(user)); }
}
