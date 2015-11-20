Ext.define('Surveyportal.surveyportal.shared.com.survey.model.healthcare.SurveyScoreModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "surveyScoreId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userid",
          "reference": "User",
          "defaultValue": ""
     }, {
          "name": "grouptype",
          "reference": "SurveyQuestionGroup",
          "defaultValue": ""
     }, {
          "name": "score",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "points",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "surveyDate",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});