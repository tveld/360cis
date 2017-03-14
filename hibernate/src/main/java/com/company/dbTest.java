package com.company;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Timothy on 3/13/2017.
 */
public class dbTest {
    public static void main (String[] args) throws Exception
    {
        Class.forName ("oracle.jdbc.driver.OracleDriver");

        //Properties props = new Properties();
        //props.put("hibernate23", "veldhuit");
        //Connection conn = DriverManager.getConnection("jdbc:oracle:thin@//dbserv.cis.gvsu.edu", props);

        //Connection conn = DriverManager.getConnection
        //        ("jdbc:oracle:thin:@//dbserv.cis.gvsu.edu:1521/orcl", "veldhuit", "hibernate23");
        // @//machineName:port/SID,   userid,  password

        //Connection conn = DriverManager.getConnection
        //        ("jdbc:oracle:thin:@dbserv.cis.gvsu.edu:1521:orcl", "veldhuit", "hibernate23");

        Connection conn = DriverManager.getConnection
                ("jdbc:oracle:thin:veldhuit/hibernate23@//dbserv.cis.gvsu.edu:1521/orcl", "veldhuit", "hibernate23");

        //Connection conn = DriverManager.getConnection
        //        ("jdbc:oracle:thin:veldhuit/hibernate23@//dbserv.cis.gvsu.edu:1521/orcl");
        try {
            Statement stmt = conn.createStatement();
            try {
                ResultSet rset = stmt.executeQuery("select * from cars;");
                try {
                    while (rset.next())
                        System.out.println (rset.getString(1));   // Print col 1
                }
                finally {
                    try { rset.close(); } catch (Exception ignore) {}
                }
            }
            finally {
                try { stmt.close(); } catch (Exception ignore) {}
            }
        }
        finally {
            try { conn.close(); } catch (Exception ignore) {}
        }
    }
}
