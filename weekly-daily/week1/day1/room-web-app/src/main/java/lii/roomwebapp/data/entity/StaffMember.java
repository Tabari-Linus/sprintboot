package lii.roomwebapp.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class StaffMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;
}
