package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEnrollmentDTO {

    @NotNull
    private Integer idRegisterEnrollment;

    @NotNull
    private StudentDTO student;

    @NotNull
    private LocalDateTime enrollmentDate;

    @NotNull
    private boolean state;

    @NotNull
    @JsonManagedReference
    private List<RegistrationDetailDTO> details;

    private Integer totalAverage;


}
