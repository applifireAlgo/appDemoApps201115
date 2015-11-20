Ext.define('Surveyportal.surveyportal.shared.com.survey.model.authentication.UserAccessDomainModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessDomainId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessDomain",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "domainName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "domainDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "domainHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "domainIcon",
          "type": "string",
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