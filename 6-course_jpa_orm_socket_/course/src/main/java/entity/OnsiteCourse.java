package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder

@Entity
@Table(name = "OnsiteCourses")
public class OnsiteCourse extends Course implements Serializable {
    private String days;
    private String location;
    private LocalDateTime time;
}
