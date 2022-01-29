package com.elcorp.pocspringdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "student_info",
        uniqueConstraints = @UniqueConstraint(
                name = "UNIQUE_EMAIL",
                columnNames = "email_address"
        )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long studentId;
    private String name;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;
    @Embedded
    private Guardian guardian;
}
