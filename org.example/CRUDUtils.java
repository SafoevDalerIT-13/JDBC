package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CRUDUtils {

    public static List<Student> getStudentData(String query) {
        List<Student> students = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String curs_name = resultSet.getString("curse_name");

                students.add(new Student(id,name,surname,curs_name));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return students;
    }

}
