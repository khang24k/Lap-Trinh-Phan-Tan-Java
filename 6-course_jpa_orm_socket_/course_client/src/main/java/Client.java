import service.DepartmentService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("DESKTOP-5OA3AGI", 9741);
        DepartmentService departmentService =(DepartmentService) registry.lookup("departmentService");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("-------------------------");
                System.out.println("Chon cau hoi");
                System.out.println("1........");
                System.out.println("2........");
                System.out.println("3........");
                System.out.println("4........");
                System.out.println("Lua chon cua ban: ");

                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1 -> {
                        departmentService.getNumberOfStudentsByDepartment()
                                .forEach((department, aLong) ->
                                        System.out.println(department.getName() + ": " + aLong));
                    }
                    case 2 -> {
                        departmentService.getAverageScoreOfStudents().forEach(
                            (student, aDouble) -> System.out.println(student + ": " + aDouble));
                    }
                    case 3 -> {
                        departmentService.listDepartmentsWithoutStudents()
                            .forEach(department -> System.out.println(department));
                    }
                    case 4 -> {
                        departmentService.listStudentsStudyingCourseWithHighestScore("Quantum Physics")
                            .forEach(student -> System.out.println(student));
                    }

                }


            }
        }
    }
}
