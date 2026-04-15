package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"jobs"})
@Builder

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @Column(name = "skill_id")
    private String id;
    private String name;

    @ManyToMany
    @JoinTable(name = "jobs_skills",
        joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private Set<Job> jobs;

    @ManyToMany
    @JoinTable(name = "candidates_skills",
        joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<Candidate> candidates;
}