package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDetailDTO {

    @NotNull
    private Integer idRegistrationDetail;

    @NotNull
    @JsonBackReference
    private RegisterEnrollmentDTO registerEnrollment;

    @NotNull
    private CoursesDTO courses;

    @NotNull
    private String classroom;
}
