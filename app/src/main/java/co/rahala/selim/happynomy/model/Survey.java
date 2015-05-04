package co.rahala.selim.happynomy.model;

/**
 * Created by aselims on 02/05/15.
 */
public class Survey {

    private int image;
    private String question;
    private String answer;

    public Survey(int image, String question) {
        this.image = image;
        this.question = question;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
