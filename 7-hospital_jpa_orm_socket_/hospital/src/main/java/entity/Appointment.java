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
@ToString(exclude = {"doctor", "patient"})
@Builder


@Entity
@Table(name = "Appointments")
@IdClass(Appointment.AppointmentId.class)
public class Appointment implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @Id
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @Id
    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @EqualsAndHashCode
    public static class AppointmentId{
        private String doctor;
        private String patient;
        private LocalDateTime appointmentTime;
    }
}
