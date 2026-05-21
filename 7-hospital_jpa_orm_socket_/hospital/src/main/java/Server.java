import dao.HospitalDao;
import service.HospitalService;
import service.impl.HospitalServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception{
        Context context = new InitialContext();
        LocateRegistry.createRegistry(9741);

        HospitalService hospitalService = new HospitalServiceImpl();

        context.bind("rmi://DESKTOP-5OA3AGI:9741/hospitalService", hospitalService);

        System.out.println("Running!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
