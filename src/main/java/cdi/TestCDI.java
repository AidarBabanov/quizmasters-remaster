package cdi;

import model.User;
import repository.interfaces.UserRepository;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TestCDI {

    @EJB
    private UserRepository userRepository;

    public String text(){
        User aidar = userRepository.getById(1);
        return aidar.getEmail();
    }

}
