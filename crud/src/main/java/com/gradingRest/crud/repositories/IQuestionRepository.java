package com.gradingRest.crud.repositories;

import com.gradingRest.crud.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<QuestionModel,Long> {
}
