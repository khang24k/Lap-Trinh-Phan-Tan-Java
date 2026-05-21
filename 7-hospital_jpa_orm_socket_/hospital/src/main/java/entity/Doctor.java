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
@ToString(callSuper = true, exclude = {"appointments"})
@SuperBuilder


@Entity
@Table(name = "Doctors")
@PrimaryKeyJoinColumn(name = "doctorId")
public class Doctor extends Person implements Serializable {
    private String specialty;
    private String hospital;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;
}
