package by.bsuir.repository;

import by.bsuir.entity.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<JobVacancy, Long> {
}
