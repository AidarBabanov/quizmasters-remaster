package repository.interfaces;

import model.Question;

import java.util.List;

public interface QuestionRepository {

    List<Question> getAll();

    Question getById(int id);

    List<Question> getByUserId(int userId);

    List<Question> getByQuizId(int quizId);

    boolean insert(Question question);

    boolean update(Question question);

    boolean delete(Question question);
}
