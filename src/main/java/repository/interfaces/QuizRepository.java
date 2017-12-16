package repository.interfaces;

import model.Quiz;

import java.util.List;

public interface QuizRepository {

    List<Quiz> getAll();

    Quiz getById(int id);

    List<Quiz> getListByUserId(int userId);

    Quiz getByName(String name);

    boolean insert(Quiz quiz);

    boolean update(Quiz quiz);

    boolean delete(Quiz quiz);

}
