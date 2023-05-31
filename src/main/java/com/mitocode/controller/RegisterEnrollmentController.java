package com.mitocode.controller;

import com.mitocode.dto.RegisterEnrollmentDTO;
import com.mitocode.dto.StudentDTO;
import com.mitocode.model.RegisterEnrollment;
import com.mitocode.model.Student;
import com.mitocode.service.IRegisterEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registerEnrollment")
@RequiredArgsConstructor
public class RegisterEnrollmentController {


    private final IRegisterEnrollmentService service; //= new StudentService();

    @Qualifier("coursesMapper")
    private final ModelMapper mapper;

    private RegisterEnrollmentDTO convertToDto(RegisterEnrollment obj){
        return mapper.map(obj, RegisterEnrollmentDTO.class);
    }

    private  RegisterEnrollment convertToEntity (RegisterEnrollmentDTO dto){
        return mapper.map(dto, RegisterEnrollment.class);
    }

    @GetMapping
    public ResponseEntity< List<RegisterEnrollmentDTO>> readAll() throws Exception{
//        List<RegisterEnrollmentDTO> list = service.readAll().stream().map(e ->{
//            RegisterEnrollmentDTO dto = new RegisterEnrollmentDTO();
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
        List<RegisterEnrollmentDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity< RegisterEnrollmentDTO> readById(@PathVariable("id")Integer id) throws Exception{
//        RegisterEnrollment obj = service.readById(id);
        RegisterEnrollmentDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegisterEnrollmentDTO> create (@Valid @RequestBody RegisterEnrollmentDTO dto) throws Exception{
        RegisterEnrollment obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterEnrollmentDTO> update (@PathVariable("id") Integer id, @RequestBody RegisterEnrollmentDTO dto) throws Exception{
        dto.setIdRegisterEnrollment(id);
        RegisterEnrollment obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/mostexpensive")
    public ResponseEntity<RegisterEnrollmentDTO> getRegisterMostExpensive(){
        RegisterEnrollmentDTO dto = convertToDto(service.getRegisterEnrollment());
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/bestseller")
    public ResponseEntity<String> getBesStudent(){
        String student = service.getBestRegisterEnrollment();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/bestproduct")
    public ResponseEntity<Map<String, Integer>> getCourses(){
        Map<String, Integer> byCourses = service.getMostCourses();
        return new ResponseEntity<>(byCourses, HttpStatus.OK);
    }

    @GetMapping("/descStudent")
    public ResponseEntity<?>descStudent(){
        String dto = service.findDescYear().toString();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/desc")
    public ResponseEntity<List<?>>desc(){
        List<?> dto = service.readAll();
        for(int i=0; i<dto.size(); i--) {
            System.out.println(dto.get(i));
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
