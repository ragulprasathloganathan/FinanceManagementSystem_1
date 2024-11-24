package util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString() {
        String connectionString=null;
        try(FileInputStream re=new FileInputStream("db.properties"))
        {
            Properties p=new Properties();
            p.load(re);
            connectionString=p.getProperty("url")+"?user="+p.getProperty("user")+"&password="+p.getProperty("password");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return connectionString;
    }
}
