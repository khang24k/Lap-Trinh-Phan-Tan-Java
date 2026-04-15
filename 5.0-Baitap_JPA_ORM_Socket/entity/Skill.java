package entity;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"jobs"})
@Builder

public class Skill {

    private String id;
    private String name;

    private Set<Job> jobs;
    private Set<Candidate> candidates;
}