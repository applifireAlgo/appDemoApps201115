DROP TABLE IF EXISTS `ast_BloodStock_T`;

CREATE TABLE `ast_BloodStock_T` ( `bloodStockId` VARCHAR(256) NOT NULL, `donarId` VARCHAR(256) NOT NULL, `bloodGroupId` VARCHAR(256) NOT NULL, `noOfUnits` INT(10) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`bloodStockId`));

