package com.mitocode.service.impl;

import com.mitocode.model.Student;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IStudentRepo;
import com.mitocode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findByName(String nameOne) {
        return repo.findByNameOne(nameOne);
    }

    @Override
    public List<Student> findByLastNameOne(String nameOne) {
        System.out.println("llagando al servis->"+nameOne);
        return repo.findByNameOneContains(nameOne);
    }

    @Override
    public List<Student> findByIdentificationNumberOrNameOne(Integer identificationNumber, String nameOne) {
        return repo.findByIdentificationNumberOrNameOne(identificationNumber, nameOne);
    }

    @Override
    public List<Student> getNameAndYears(String nameOne, Integer earthYears) {
        System.out.println("earthYears-Servicio:-->"+earthYears);
        return repo.getNameAndYears(nameOne, earthYears);
    }

}
