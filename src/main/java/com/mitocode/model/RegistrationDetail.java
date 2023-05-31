package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RegistrationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRegistrationDetail;

    @ManyToOne
    @JoinColumn(name = "id_registerEnrollment", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_REGISTERENROLLMENT"))
    private RegisterEnrollment registerEnrollment;

    @ManyToOne
    @JoinColumn(name = "id_courses", nullable = false, foreignKey = @ForeignKey(name = "FK_COURSES"))
    private Courses courses;

    @Column(nullable = false, length = 50)
    private String classroom;

}
