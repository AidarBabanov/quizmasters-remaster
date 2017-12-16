package repository.implementations;

import model.Quiz;
import repository.interfaces.QuizRepository;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class QuizRepositoryImpl implements QuizRepository {

    @PersistenceContext(name = "QuizMastersUnit")
    private EntityManager entityManager;

    public List<Quiz> getAll() {
        TypedQuery<Quiz> query = entityManager.createQuery("SELECT q FROM Quiz q", Quiz.class);
        return query.getResultList();
    }

    public Quiz getById(int id) {
        try {
            return entityManager.find(Quiz.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Quiz> getListByUserId(int userId) {
        TypedQuery<Quiz> query = entityManager.createQuery("SELECT q FROM Quiz q WHERE q.userId = :userId", Quiz.class)
                .setParameter("userId", userId);
        return query.getResultList();
    }

    public Quiz getByName(String name) {
        TypedQuery<Quiz> query = entityManager.createQuery("SELECT q FROM Quiz q WHERE q.quizName = :quizName", Quiz.class)
                .setParameter("quizName", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean insert(Quiz quiz) {
        try {
            entityManager.persist(quiz);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean update(Quiz quiz) {
        try {
            entityManager.merge(quiz);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean delete(Quiz quiz) {
        try {
            entityManager.remove(quiz);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
