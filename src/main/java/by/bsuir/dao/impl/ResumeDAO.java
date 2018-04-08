package by.bsuir.dao.impl;

import by.bsuir.dao.IResumeDAO;
import by.bsuir.entity.Resume;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class ResumeDAO implements IResumeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Resume getResumeById(int id) {
        return entityManager.find(Resume.class, id);
    }

    @Override
    public List<Resume> getAllResumes() {
        TypedQuery<Resume> namedQuery = entityManager.createNamedQuery("Resume.getAll", Resume.class);
        return namedQuery.getResultList();
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
        oldResume.setAspirantId(resume.getAspirantId());
        entityManager.flush();
    }

    @Override
    public void deleteResume(int id) {
        entityManager.remove(getResumeById(id));
    }
}
