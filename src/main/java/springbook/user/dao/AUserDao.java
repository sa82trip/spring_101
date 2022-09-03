package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AUserDao extends UserDao {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("This is for Company A");
        Class.forName("com.mysql.cj.jdbc.Driver");  // this part is not necessary anymore
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:53306/springbook", "spring", "book");
    }
}
