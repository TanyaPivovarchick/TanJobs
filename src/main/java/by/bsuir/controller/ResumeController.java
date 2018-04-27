package by.bsuir.controller;

import by.bsuir.entity.Resume;
import by.bsuir.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("api")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("resume")
    public ResponseEntity<Resume> getArticleById(@RequestParam("id") String id) {
        Resume resume = resumeService.getResumeById(Integer.parseInt(id));
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @GetMapping("all-resumes")
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> list = resumeService.getAllResumes();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("resume")
    public ResponseEntity<Void> createResume(@RequestBody Resume resume, UriComponentsBuilder builder) {
        resumeService.createResume(resume);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/resume?id={id}").buildAndExpand(resume.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("resume")
    public ResponseEntity<Resume> updateResume(@RequestBody Resume resume) {
        resumeService.updateResume(resume);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @DeleteMapping("resume")
    public ResponseEntity<Void> deleteResume(@RequestParam("id") String id) {
        resumeService.deleteResume(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
