package com.mitocode.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 50)
    private String  nameOneStudents;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 50)
    private String  nameTwoStudent;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 50)
    private String  lastNameOneStudent;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 50)
    private String  lastNameTwoStudent;

    private Integer identificationNumberStudent;

    private Integer earthYearsStudent;


}
