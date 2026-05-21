package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"enrollments"})
@SuperBuilder

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person implements Serializable {
    private LocalDateTime enrollmentDate;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;
}
