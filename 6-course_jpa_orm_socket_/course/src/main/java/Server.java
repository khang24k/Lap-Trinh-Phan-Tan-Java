import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception {
        Context context = new InitialContext();
        LocateRegistry.createRegistry(9741);

        DepartmentService departmentService = new DepartmentServiceImpl();

        context.bind("rmi://DESKTOP-5OA3AGI:9741/departmentService", departmentService);

        System.out.println("server running........");
    }
}
