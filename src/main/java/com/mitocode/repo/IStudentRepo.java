package com.mitocode.repo;

import com.mitocode.model.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface IStudentRepo extends IGenericRepo<Student, Integer> {

    List<Student>findByNameOne(String nameOne);

    List<Student>findByNameOneContains(String nameOne);

    List<Student>findByIdentificationNumberOrNameOne(Integer identificationNumber, String nameOne);

    @Query("FROM Student s WHERE s.nameOne = ?1 AND s.earthYears LIKE %?2%")
    List<Student>getNameAndYears(String nameOne,Integer earthYears );

}
