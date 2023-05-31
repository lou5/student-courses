package com.mitocode.repo;


import com.mitocode.model.RegisterEnrollment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface IRegisterEnrollmentRepo extends IGenericRepo<RegisterEnrollment, Integer> {

    @Query(nativeQuery = true, value = "select name_one, last_name_one, earth_years \n" +
            "from student\n" +
            "order by earth_years desc")
    List<?>findDescYear();
}
