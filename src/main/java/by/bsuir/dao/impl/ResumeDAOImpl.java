package by.bsuir.dao.impl;

import by.bsuir.dao.ResumeDAO;
import by.bsuir.entity.Resume123;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ResumeDAOImpl implements ResumeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Resume123 getResumeById(int id) {
        return entityManager.find(Resume123.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Resume123> getAllResumes() {
        String hql = "SELECT r FROM Resume r ORDER BY r.id DESC";
        return (List<Resume123>)entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void createResume(Resume123 resume) {
        entityManager.persist(resume);
    }

    @Override
    public void updateResume(Resume123 resume) {
        Resume123 oldResume = getResumeById(resume.getId());
        oldResume.setDate(resume.getDate());
        oldResume.setCareerObjective(resume.getCareerObjective());
        oldResume.setBusinessTrip(resume.getBusinessTrip());
        oldResume.setRelocation(resume.getRelocation());
        oldResume.setSkills(resume.getSkills());
        oldResume.setSalary(resume.getSalary());
        oldResume.setNumberOfView(resume.getNumberOfView());
        oldResume.setUserId(resume.getUserId());
        entityManager.flush();
    }

    @Override
    public void deleteResume(int id) {
        entityManager.remove(getResumeById(id));
    }
}
