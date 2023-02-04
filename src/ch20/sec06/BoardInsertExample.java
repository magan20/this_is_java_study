package ch20.sec06;

import java.io.FileInputStream;
import java.sql.*;

public class BoardInsertExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql:// localhost:3306/thisisjava",
                    "java",
                    "mysql"
            );

            String sql = "" +
                    "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
                    "VALUES (?, ?, ?, now(), ?, ?)";

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "눈오는 날");
            pstmt.setString(2, "함박눈이 내려요.");
            pstmt.setString(3, "winter");
            pstmt.setString(4, "snow.jpg");
            pstmt.setBlob(5, new FileInputStream("src/ch20/mysql/sec06/snow.jpg"));

            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);

            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int bno = rs.getInt(1);
                    System.out.println("저장된 bno: " + bno);
                }
                rs.close();
            }

            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}



