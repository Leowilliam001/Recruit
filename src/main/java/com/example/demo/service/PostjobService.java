package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Empl;
import com.example.demo.repository.PostjobRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// import java.util.List;

@Service
public class PostjobService {

    @Autowired
    private final PostjobRepo postjobRepository;

    public PostjobService(PostjobRepo postjobRepository) {
        this.postjobRepository = postjobRepository;
    }

    public void saveJob(String role, String salary, String phno) {
        Empl e = new Empl();
        e.role = role;
        e.salary = salary;
        e.phno = phno;
        postjobRepository.save(e);
    }

    public void remJob(String role) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "");
                PreparedStatement preparedStatement = conn.prepareStatement("delete from job where role=?")) {

            preparedStatement.setString(1, role);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet retJob() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "");
        PreparedStatement preparedStatement = conn.prepareStatement("select * from job");

        ResultSet rs = preparedStatement.executeQuery();
        return rs;

    }
}
