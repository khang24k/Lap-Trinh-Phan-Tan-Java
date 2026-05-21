package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"officeAssignment", "courses"})
@SuperBuilder

@Entity
@DiscriminatorValue("INSTRUCTOR")
public class Instructor extends Person implements Serializable {
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "instructor", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    private OfficeAssignment officeAssignment;

    @ManyToMany
    @JoinTable(name = "CoursesInstructors",
            joinColumns = @JoinColumn(name = "instructorId"),
            inverseJoinColumns = @JoinColumn(name = "courseId")
    )
    private Set<Course> courses;
}
