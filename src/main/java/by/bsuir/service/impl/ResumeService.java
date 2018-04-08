package by.bsuir.service.impl;

import by.bsuir.dao.IResumeDAO;
import by.bsuir.entity.Resume;
import by.bsuir.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService implements IResumeService {

    @Autowired
    private IResumeDAO resumeDAO;

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
