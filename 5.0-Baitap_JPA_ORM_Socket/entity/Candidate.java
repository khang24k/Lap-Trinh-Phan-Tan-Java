package entity;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"applications"})
@Builder

public class Candidate {

    private String id;
    private String name;
    private String email;
    private int experience;

    private Set<Application> applications;
    private Set<Skill> skills;
}