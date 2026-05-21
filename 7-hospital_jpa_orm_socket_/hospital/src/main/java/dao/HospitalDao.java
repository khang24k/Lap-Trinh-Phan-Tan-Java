package dao;

import db.JPAUtil;
import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HospitalDao {
    public boolean addAppointment(Appointment appointment){
        try(EntityManager em = JPAUtil.getEntityManager()){
            em.getTransaction().begin();

            Doctor doctor = em.find(Doctor.class, appointment.getDoctor().getId());
            if (doctor == null)
                return false;

            Patient patient = em.find(Patient.class, appointment.getPatient().getId());
            if (patient == null)
                return false;

            em.persist(appointment);


            em.getTransaction().commit();
            return true;
        }
    }

    public List<Object[]> getAppointmentDetails(){
        try(EntityManager em = JPAUtil.getEntityManager()){
            String jpql = """
                    select d.id, d.fullName, p.id, p.fullName, a.appointmentTime, a.status
                    from Appointment a
                    join a.doctor d
                    join a.patient p
                    """;
            TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
            return query.getResultList();
        }
    }


}
