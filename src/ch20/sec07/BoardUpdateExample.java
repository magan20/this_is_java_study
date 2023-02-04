package ch20.sec07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql:// localhost:3306/thisisjava",
                    "java",
                    "mysql"
            );

            String sql = "UPDATE boards SET " +
					"btitle=?, " +
					"bcontent=?, " +
					"bfilename=?, " +
					"bfiledata=? " +
					"WHERE bno=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "눈사람");
            pstmt.setString(2, "눈으로 만든 사람");
            pstmt.setString(3, "snowman.jpg");
            pstmt.setBlob(4, new FileInputStream("src/ch20/mysql/sec07/snowman.jpg"));
            pstmt.setInt(5, 3);  // boards 테이블에 있는 게시물 번호(bno) 지정

            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수: " + rows);

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

