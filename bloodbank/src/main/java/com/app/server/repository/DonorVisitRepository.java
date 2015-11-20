package com.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "12", comments = "Repository for DonorVisit Transaction table", complexity = Complexity.MEDIUM)
public interface DonorVisitRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public List<T> findByDonationType(String donationType) throws Exception, SpartanPersistenceException;

    public List<T> findByDonorId(String donorId) throws Exception, SpartanPersistenceException;

    public List<T> findByCity(String city) throws Exception, SpartanPersistenceException;

    public List<T> findByCampId(String campId) throws Exception, SpartanPersistenceException;

    public T findById(String visitId) throws Exception, SpartanPersistenceException;
}
