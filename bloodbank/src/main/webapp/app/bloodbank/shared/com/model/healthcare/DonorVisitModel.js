Ext.define('Bloodbank.bloodbank.shared.com.model.healthcare.DonorVisitModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "visitId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "donationtype",
          "reference": "DonationType",
          "defaultValue": ""
     }, {
          "name": "donorid",
          "reference": "RegisterADonor",
          "defaultValue": ""
     }, {
          "name": "orgnizerName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "campAddress",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "city",
          "reference": "City",
          "defaultValue": ""
     }, {
          "name": "campid",
          "reference": "RegisterACamp",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "ClinicalInfo",
          "reference": "ClinicalInfoModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});