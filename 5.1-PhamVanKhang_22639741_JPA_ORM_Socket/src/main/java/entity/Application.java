package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"candidate", "job"})
@Builder

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "application_id")
    private Long id;
    private LocalDate appliedDate;
    @Enumerated(EnumType.STRING)
    private AppStatus status;

    @OneToMany
    private Candidate candidate;
    private Job job;
}