package iuh.fit;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import entity.Status;
import service.HospitalService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("DESKTOP-5OA3AGI", 9741);
        HospitalService hospitalService = (HospitalService) registry.lookup("hospitalService");

        try(Scanner sc = new Scanner(System.in)){
            while (true){
                System.out.println("--------------------------------------------");
                System.out.println("1............");
                System.out.println("2.............");
                System.out.println("Chon cau hoi de test: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1 -> {
                        Doctor doctor = new Doctor();
                        doctor.setId("D01");
                        Patient patient = new Patient();
                        patient.setId("P01");
                        Appointment appointment = new Appointment();
                        appointment.setDoctor(doctor);
                        appointment.setPatient(patient);
                        appointment.setAppointmentTime(LocalDateTime.now());
                        appointment.setStatus(Status.PENDING);

                        System.out.println(hospitalService.addAppointment(appointment));
                    }
                    case 2 -> {
                        hospitalService.getAppointmentDetails().forEach(row -> System.out.println(Arrays.toString(row)));
                    }
                }
            }
        }

    }
}
