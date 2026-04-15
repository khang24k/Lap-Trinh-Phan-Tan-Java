package entity;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"candidate", "job"})
@Builder

public class Application {

    private Long id;
    private LocalDate appliedDate;
    private AppStatus status;

    private Candidate candidate;
    private Job job;
}