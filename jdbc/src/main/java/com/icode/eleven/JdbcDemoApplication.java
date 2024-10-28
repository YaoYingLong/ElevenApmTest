package com.icode.eleven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author by YingLong on 2024/10/18
 */
public class JdbcDemoApplication {
    public static void main(String[] args) throws SQLException {
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_user", "root", "root");
        conn1.prepareStatement("select * from test").execute();
        System.out.println("Hello world!");
    }
}