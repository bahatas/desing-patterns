package com.builder.methodlevel;

public class MainMethodLevel {
    public static void main(String[] args) {
        var is = ImmutableStudentBuilderClass.myMethodlevelBuilder()
                .id(1)
                .name("Student")
                .build();

        System.out.println("is = " + is);
    }
}
