package jdbc;

import java.sql.*;

public class jdbcTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

    static final String user = "root";
    static final String pass = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("连接数据库......");
            conn = DriverManager.getConnection(DB_URL, user, pass);

            System.out.println("实例化statement对象");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from ad";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("站点名称： " + rs.getString("title"));

            }


            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
