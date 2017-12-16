package repository.implementations;

import model.Question;
import repository.interfaces.QuestionRepository;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class QuestionRepositoryImpl implements QuestionRepository {

    @PersistenceContext(name = "QuizMastersUnit")
    private EntityManager entityManager;

    public List<Question> getAll() {
        TypedQuery<Question> query = entityManager.createQuery("SELECT q FROM Question q", Question.class);
        return query.getResultList();
    }

    public Question getById(int id) {
        try {
            return entityManager.find(Question.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Question> getByUserId(int userId) {
        TypedQuery<Question> query = entityManager.createQuery("SELECT q FROM Quiz q WHERE q.userId = :userId", Question.class)
                .setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Question> getByQuizId(int quizId) {
        TypedQuery<Question> query = entityManager.createQuery("SELECT q FROM Quiz q WHERE q.quizId = :quizId", Question.class)
                .setParameter("quizId", quizId);
        return query.getResultList();
    }

    public boolean insert(Question question) {
        try {
            entityManager.persist(question);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean update(Question question) {
        try {
            entityManager.merge(question);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public boolean delete(Question question) {
        try {
            entityManager.remove(question);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
}
