package springbook.user.dao;

import org.junit.Test;
import springbook.user.domain.User;

import java.sql.SQLException;


public class UserDaoTest {

    @Test
    public void add() throws SQLException, ClassNotFoundException {

        UserDao dao = new DaoFactory().userDao();

        dao.deleteAll();
        System.out.println("Table 초기화 완료!");
        User user = new User(); user.setId("ordinaryD"); user.setName("J"); user.setPassword("password");
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");
        User user2 = dao.get(user.getId()); System.out.println(user2.getName()); System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }

    @Test
    public void get() {
    }

    @Test
    public void deleteAll() {
    }
}