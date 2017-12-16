package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private int userId;
    private String fname;
    private String sname;
    private String email;
    private String password;
    private Collection<Question> questionsByUserId;
    private Collection<Quiz> quizzesByUserId;

    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "fname", insertable = false, updatable = false)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "sname", insertable = false, updatable = false)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "email", insertable = false, updatable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", insertable = false, updatable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (fname != null ? !fname.equals(user.fname) : user.fname != null) return false;
        if (sname != null ? !sname.equals(user.sname) : user.sname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Question> getQuestionsByUserId() {
        return questionsByUserId;
    }

    public void setQuestionsByUserId(Collection<Question> questionsByUserId) {
        this.questionsByUserId = questionsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Quiz> getQuizzesByUserId() {
        return quizzesByUserId;
    }

    public void setQuizzesByUserId(Collection<Quiz> quizzesByUserId) {
        this.quizzesByUserId = quizzesByUserId;
    }
}
