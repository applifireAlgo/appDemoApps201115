package com.survey.app.shared.healthcare;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Date;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.survey.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.survey.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_SurveyScore_M")
@Entity
@NamedQueries({ @javax.persistence.NamedQuery(name = "SurveyScore.findByUserId", query = "select e from SurveyScore e where e.systemInfo.activeStatus=1 and e.userId=:userId"), @javax.persistence.NamedQuery(name = "SurveyScore.findByGroupType", query = "select e from SurveyScore e where e.systemInfo.activeStatus=1 and e.groupType=:groupType"), @javax.persistence.NamedQuery(name = "SurveyScore.findById", query = "select e from SurveyScore e where e.systemInfo.activeStatus=1 and e.surveyScoreId =:surveyScoreId") })
public class SurveyScore implements Serializable, CommonEntityInterface, Comparator<SurveyScore> {

    @Column(name = "score")
    @JsonProperty("score")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer score;

    @Column(name = "points")
    @JsonProperty("points")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer points;

    @Column(name = "surveyDate")
    @JsonProperty("surveyDate")
    @NotNull
    private Date surveyDate;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "surveyScoreId")
    @JsonProperty("surveyScoreId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String surveyScoreId;

    @Column(name = "userId")
    @JsonProperty("userId")
    private String userId;

    @Column(name = "groupType")
    @JsonProperty("groupType")
    private Integer groupType;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer _score) {
        if (_score != null) {
            this.score = _score;
        }
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer _points) {
        if (_points != null) {
            this.points = _points;
        }
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date _surveyDate) {
        if (_surveyDate != null) {
            this.surveyDate = _surveyDate;
        }
    }

    public String getPrimaryKey() {
        return surveyScoreId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return surveyScoreId;
    }

    public String getSurveyScoreId() {
        return surveyScoreId;
    }

    public void setSurveyScoreId(String _surveyScoreId) {
        this.surveyScoreId = _surveyScoreId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String _userId) {
        this.userId = _userId;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer _groupType) {
        this.groupType = _groupType;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(SurveyScore object1, SurveyScore object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (surveyScoreId == null) {
            return super.hashCode();
        } else {
            return surveyScoreId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.survey.app.shared.healthcare.SurveyScore other = (com.survey.app.shared.healthcare.SurveyScore) obj;
            if (surveyScoreId == null) {
                return false;
            } else if (!surveyScoreId.equals(other.surveyScoreId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}