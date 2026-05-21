package service.impl;

import dao.DepartmentDao;
import db.JPAUtil;
import entity.Department;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceImpl extends UnicastRemoteObject implements service.DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentServiceImpl() throws RemoteException {
        departmentDao = new DepartmentDao();
    }

    @Override
    public Map<Department, Long> getNumberOfStudentsByDepartment() throws RemoteException{
        return departmentDao.getNumberOfStudentsByDepartment();
    };

    @Override
    public Map<Student, Double> getAverageScoreOfStudents() throws RemoteException{
        return departmentDao.getAverageScoreOfStudents();
    }

    @Override
    public List<Department> listDepartmentsWithoutStudents() throws RemoteException{
        return departmentDao.listDepartmentsWithoutStudents();
    }

    @Override
    public List<Student> listStudentsStudyingCourseWithHighestScore(String courseName) throws RemoteException{
        return departmentDao.listStudentsStudyingCourseWithHighestScore(courseName);
    }
}
