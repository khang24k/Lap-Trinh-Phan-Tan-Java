package entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "courses")
@Builder

@Entity
@Table(name = "Departments")
public class Department implements Serializable {

    @Id
    @Column(name = "departmentId")
    private String id;
    private String name;
    private Double budget;
    private LocalDateTime startDate;
    private String administrator;

    @OneToMany(mappedBy = "department")
    private Set<Course> courses;
}
