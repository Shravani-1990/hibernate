package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "roll_number", unique = true, nullable = false)
    private int rollNumber;

    // ✅ No-arg constructor (Required by Hibernate)
    public Student() {}

    // ✅ Parameterized constructor
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // ✅ Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", rollNumber=" + rollNumber + "]";
    }
}
