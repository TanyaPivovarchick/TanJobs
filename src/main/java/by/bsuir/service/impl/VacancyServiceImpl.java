package by.bsuir.service.impl;

import by.bsuir.entity.JobVacancy;
import by.bsuir.repository.VacancyRepository;
import by.bsuir.service.VacancyService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public List<JobVacancy> getAllVacancies() {
        Iterator<JobVacancy> vacancyIterator = vacancyRepository.findAll().iterator();
        return IteratorUtils.toList(vacancyIterator);
    }

    @Override
    public JobVacancy getVacancyById(Long id) {
        return vacancyRepository.findOne(id);
    }
}
