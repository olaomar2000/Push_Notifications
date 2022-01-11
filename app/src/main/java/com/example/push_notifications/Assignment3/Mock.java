package com.example.push_notifications.Assignment3;

public class Assignment3 {
    iEvaluation ievaluation;

    public iEvaluation getIevaluation() {
        return ievaluation;
    }

    public void setIevaluation(iEvaluation ievaluation) {
        this.ievaluation = ievaluation;
    }

    public String getEvaluation(int x) {
        return "Result is : "+  ievaluation.evaluationForGrade(x);
    }


}
