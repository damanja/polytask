package com.polytask.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytask.business.*;
import com.polytask.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    TaskRepository taskRepository(){
        return new JpaTaskRepository();
    }

    @Bean
    UserRepository userRepository(){
        return new JpaUserRepository();
    }

    @Bean
    AuthorityRepository authorityRepository(){
        return new JpaAuthorityRepository();
    }

    @Bean
    DataSource dataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://mysql-manjary.alwaysdata.net:3306/manjary_task?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        dataSource.setUser("manjary");
        dataSource.setPassword("PolyTask");
        dataSource.setDatabaseName("PolyTask");
        return dataSource;
    }

    @Bean
    FeedService feedService(){
        return new FeedServiceImpl(taskRepository());
    }

    @Bean
    TaskService taskService(){
        return new TaskServiceImpl(taskRepository());
    }

    @Bean
    RegisterService registerService(){
        return new RegisterServiceImpl(userRepository(), authorityRepository());
    }


}
