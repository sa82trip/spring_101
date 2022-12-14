package springbook.user.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
public class CountingDaoFactory {
    @Bean // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    public UserDao userDao () {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(getConnectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker getConnectionMaker() {
        // return connectionMaker with counting feature and realConnectionMaker
        return new CountingConnectionMaker(getRealConnectionMaker());
    }

    @Bean
    public ConnectionMaker getRealConnectionMaker() {
        return new DConnectionMaker();
    }

}
