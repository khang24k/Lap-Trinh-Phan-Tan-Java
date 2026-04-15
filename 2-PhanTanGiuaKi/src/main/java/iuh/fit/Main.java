package iuh.fit;

import iuh.fit.dao.DoctorDAO;
import iuh.fit.model.Doctor;

import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DoctorDAO doctorDAO = new DoctorDAO();
//        System.out.println(doctorDAO.findDoctoyById("DR.99"));

//        doctorDAO.getNoOfDoctorsBySpeciality("Internal Medicine")
//                .forEach((s, aLong) -> System.out.println(s + ":" + aLong));

//        Doctor doctor = new Doctor();
//        doctor.setDoctorId("DR200");
//        doctor.setName("Pham Van Khang 2");
//        doctor.setPhone("12345789");
//        doctor.setSpeciality("CNTT");
//        System.out.println(doctorDAO.addDoctor(doctor));

//        doctorDAO.listDoctorsBySpeciality("Internal CNTT")
//                .forEach(doctor -> System.out.println(doctor));

        System.out.println(doctorDAO.updateDiagnosis("PT005", "DR.011", "ahhaha"));
    }
}