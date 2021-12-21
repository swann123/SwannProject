package com.sdl.portal.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

	public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/comm_demo_db?useSSL=false", "root", "swann1");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
