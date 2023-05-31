package com.mitocode.controller;

import com.mitocode.dto.StudentDTO;
import com.mitocode.model.Student;
import com.mitocode.service.IStudentService;
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
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service; //= new StudentService();

    @Qualifier("studentMapper")
    private final ModelMapper mapper;

    private StudentDTO convertToDto(Student obj){
        return mapper.map(obj, StudentDTO.class);
    }

    private  Student convertToEntity (StudentDTO dto){
        return mapper.map(dto, Student.class);
    }

    @GetMapping
    public ResponseEntity< List<StudentDTO>> readAll() throws Exception{
//        List<StudentDTO> list = service.readAll().stream().map(e ->{
//            StudentDTO dto = new StudentDTO();
//            dto.setIdStudent(e.getIdStudent());
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
        List<StudentDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity< StudentDTO> readById(@PathVariable("id")Integer id) throws Exception{
//        Student obj = service.readById(id);
        StudentDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create (@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update (@PathVariable("id") Integer id, @RequestBody StudentDTO dto) throws Exception{
        dto.setIdStudent(id);
        Student obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find/name/{nameOne}")
    public ResponseEntity<List<StudentDTO>> findByName(@PathVariable("nameOne") String nameOne){
        System.out.println("variable"+nameOne);
        List<StudentDTO> lst = service.findByName(nameOne).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/find/{nameOne}")
    public ResponseEntity<List<StudentDTO>> findBylastNameOne(@PathVariable("nameOne") String nameOne){
        System.out.println("variable:"+nameOne);
        List<StudentDTO> lst = service.findByLastNameOne(nameOne).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/find/identificationNumberdname")
    public ResponseEntity<List<StudentDTO>> findByidentificationNumberAndName(@RequestParam("identificationNumber") Integer identificationNumber, @RequestParam("nameOne") String nameOne){
        System.out.println("identificationNumber-->"+identificationNumber);
        List<StudentDTO> lst = service.findByIdentificationNumberOrNameOne(identificationNumber,nameOne).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/find/name/earthYears")
    public  ResponseEntity<List<StudentDTO>> getByNameEartYears (@RequestParam("nameOne") String nameOne, @RequestParam("earthYears") Integer earthYears) {
        System.out.println("earthYears:-->"+earthYears);
        List<StudentDTO> lst = service.getNameAndYears(nameOne, earthYears).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

}
