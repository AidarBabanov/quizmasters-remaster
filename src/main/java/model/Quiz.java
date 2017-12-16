package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Quiz {
    private int quizId;
    private String quizName;
    private int userId;
    private Collection<Question> questionsByQuizId;
    private User userByUserId;

    @Id
    @Column(name = "quiz_id", insertable = false, updatable = false)
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Basic
    @Column(name = "quiz_name", insertable = false, updatable = false)
    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quiz quiz = (Quiz) o;

        if (quizId != quiz.quizId) return false;
        if (userId != quiz.userId) return false;
        if (quizName != null ? !quizName.equals(quiz.quizName) : quiz.quizName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quizId;
        result = 31 * result + (quizName != null ? quizName.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @OneToMany(mappedBy = "quizByQuizId")
    public Collection<Question> getQuestionsByQuizId() {
        return questionsByQuizId;
    }

    public void setQuestionsByQuizId(Collection<Question> questionsByQuizId) {
        this.questionsByQuizId = questionsByQuizId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
