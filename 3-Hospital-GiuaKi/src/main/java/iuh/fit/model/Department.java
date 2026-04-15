package iuh.fit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department implements Serializable {
    private String id;
    private String name;
    private String location;


    private transient List<Doctor> doctors;
}
