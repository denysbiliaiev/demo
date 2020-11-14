package com.example.demo.database.entity;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User(" +
                "id = " + id + " " +
                "firstName = " + firstName + " " +
                "lastName = " + lastName + " " +
                "age = " + age + " " +
                "email = " + email + " " +
                ")";
    }
}
