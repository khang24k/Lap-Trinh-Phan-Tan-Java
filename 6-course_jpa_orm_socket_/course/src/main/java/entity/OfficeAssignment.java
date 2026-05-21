package entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"instructor"})
@Builder

@Entity
@Table(name = "OfficeAssignments")
public class OfficeAssignment implements Serializable {
    @Id
    private String id;
    private String location;
    private LocalDateTime timestamp;

    @OneToOne
    @MapsId
    @JoinColumn(name = "instructorId", unique = true)
    private Instructor instructor;
}
