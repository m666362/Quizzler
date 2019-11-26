package com.example.quizzler;

public class truefalse {

    private int mQuestionid;
    private boolean mAnswer;

    public truefalse(int questionresourceid, boolean trueorfalse){

        mQuestionid = questionresourceid;
        mAnswer = trueorfalse;
    }

    public int getmQuestionid() {
        return mQuestionid;
    }

    public void setmQuestionid(int mQuestionid) {
        this.mQuestionid = mQuestionid;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
