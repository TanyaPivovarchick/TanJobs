package by.bsuir.service;

import by.bsuir.entity.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> getAllResumes();
    Resume getResumeById(int id);
    void createResume(Resume resume);
    void updateResume(Resume resume);
    void deleteResume(int id);
}
