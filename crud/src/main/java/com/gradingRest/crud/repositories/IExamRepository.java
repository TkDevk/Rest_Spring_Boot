package com.gradingRest.crud.repositories;

import com.gradingRest.crud.models.ExamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamRepository extends JpaRepository<ExamModel, Long> {
}
