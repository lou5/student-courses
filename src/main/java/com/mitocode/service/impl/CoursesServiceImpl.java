package com.mitocode.service.impl;

import com.mitocode.model.Courses;
import com.mitocode.repo.ICoursesRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IStudentRepo;
import com.mitocode.service.ICoursesService;
import com.mitocode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl extends CRUDImpl<Courses, Integer> implements ICoursesService {

    private final ICoursesRepo repo;

    @Override
    protected IGenericRepo<Courses, Integer> getRepo() {
        return repo;
    }
}
