package repository.implementations;

import model.User;
import repository.interfaces.UserRepository;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(name = "QuizMastersUnit")
    private EntityManager entityManager;

    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User getById(int id) {
        try {
            return entityManager.find(User.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    public User getByEmail(String email) {
        if (email == null) return null;
        email = email.trim().toLowerCase();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email =:email", User.class)
                .setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean insert(User user) {
        try {
            entityManager.persist(user);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean update(User user) {
        try {
            entityManager.merge(user);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean delete(User user) {
        try {
            entityManager.remove(user);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
