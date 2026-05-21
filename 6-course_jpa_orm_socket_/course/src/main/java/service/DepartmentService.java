package service;

import entity.Department;
import entity.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface DepartmentService extends Remote {
    Map<Department, Long> getNumberOfStudentsByDepartment() throws RemoteException;

    Map<Student, Double> getAverageScoreOfStudents() throws RemoteException;

    List<Department> listDepartmentsWithoutStudents() throws RemoteException;

    List<Student> listStudentsStudyingCourseWithHighestScore(String courseName) throws RemoteException;
}
