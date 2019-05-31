package com.polytask.repository;

import com.polytask.business.Task;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTaskRepository implements TaskRepository {
    private DataSource dataSource;

    public JdbcTaskRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List findAll() {
        List<Task> results = new ArrayList<>();
        try{
            Connection connection = dataSource.getConnection();
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM task";

            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                String content = resultSet.getString("CONTENT");

                Task task = new Task(content);

                results.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public void add(Task task) {
        try{
            //get connection
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO task(CONTENT) VALUES('" + task.getContent() + "')";

            //execute query
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
