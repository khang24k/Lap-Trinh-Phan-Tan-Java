package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient extends Person implements Serializable {
    private Gender gender;
    private String dateOfBirth;
    private String address;


    private transient List<Treatment> treatments;


    public Patient(String id, String name, String phone, String address) {
        super(id, name, phone);
        this.address = address;
    }
}
