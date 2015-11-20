package com.survey.app.shared.healthcontext.healthcare;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SurveyResultDTO {

    private String surveyQuestionId;

    private String surveyAnswerId;

    public String getSurveyQuestionId() {
        return surveyQuestionId;
    }

    public void setSurveyQuestionId(String _surveyQuestionId) {
        this.surveyQuestionId = _surveyQuestionId;
    }

    public String getSurveyAnswerId() {
        return surveyAnswerId;
    }

    public void setSurveyAnswerId(String _surveyAnswerId) {
        this.surveyAnswerId = _surveyAnswerId;
    }
}
