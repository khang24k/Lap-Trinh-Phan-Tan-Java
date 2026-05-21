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
@ToString(callSuper = true, exclude = {"appointments", "phones"})
@SuperBuilder


@Entity
@Table(name = "Patients")
@PrimaryKeyJoinColumn(name = "patientId")
public class Patient extends Person implements Serializable {

    @ElementCollection
    @CollectionTable(
            name = "Phones",
            joinColumns = @JoinColumn(name = "patientId")
    )
    @Column(name = "phoneNumber")
    private Set<String> phones;
    private String address;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;
}
