package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"candidate", "job"})
@Builder

@Entity
@Table(name = "applications")
@IdClass(Application.ApplicationId.class)
public class Application {
    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private LocalDate appliedDate;

    @Enumerated(EnumType.STRING)
    private AppStatus status;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @EqualsAndHashCode
    public static class ApplicationId{
        private String candidate;
        private String job;
    }
}
