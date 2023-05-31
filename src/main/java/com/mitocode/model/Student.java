package com.mitocode.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idStudent;

    @Column(nullable = false, length = 50)
    private String  nameOne;

    @Column( length = 50)
    private String  nameTwo;

    @Column(nullable = false, length = 50)
    private String  lastNameOne;

    @Column(nullable = false, length = 50)
    private String  lastNameTwo;

    @Column(nullable = false, length = 10, unique = true)
    private Integer identificationNumber;

    private Integer earthYears;

}
