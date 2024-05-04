package com.gradingRest.crud.repositories;

import com.gradingRest.crud.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//Repository allow us to do queries database
//JpaRepository is a helpful package that allows to do simple request

public interface IStudentRepository extends JpaRepository<StudentModel, Long> {


}
