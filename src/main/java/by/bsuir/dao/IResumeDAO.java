package by.bsuir.dao;

import by.bsuir.entity.Resume;

import java.util.List;

public interface IResumeDAO {

    List<Resume> getAllResumes();
    Resume getResumeById(int id);
    void createResume(Resume resume);
    void updateResume(Resume resume);
    void deleteResume(int id);
}
