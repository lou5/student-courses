package com.mitocode.service;


import com.mitocode.model.RegisterEnrollment;

import java.util.List;
import java.util.Map;

public interface IRegisterEnrollmentService extends ICRUD<RegisterEnrollment, Integer>{

    RegisterEnrollment getRegisterEnrollment(); // el mayor registro en una fecha

    String getBestRegisterEnrollment(); // los mejores estudiantes.

    Map getMostCourses();

    List<?> findDescYear();


}
