package lii.springdata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FullName")
    private String name;

    private int age;

    private String email;

    private LocalDate registrationDate;

    public Student(String name, int age, String email, LocalDate registrationDate) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
