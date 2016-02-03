package com.tw.magixception;


import lombok.Data;

// {firstName: "thote", lastName:"thote", age:23, empId:1234, role:"Dev"}
@Data
public class Person {
    private String firstName = "a";
    private String lastName = "b";
    private int age = 19;
    private int empId = 123;
    private String role = "Dev";

    @Override
    public String toString() {
        return firstName + ":" + lastName + ":" + age + ":" + empId + ":" + role;
    }
}
