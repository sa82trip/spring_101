package springbook.user.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserDaoTest {
    @Test // Let JUnit know this method is a test
   public void addAndGet () throws SQLException, ClassNotFoundException {

        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        System.out.println("Table 초기화 완료!");
        User user = new User();
        user.setId("x31");
        user.setName("tk31");
        user.setPassword("pass123");
        dao.add(user);
        User user2 = dao.get(user.getId());
        assertThat(user.getId(), is(user2.getId()));
        assertThat(user.getName(), is(user2.getName()));
        assertThat(user.getPassword(), is(user2.getPassword()));
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