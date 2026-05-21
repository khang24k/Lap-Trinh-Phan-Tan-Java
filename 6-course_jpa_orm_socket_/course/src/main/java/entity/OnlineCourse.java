package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder

@Entity
@Table(name = "OnlineCourses")
public class OnlineCourse extends Course  implements Serializable {
    private String url;
}
