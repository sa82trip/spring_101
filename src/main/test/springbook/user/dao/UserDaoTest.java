package springbook.user.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserDaoTest {
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;
    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
         this.dao = context.getBean("userDao", UserDao.class);
        this.user1 = new User("joon", "ordinary", "opass");
        this.user2 = new User("M","maike","mpass");
        this.user3 = new User("J","jon","jpass");
    }
    @Test // Let JUnit know this method is a test
   public void addAndGet () throws SQLException, ClassNotFoundException {

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));
        System.out.println("Table 초기화 완료!");
        User user = new User();
        user.setId("x31");
        user.setName("tk31");
        user.setPassword("pass123");
        dao.add(user);
        assertThat(dao.getCount(), is(1));
        User user2 = dao.get(user.getId());
        assertThat(user.getId(), is(user2.getId()));
        assertThat(user.getName(), is(user2.getName()));
        assertThat(user.getPassword(), is(user2.getPassword()));
   }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        User user1 = new User("guiyom", "park", "pass111");
        User user2 = new User("Mac", "lee", "pass222");
        User user3 = new User("Guic", "Cho", "pass333");
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));
        dao.add(user1);
        assertThat(dao.getCount(), is(1));
        dao.add(user2);
        assertThat(dao.getCount(), is(2));
        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));
        dao.get("DoesnotExistId");
    }

    @Test
    public void deleteAll() {
    }
}