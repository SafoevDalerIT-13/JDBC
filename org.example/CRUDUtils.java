package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CRUDUtils {
    private static String INSERT_STUDENT = "INSERT INTO students (name, surname, curse_name) VALUES (?, ?, ?)";
    private static String GET_ALL_STUDENT = "SELECT * FROM students";

    public static List<Student> getStudentData() {
        List<Student> students = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENT)) {
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

    public static List<Student> createStudentData(Student student) {
        List<Student> students = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSurname());
            preparedStatement.setString(3,student.getCurse_name());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public static List<Student> saveStudentData(Student student) {
        List<Student> students = new ArrayList<>();

        try(Connection connection = DBUtils.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSurname());
            preparedStatement.setString(3,student.getCurse_name());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 =  connection.prepareStatement(GET_ALL_STUDENT);
            ResultSet resultSet = preparedStatement1.executeQuery();

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
