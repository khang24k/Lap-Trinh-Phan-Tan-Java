package service;

import entity.Appointment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HospitalService extends Remote {
    boolean addAppointment(Appointment appointment) throws RemoteException;

    List<Object[]> getAppointmentDetails() throws RemoteException;
}
