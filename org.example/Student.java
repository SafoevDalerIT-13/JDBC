package org.example;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String curse_name;

    public Student() {
        this.id = 0;
        this.name = null;
        this.surname = null;
        this.curse_name = null;
    }

    public Student(int id,String name,String surname,String curse_name) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.curse_name = curse_name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getCurse_name() {
        return this.curse_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCurse_name(String curse_name) {
        this.curse_name = curse_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "curse_name='" + curse_name + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
