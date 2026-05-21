package dao;

import db.JPAUtil;
import entity.Department;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentDao {

    public Map<Department, Long> getNumberOfStudentsByDepartment (){
        try (EntityManager em = JPAUtil.getEntityManager()){
            String jpql = """
                    SELECT d, COUNT(s)
                    FROM Department d
                    JOIN d.courses c
                    JOIN c.enrollments e
                    JOIN e.student s
                    GROUP BY d.name
                    ORDER BY COUNT(s) desc 
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            return query.getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            objects -> (Department) objects[0],
                            objects -> (Long) objects[1],
                            (aLong, aLong2) -> aLong,
                            LinkedHashMap::new
                    ));
        }
    }
    public Map<Student, Double> getAverageScoreOfStudents(){
        try (EntityManager em = JPAUtil.getEntityManager()){
            String jpql = """
                    SELECT s, AVG(e.grade)
                    FROM Student s
                    JOIN s.enrollments e
                    GROUP BY s
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            return query.getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            objects -> (Student) objects[0],
                            objects -> (Double) objects[1],
                            (v1, v2) -> v1,
                            LinkedHashMap::new

                    ));
        }
    }

    public List<Department> listDepartmentsWithoutStudents(){
        try(EntityManager em = JPAUtil.getEntityManager()) {
            String jpql = """
                    select d
                    from Department d
                    where d NOT IN (select distinct e.course.department from Enrollment e)
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            return query.getResultList();
        }
    }

    public List<Student> listStudentsStudyingCourseWithHighestScore(String courseName){
        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql = """
                        select s
                        from Student s
                        join s.enrollments e
                        join e.course c
                        where c.title = :courseName 
                        and e.grade = (select max(e2.grade) from Enrollment e2 join e2.course c2 WHERE c2.title = :courseName)
                        """;
            TypedQuery<Student> query = em.createQuery(jpql, Student.class);
            query.setParameter("courseName", courseName);
            return query.getResultList();
        }
    }
}
