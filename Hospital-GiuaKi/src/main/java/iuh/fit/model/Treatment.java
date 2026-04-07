package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Treatment implements Serializable {
    private LocalDate startDay;
    private LocalDate endDay;
    private String diagnosis;

    private transient Doctor doctor;

    private transient Patient patient;

}
