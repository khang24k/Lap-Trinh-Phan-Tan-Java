package service.impl;

import dao.HospitalDao;
import db.JPAUtil;
import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class HospitalServiceImpl extends UnicastRemoteObject implements service.HospitalService {
    private HospitalDao hospitalDao;

    public HospitalServiceImpl() throws RemoteException {
        hospitalDao = new HospitalDao();
    }


    @Override
    public boolean addAppointment(Appointment appointment) throws RemoteException{
        return hospitalDao.addAppointment(appointment);
    }

    @Override
    public List<Object[]> getAppointmentDetails() throws RemoteException{
        return hospitalDao.getAppointmentDetails();
    }
}
