package entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"skills"})
@Builder


@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @Column(name = "cand_id")
    private String id;
    private String name;
    private String email;
    private Integer experience;

    @ManyToMany(mappedBy = "candidates")
    private Set<Skill> skills;
}
