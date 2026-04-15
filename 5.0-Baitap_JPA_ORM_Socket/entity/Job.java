package entity;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"company", "skills"})
@Builder

public class Job {

    private String id;
    private String title;
    private String description;
    private double salary;
    private JobStatus status;

    private Company company;
    private Set<Skill> skills;
    private Set<Application> applications;
}