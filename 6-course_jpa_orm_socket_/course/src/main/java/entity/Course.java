package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"instructors", "prerequisites", "department", "enrollments"})
@SuperBuilder

@Entity
@Table(name = "Courses")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course implements Serializable {
    @Id
    @Column(name = "courseId")
    protected String id;
    protected String title;
    protected Integer credits;

    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors;


    @ManyToMany(mappedBy = "prerequisites")
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(name = "CoursesPrerequisites",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "prerequisiteId")
    )
    private Set<Course> prerequisites;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;
}
