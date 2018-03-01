/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placementcell;

/**
 *
 * @author Admin
 */
class CsQuiz {
    int id;
    String question,option1,option2,option3,option4;
    int Answer;
    int correctAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return question;
    }

    public void setQname(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        this.Answer = answer;
    }
    public int getcorrectAnswer(){
        return correctAnswer;
    }
    public void setcorrectAnswer(int correctAnswer){
        this.correctAnswer=correctAnswer;
    }
    
}
