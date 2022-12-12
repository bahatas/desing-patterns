package com.builder.withInheritance;

public class MainBuilderWithInheritance {
    public static void main(String[] args) {
        var student = Student.builder()
                .name("John")
                .surname("Doe")
                .email("email")
                .phoneNumber(123455)
                .year(2)
                .build();

        System.out.println(student);
    }

}
