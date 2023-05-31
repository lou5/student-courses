package com.mitocode.config;

import com.mitocode.dto.CoursesDTO;
import com.mitocode.dto.StudentDTO;
import com.mitocode.model.Courses;
import com.mitocode.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper studentMapper(){
//        return new ModelMapper();
        ModelMapper mapper = new ModelMapper();
        TypeMap<StudentDTO, Student> typeMap1= mapper.createTypeMap(StudentDTO.class, Student.class);
        TypeMap<Student, StudentDTO> typeMap2= mapper.createTypeMap(Student.class, StudentDTO.class);
        typeMap1.addMapping(e ->e.getNameOneStudents(), (dest, v) -> dest.setNameOne((String) v));
        typeMap2.addMapping(e ->e.getNameOne(), (dest, v)-> dest.setNameOneStudents((String) v));
        return mapper;
    }

    @Bean("coursesMapper")
    public ModelMapper coursesMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<CoursesDTO, Courses> typeMap1= mapper.createTypeMap(CoursesDTO.class, Courses.class);
        TypeMap<Courses, CoursesDTO> typeMap2= mapper.createTypeMap(Courses.class, CoursesDTO.class);
        typeMap1.addMapping(e -> e.getAcronymCourse(), (dest, v) -> dest.setAcronym((String) v));
        typeMap2.addMapping(e -> e.getAcronym(), (dest, v) -> dest.setAcronymCourse((String) v));
        return mapper;
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}
