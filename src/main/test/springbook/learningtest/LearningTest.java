package springbook.learningtest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;

public class LearningTest {

    @Test
    public void daoFactoryIdentityCompare() {
        // This means dao1 and dao2 are two different object
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();
        System.out.println((String.format("dao1: %s", dao1)));
        System.out.println((String.format("dao2: %s", dao2)));
        Assert.assertNotEquals(dao1, dao2);
    }

    @Test
    public void applicationContextIdenticalTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao1 = context.getBean("userDao", UserDao.class);
        UserDao dao2 = context.getBean("userDao", UserDao.class);
        System.out.println((String.format("dao1: %s", dao1)));
        System.out.println((String.format("dao2: %s", dao2)));
        Assert.assertEquals(dao1, dao2);
    }

    @Test
    public void equalityAndIdentical() {
        String s1 = "hoho";
        String s2 = "hoho";
        String s3 = s1;
        Assert.assertTrue(s1 == s2);
    }

    @Test
    public void test2() {
        String str1 = "0-42L";
        String str2 = "0-43-";

        System.out.println("String equality: " + str1.equals(str2));
        System.out.println("HashCode eqauality: " + (str1.hashCode() == str2.hashCode()));
    }

    @Test
    public void objectCompare() {
        SampleModel model1 = new SampleModel();
        SampleModel model2 = new SampleModel();
        SampleModel model3 = model1;
        model2.setName("gil");
        model1.setName("gil");
        Assert.assertNotEquals(model1,model2);
        Assert.assertSame(model1,model3);
    }

    class SampleModel {
        String name;

        public void setName(String name) {
            this.name = name;
        }
    }
}