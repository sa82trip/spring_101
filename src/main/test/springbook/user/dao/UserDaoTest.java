package springbook.user.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;


public class UserDaoTest {
    @Test // Let JUnit know this method is a test
   public void addAndGet () throws SQLException, ClassNotFoundException {

       ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
       UserDao dao = context.getBean("userDao", UserDao.class);

       dao.deleteAll();
       System.out.println("Table 초기화 완료!");
       User user = new User();
       user.setId("ordinaryD");
       user.setName("J");
       user.setPassword("password");
       dao.add(user);
       System.out.println(user.getId() + " 등록 성공");
       User user2 = dao.get(user.getId()); System.out.println(user2.getName()); System.out.println(user2.getPassword());
       System.out.println(user2.getId() + " 조회 성공");
   }

    @Test
    public void add() {
    }

    @Test
    public void get() {
    }

    @Test
    public void deleteAll() {
    }
}