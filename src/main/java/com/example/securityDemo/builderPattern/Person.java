package com.example.securityDemo.builderPattern;

public class Person {
    private final String name;
    private final String gender;
    private final int age;

    private Person(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
    }

    public static class Builder {
        private final String name;
        private String gender;
        private int age;

        public Builder (String name) { //mandatory field
            this.name = name;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String toString() {
        return name + ", " + gender + ", " + age;
    }
}
