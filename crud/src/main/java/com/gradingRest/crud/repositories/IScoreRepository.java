package com.gradingRest.crud.repositories;

import com.gradingRest.crud.models.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreRepository extends JpaRepository<ScoreModel, Long > {
}
