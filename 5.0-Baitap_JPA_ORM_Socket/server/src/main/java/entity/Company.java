package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"jobs"})
@Builder

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @Column(name = "company_id")
    private String id;
    private String name;
    private String industry;

    @OneToMany(mappedBy = "company")
    private Set<Job> jobs;
 }
