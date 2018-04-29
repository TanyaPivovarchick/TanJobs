package by.bsuir.dao;

import by.bsuir.entity.Resume123;

import java.util.List;

public interface ResumeDAO {

    List<Resume123> getAllResumes();
    Resume123 getResumeById(int id);
    void createResume(Resume123 resume);
    void updateResume(Resume123 resume);
    void deleteResume(int id);
}
