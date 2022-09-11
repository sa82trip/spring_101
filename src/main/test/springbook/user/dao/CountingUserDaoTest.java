package springbook.user.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CountingUserDaoTest {
    @Test
   public void addAndGet () throws SQLException, ClassNotFoundException {

       ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
       UserDao dao = context.getBean("userDao", UserDao.class);

       dao.deleteAll();
       System.out.println("Table 초기화 완료!");
       User user = new User();
       user.setId("ordinaryD");
       user.setName("J");
       user.setPassword("password");
       dao.add(user);

       User user2 = dao.get(user.getId());
        assertThat(user.getId(), is(user2.getId()));
        assertThat(user.getName(), is(user2.getName()));
        assertThat(user.getPassword(), is(user2.getPassword()));

       CountingConnectionMaker ccm = context.getBean("getConnectionMaker", CountingConnectionMaker.class);
       System.out.printf("UserDao was used %d times%n",ccm.getCounter());
   }
}
