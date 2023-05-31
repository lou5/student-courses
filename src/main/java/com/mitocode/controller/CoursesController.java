package com.mitocode.controller;

import com.mitocode.dto.CoursesDTO;
import com.mitocode.model.Courses;
import com.mitocode.service.ICoursesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {


    private final ICoursesService service; //= new StudentService();

    @Qualifier("coursesMapper")
    private final ModelMapper mapper;

    private CoursesDTO convertToDto(Courses obj){
        return mapper.map(obj, CoursesDTO.class);
    }

    private  Courses convertToEntity (CoursesDTO dto){
        return mapper.map(dto, Courses.class);
    }

    @GetMapping
    public ResponseEntity< List<CoursesDTO>> readAll() throws Exception{
//        List<CoursesDTO> list = service.readAll().stream().map(e ->{
//            CoursesDTO dto = new CoursesDTO();
//            dto.setIdCourses(e.getIdStudent());
//            dto.setNameOneStudent(e.getNameOne());
//            dto.setNameTwoStudent(e.getNameTwo());
//            dto.setLastNameOneStudent(e.getLastNameOne());
//            dto.setNameTwoStudent(e.getLastNameTwo());
//            dto.setIdentificationNumberStudent(e.getIdentificationNumber());
//            dto.setEarthYearsStudent(e.getEarthYears());
//            return dto;
//        }).toList();
//       return new ResponseEntity<>(list, HttpStatus.OK);
//        ModelMapper mapper = new ModelMapper();
        List<CoursesDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity< CoursesDTO> readById(@PathVariable("id")Integer id) throws Exception{
//        Courses obj = service.readById(id);
        CoursesDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CoursesDTO> create (@Valid @RequestBody CoursesDTO dto) throws Exception{
        Courses obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursesDTO> update (@PathVariable("id") Integer id, @RequestBody CoursesDTO dto) throws Exception{
        dto.setIdCourses(id);
        Courses obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/find/name/{nameOne}")
//    public ResponseEntity<List<CoursesDTO>> findByName(@PathVariable("nameOne") String nameOne){
//        System.out.println("variable"+nameOne);
//        List<CoursesDTO> lst = service.findByName(nameOne).stream().map(this::convertToDto).collect(Collectors.toList());
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/{nameOne}")
//    public ResponseEntity<List<CoursesDTO>> findBylastNameOne(@PathVariable("nameOne") String nameOne){
//        System.out.println("variable:"+nameOne);
//        List<CoursesDTO> lst = service.findByLastNameOne(nameOne).stream().map(this::convertToDto).collect(Collectors.toList());
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/identificationNumberdname")
//    public ResponseEntity<List<CoursesDTO>> findByidentificationNumberAndName(@RequestParam("identificationNumber") Integer identificationNumber, @RequestParam("nameOne") String nameOne){
//        System.out.println("identificationNumber-->"+identificationNumber);
//        List<CoursesDTO> lst = service.findByIdentificationNumberOrNameOne(identificationNumber,nameOne).stream().map(this::convertToDto).collect(Collectors.toList());
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/name/earthYears")
//    public  ResponseEntity<List<CoursesDTO>> getByNameEartYears (@RequestParam("nameOne") String nameOne, @RequestParam("earthYears") Integer earthYears) {
//        System.out.println("earthYears:-->"+earthYears);
//        List<CoursesDTO> lst = service.getNameAndYears(nameOne, earthYears).stream().map(this::convertToDto).collect(Collectors.toList());
//        return new ResponseEntity<>(lst, HttpStatus.OK);
//    }


}
