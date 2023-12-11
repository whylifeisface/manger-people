package com.example.demo2.util;

import java.sql.*;

public class JdbcUtil {

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/addr","root","root");
    }

    public static void close(Statement stmt, Connection conn) throws SQLException {
        stmt.close();
        conn.close();
    }

    public static void close(ResultSet rs,Statement stmt, Connection connection) throws SQLException {
        rs.close();
        stmt.close();
        connection.close();
    }

}
