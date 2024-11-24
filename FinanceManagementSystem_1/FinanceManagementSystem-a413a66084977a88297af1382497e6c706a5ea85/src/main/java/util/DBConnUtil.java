package util;
import java.sql.*;

public class DBConnUtil {
    public static Connection getConnection() {
        Connection conn=null;
        try {
            String connectionString=DBPropertyUtil.getConnectionString();
            conn=DriverManager.getConnection(connectionString);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

}

