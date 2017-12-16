package repository.interfaces;

import model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    User getById(int id);

    User getByEmail(String email);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(User user);


}
