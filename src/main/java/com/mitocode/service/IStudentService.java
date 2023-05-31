package com.mitocode.service;


import com.mitocode.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {

    List<Student> findByName(String nameOne);

    List<Student> findByLastNameOne(String nameOne);

    List<Student>findByIdentificationNumberOrNameOne(Integer identificationNumber, String nameOne);

    List<Student>getNameAndYears(String nameOne,Integer earthYears );


}
