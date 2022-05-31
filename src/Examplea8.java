import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Examplea8 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                               "jdbc:mysql://localhost:3306/ebookshop", "root","");
        PreparedStatement psmt = conn.prepareStatement(
                "insert into books values (?,?,?,?,?)");
        conn.setAutoCommit(false);

        psmt.setInt(1,8803);
        psmt.setString(2,"Java123");
        psmt.setString(3,"kevin");
        psmt.setDouble(4,12.34);
        psmt.setInt(5,88);
        psmt.addBatch();

        psmt.setInt(1,8004);
        psmt.setString(2,"Java 467");
        psmt.addBatch();

        int[] returnCodes = psmt.executeBatch();

        System.out.println("Return codes are: ");
        for (int code: returnCodes) System.out.println(code + ",");
        System.out.println();
        conn.commit();
    }
}
