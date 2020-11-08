package com.example.app;

public class Member {
    private String Name;
    private int Age;
    private String Address;
    private long number;
    private long gNumber1;
    private long gNumber2;
    private long fireNumber;
    private long hospitalNumber;
    private long policeNumber;
    private String email;
    private String password;


    public Member() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getgNumber1() {
        return gNumber1;
    }

    public void setgNumber1(long gNumber1) {
        this.gNumber1 = gNumber1;
    }

    public long getgNumber2() {
        return gNumber2;
    }

    public void setgNumber2(long gNumber2) {
        this.gNumber2 = gNumber2;
    }

    public long getFireNumber() {
        return fireNumber;
    }

    public void setFireNumber(long fireNumber) {
        this.fireNumber = fireNumber;
    }

    public long getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(long hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public long getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(long policeNumber) {
        this.policeNumber = policeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
