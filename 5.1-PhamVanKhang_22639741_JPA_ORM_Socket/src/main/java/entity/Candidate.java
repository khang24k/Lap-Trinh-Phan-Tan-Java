package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"applications"})
@Builder

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @Column(name = "candidate_id")
    private String id;
    private String name;
    private String email;
    private int experience;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Set<Application> applications;

    @ManyToMany(mappedBy = "candidates")
    private Set<Skill> skills;
}