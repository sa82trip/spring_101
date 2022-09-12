package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionMakerWithStdOut implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        StackWalker walker = StackWalker.getInstance();
        Optional<String> methodName = walker.walk(frames -> frames
                .findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        System.out.printf("method name: %s%n", methodName.orElse("can't find current method"));
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.printf("caller method name: %s%n", stackTraceElements[2]);
        Class.forName("com.mysql.cj.jdbc.Driver");  // this part is not necessary anymore
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:53306/springbook", "spring", "book");
    }
}
