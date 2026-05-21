import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CreateSchema {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("mariadb-pu")
                .createEntityManager();
    }
}
