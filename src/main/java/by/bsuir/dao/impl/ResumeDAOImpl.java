package by.bsuir.dao.impl;

import by.bsuir.dao.ResumeDAO;
import by.bsuir.entity.Resume;
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
    public Resume getResumeById(int id) {
        return entityManager.find(Resume.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Resume> getAllResumes() {
        String hql = "SELECT r FROM Resume r ORDER BY r.id DESC";
        return (List<Resume>)entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void createResume(Resume resume) {
        entityManager.persist(resume);
    }

    @Override
    public void updateResume(Resume resume) {
        Resume oldResume = getResumeById(resume.getId());
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
