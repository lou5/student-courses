package com.mitocode.service.impl;

import com.mitocode.model.RegisterEnrollment;
import com.mitocode.model.RegistrationDetail;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IRegisterEnrollmentRepo;
import com.mitocode.service.IRegisterEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RegisterEnrollmentImpl extends CRUDImpl<RegisterEnrollment, Integer> implements IRegisterEnrollmentService {

    private final IRegisterEnrollmentRepo repo;

    @Override
    protected IGenericRepo<RegisterEnrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public RegisterEnrollment getRegisterEnrollment() {
        return repo.findAll()
                .stream()
                .max(Comparator.comparing(RegisterEnrollment::getEnrollmentDate))
                .orElse(new RegisterEnrollment());
    }

    @Override
    public String getBestRegisterEnrollment() {
        Map<Object, IntSummaryStatistics> byStudent = repo.findAll()
                .stream()
                .collect(groupingBy(s->s.getStudent().getNameOne(), summarizingInt(RegisterEnrollment::getTotalAverage)));

        System.out.println(byStudent.entrySet());
        return "";
//        return Collections.max(byStudent.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    @Override
    public Map<Object, IntSummaryStatistics> getMostCourses() {
        Stream<RegisterEnrollment> RegisterStream = repo.findAll().stream();
        Stream<List<RegistrationDetail>> listStream = RegisterStream.map(e->e.getDetails());

        Stream<RegistrationDetail> streamDetail = listStream.flatMap(Collection::stream);

        Map<Object, IntSummaryStatistics> byCourses = streamDetail
                .collect(groupingBy(d->d.getCourses().getName(), summarizingInt(RegistrationDetail::getIdRegistrationDetail)));

        return byCourses;
    }

    @Override
    public List<?> findDescYear(){
        return repo.findDescYear();
    }




}
