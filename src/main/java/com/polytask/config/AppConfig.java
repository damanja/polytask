package com.polytask.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytask.business.FeedService;
import com.polytask.business.FeedServiceImpl;
import com.polytask.business.TaskService;
import com.polytask.business.TaskServiceImpl;
import com.polytask.repository.JdbcTaskRepository;
import com.polytask.repository.JpaTaskRepository;
import com.polytask.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    TaskRepository taskRepository(){
       // return new JpaTaskRepository();
        return new JdbcTaskRepository(dataSource());
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
}
