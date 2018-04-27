package by.bsuir.service.impl;

import by.bsuir.dao.ResumeDAO;
import by.bsuir.entity.Resume;
import by.bsuir.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeDAO resumeDAO;

    @Autowired
    public ResumeServiceImpl(ResumeDAO resumeDAO) {
        this.resumeDAO = resumeDAO;
    }

    @Override
    public Resume getResumeById(int id) {
        return resumeDAO.getResumeById(id);
    }

    @Override
    public List<Resume> getAllResumes(){
        return resumeDAO.getAllResumes();
    }

    @Override
    public void createResume(Resume resume){
        resumeDAO.createResume(resume);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeDAO.updateResume(resume);
    }

    @Override
    public void deleteResume(int id) {
        resumeDAO.deleteResume(id);
    }
}
