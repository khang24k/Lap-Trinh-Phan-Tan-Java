package entity;

import entity.Course;
import entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"student", "course"})
@Builder

@Entity
@Table(name = "Enrollments")
@IdClass(Enrollment.EnrollmentId.class)
public class Enrollment implements Serializable  {
    @Id
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @Id
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    @Id
    private String semester;
    private Double grade;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @EqualsAndHashCode
    public static class EnrollmentId implements Serializable {
        private String student;
        private String course;
        private String semester;
    }
}
