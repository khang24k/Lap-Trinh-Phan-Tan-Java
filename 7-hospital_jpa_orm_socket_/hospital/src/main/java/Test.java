import dao.HospitalDao;
import db.JPAUtil;
import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import entity.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EnumType;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        JPAUtil.getEntityManager();
        HospitalDao hospitalDao = new HospitalDao();

//        Doctor doctor = new Doctor();
//        doctor.setId("D01");
//        Patient patient = new Patient();
//        patient.setId("P01");
//        Appointment appointment = new Appointment();
//        appointment.setDoctor(doctor);
//        appointment.setPatient(patient);
//        appointment.setAppointmentTime(LocalDateTime.now());
//        appointment.setStatus(Status.PENDING);
//
//        System.out.println(hospitalDao.addAppointment(appointment));

//        hospitalDao.getAppointmentDetails().forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
