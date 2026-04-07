package iuh.fit.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Person implements Serializable {
    private String id;
    private String name;
    private String phone;


}
