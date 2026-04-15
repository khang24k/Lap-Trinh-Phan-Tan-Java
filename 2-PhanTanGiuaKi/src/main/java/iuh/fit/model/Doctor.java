package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Doctor {
    private String doctorId;
    private String departmentId;
    private String name;
    private String phone;
    private String speciality;
}
//dept_id
//"DEP001"
//
//doctor_id
//"DR.005"
//
//name
//"Robert Jones"
//
//phone
//"0789.234.567"
//
//speciality
//"Internal Medicine"