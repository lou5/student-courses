package com.mitocode.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDTO {

    private Integer idCourses;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String  nameCourses;

    @NotNull
    @NotEmpty
    @Size (min = 3, max = 50)
    private String  acronymCourse;

    @NotNull
    private boolean stateCourses;

}
