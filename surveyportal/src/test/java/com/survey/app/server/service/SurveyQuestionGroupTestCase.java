package com.survey.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.survey.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.survey.app.server.repository.SurveyQuestionGroupRepository;
import com.survey.app.shared.healthcare.SurveyQuestionGroup;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class SurveyQuestionGroupTestCase {

    @Autowired
    private SurveyQuestionGroupRepository<SurveyQuestionGroup> surveyquestiongroupRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            SurveyQuestionGroup surveyquestiongroup = new SurveyQuestionGroup();
            surveyquestiongroup.setSurveyQuestionGroupDesc("AZAGltIgTh84ncvYqbPwSNMq6pHlvpWTLkZd2HHDDEJo3D9E5a");
            surveyquestiongroup.setSurveyQuestionGroupName("NRdcVr4HUvoTMdJKnAJ3kCGBI8Sv3HRGbLO3KQboTuaB2DLFMG");
            surveyquestiongroup.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            surveyquestiongroup.setEntityValidator(entityValidator);
            surveyquestiongroup.isValid();
            surveyquestiongroupRepository.save(surveyquestiongroup);
            map.put("SurveyQuestionGroupPrimaryKey", surveyquestiongroup._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("SurveyQuestionGroupPrimaryKey"));
            SurveyQuestionGroup surveyquestiongroup = surveyquestiongroupRepository.findById((java.lang.Integer) map.get("SurveyQuestionGroupPrimaryKey"));
            surveyquestiongroup.setSurveyQuestionGroupDesc("x8P5OYcHtJc4MnuLnmleLSz8H2HGZNdJI2v2jz8AiGOr6DHQKu");
            surveyquestiongroup.setSurveyQuestionGroupName("gbWptYMuB0NepGd1TEdiRrmFCYHVEuyhEFdjYvYAL3x9lNjcJg");
            surveyquestiongroup.setVersionId(1);
            surveyquestiongroup.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            surveyquestiongroupRepository.update(surveyquestiongroup);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("SurveyQuestionGroupPrimaryKey"));
            surveyquestiongroupRepository.findById((java.lang.Integer) map.get("SurveyQuestionGroupPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("SurveyQuestionGroupPrimaryKey"));
            surveyquestiongroupRepository.delete((java.lang.Integer) map.get("SurveyQuestionGroupPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
