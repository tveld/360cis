package com.company;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by Timothy on 2/25/2017.
 */
public class DBaccess {
    MysqlDataSource dataSource;

    public static String DBaccess(){
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("veldhuit@orcl");
            dataSource.setPassword("hibernate23");
            dataSource.setServerName("cis.gvsu.edu:");

            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cars;");
            System.out.println(rs);

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception ex) {
            return ex.toString();
        }
        return "happy face";
    }
}
