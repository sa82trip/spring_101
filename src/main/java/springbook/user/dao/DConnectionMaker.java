package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        System.out.println("This is DConnectionMaker which is providing connection");
        Class.forName("com.mysql.cj.jdbc.Driver");  // this part is not necessary anymore
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:53306/springbook", "spring", "book");
    }
}
