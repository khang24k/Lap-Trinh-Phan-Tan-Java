import service.DepartmentService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("DESKTOP-5OA3AGI", 9741);
        DepartmentService departmentService =(DepartmentService) registry.lookup("departmentService");

        departmentService.listStudentsStudyingCourseWithHighestScore("Quantum Physics")
                .forEach(student -> System.out.println(student));
    }
}
