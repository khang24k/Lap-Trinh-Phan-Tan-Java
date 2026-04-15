package iuh.fit;

import iuh.fit.dao.DoctorDAO;
import iuh.fit.model.Doctor;
import iuh.fit.model.Patient;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DoctorDAO doctorDAO = new DoctorDAO();
//        Doctor doctor = new Doctor("DR.998", "Khang2", "123", "CNTT");
//        System.out.println(doctor);
//        System.out.println(doctorDAO.addDoctor(doctor));

//        doctorDAO.getNoOfDoctorsBySpeciality("Internal Medicine")
//                .forEach((s, aLong) -> System.out.println(s + ":" + aLong));

//        System.out.println(doctorDAO.findDoctorById("DR.999"));

//        doctorDAO.listDoctorBySpeciality("Internal CNTT")
//                .forEach(doctor -> System.out.println(doctor));

        System.out.println(doctorDAO.updateDiagnosis("PT005", "DR.011", "lolllllll"));
    }
}