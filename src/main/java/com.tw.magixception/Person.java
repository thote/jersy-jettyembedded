package com.tw.magixception;


// {firstName: "thote", lastName:"thote", age:23, empId:1234, role:"Dev"}
public class Person {
    String firstName = "a";
    String lastName = "b";
    int age = 19;
    int empId = 123;
    String role = "Dev";

    public Person() {
    }

    public Person(String firstName, String lastName, int age, int empId, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.empId = empId;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + ":" + lastName + ":" + age + ":" + empId + ":" + role;
    }
}
