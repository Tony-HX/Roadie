package com.tony.roadie;

public class Question {
    private String question;
    private int image;
    //item1 needs to be the right answer
    private String item1;
    private String item2;
    private String item3;
    private String item4;

    public Question(String question, int image, String item1, String item2, String item3, String item4) {
        this.question = question;
        this.image = image;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
    }

    public String getQuestion() {
        return question;
    }

    public int getImage() {
        return image;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public String getItem3() {
        return item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }
}
