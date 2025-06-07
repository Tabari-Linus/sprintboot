package lii.springdblearning.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "students"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(columnDefinition = "TEXT")
    private String lastName;
    @Column(nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(nullable = false)
    private Integer age;


    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
