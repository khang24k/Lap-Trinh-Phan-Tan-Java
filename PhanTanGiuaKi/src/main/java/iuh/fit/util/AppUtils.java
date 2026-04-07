package iuh.fit.util;

import org.neo4j.driver.*;

public class AppUtils {
    private static final String db = "phantan1";
    private static final String username = "neo4j";
    private static final String pass = "12345678";
    private static final String uri = "neo4j://localhost:7687";

    private static Driver driver;

    public static Driver getDriver(){
        if (driver == null)
            driver = GraphDatabase.driver(uri, AuthTokens.basic(username, pass));
        return driver;
    }
    public static Session getSession() {
        return getDriver().session(SessionConfig.forDatabase(db));
    }
}
