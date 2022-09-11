package springbook.user.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;


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
       System.out.println(user.getId() + " 등록 성공");

       User user2 = dao.get(user.getId());
       System.out.println(user2.getName());
       System.out.println(user2.getPassword());

       if(!user.getName().equals(user2.getName())){
           System.out.printf("Test failed on comparing Name expected - %s : actual - %s %n",user.getName(), user2.getName());
       }
       else if(!user.getPassword().equals(user2.getPassword())){
           System.out.printf("Test filed on comparing Password expected - %s : actual - %s %n",user.getPassword(), user2.getPassword());
       }
       else System.out.println(user2.getId() + " 조회 test 성공");
       CountingConnectionMaker ccm = context.getBean("getConnectionMaker", CountingConnectionMaker.class);
       System.out.printf("UserDao was used %d times%n",ccm.getCounter());
   }
}
