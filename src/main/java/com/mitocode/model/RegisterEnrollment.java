package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RegisterEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRegisterEnrollment;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_REGISTERENROLLMENT_STUDENT"))
    private Student student;

    @Column(nullable = false)
    private LocalDateTime enrollmentDate;

    private boolean state;

    @OneToMany(mappedBy = "registerEnrollment", cascade = CascadeType.ALL)
    private List<RegistrationDetail> details;

    private Integer totalAverage;
    

}
