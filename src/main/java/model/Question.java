package model;

import javax.persistence.*;

@Entity
public class Question {
    private int questionId;
    private String questionTxt;
    private String answer1Txt;
    private String answer2Txt;
    private String answer3Txt;
    private String answer4Txt;
    private int rightAnswerPosition;
    private int quizId;
    private int userId;
    private Quiz quizByQuizId;
    private User userByUserId;

    @Id
    @Column(name = "question_id", insertable = false, updatable = false)
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "question_txt", insertable = false, updatable = false)
    public String getQuestionTxt() {
        return questionTxt;
    }

    public void setQuestionTxt(String questionTxt) {
        this.questionTxt = questionTxt;
    }

    @Basic
    @Column(name = "answer_1_txt", insertable = false, updatable = false)
    public String getAnswer1Txt() {
        return answer1Txt;
    }

    public void setAnswer1Txt(String answer1Txt) {
        this.answer1Txt = answer1Txt;
    }

    @Basic
    @Column(name = "answer_2_txt", insertable = false, updatable = false)
    public String getAnswer2Txt() {
        return answer2Txt;
    }

    public void setAnswer2Txt(String answer2Txt) {
        this.answer2Txt = answer2Txt;
    }

    @Basic
    @Column(name = "answer_3_txt", insertable = false, updatable = false)
    public String getAnswer3Txt() {
        return answer3Txt;
    }

    public void setAnswer3Txt(String answer3Txt) {
        this.answer3Txt = answer3Txt;
    }

    @Basic
    @Column(name = "answer_4_txt", insertable = false, updatable = false)
    public String getAnswer4Txt() {
        return answer4Txt;
    }

    public void setAnswer4Txt(String answer4Txt) {
        this.answer4Txt = answer4Txt;
    }

    @Basic
    @Column(name = "right_answer_position", insertable = false, updatable = false)
    public int getRightAnswerPosition() {
        return rightAnswerPosition;
    }

    public void setRightAnswerPosition(int rightAnswerPosition) {
        this.rightAnswerPosition = rightAnswerPosition;
    }

    @Basic
    @Column(name = "quiz_id", insertable = false, updatable = false)
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
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

        Question question = (Question) o;

        if (questionId != question.questionId) return false;
        if (rightAnswerPosition != question.rightAnswerPosition) return false;
        if (quizId != question.quizId) return false;
        if (userId != question.userId) return false;
        if (questionTxt != null ? !questionTxt.equals(question.questionTxt) : question.questionTxt != null)
            return false;
        if (answer1Txt != null ? !answer1Txt.equals(question.answer1Txt) : question.answer1Txt != null) return false;
        if (answer2Txt != null ? !answer2Txt.equals(question.answer2Txt) : question.answer2Txt != null) return false;
        if (answer3Txt != null ? !answer3Txt.equals(question.answer3Txt) : question.answer3Txt != null) return false;
        if (answer4Txt != null ? !answer4Txt.equals(question.answer4Txt) : question.answer4Txt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (questionTxt != null ? questionTxt.hashCode() : 0);
        result = 31 * result + (answer1Txt != null ? answer1Txt.hashCode() : 0);
        result = 31 * result + (answer2Txt != null ? answer2Txt.hashCode() : 0);
        result = 31 * result + (answer3Txt != null ? answer3Txt.hashCode() : 0);
        result = 31 * result + (answer4Txt != null ? answer4Txt.hashCode() : 0);
        result = 31 * result + rightAnswerPosition;
        result = 31 * result + quizId;
        result = 31 * result + userId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id", nullable = false)
    public Quiz getQuizByQuizId() {
        return quizByQuizId;
    }

    public void setQuizByQuizId(Quiz quizByQuizId) {
        this.quizByQuizId = quizByQuizId;
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
