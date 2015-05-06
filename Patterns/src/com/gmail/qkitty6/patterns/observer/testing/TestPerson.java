/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.qkitty6.patterns.observer.testing;

/**
 * A very simple Person class for testing purposes
 *
 * @author Roy
 */
public class TestPerson {

    private String forename;
    private String surname;
    private int age;

    public TestPerson() {
        this.forename = "UNKNOWN";
        this.surname = "UNKNOWN";
        this.age = 0;
    }

    public TestPerson(String newForename, String newSurname, Integer newAge) {
        this.forename = newForename;
        this.surname = newSurname;
        this.age = newAge;
    }

    public boolean setNewDetails(String newForename, String newSurname, Integer newAge) {
        boolean wasSet = false;
        if (null != newForename && null != newSurname && 0 < newAge) {
            this.forename = newForename;
            this.surname = newSurname;
            this.age = newAge;
            wasSet = true;
        }
        return wasSet;
    }

    /**
     * @return the forename
     */
    public String getForename() {
        return forename;
    }

    /**
     * @param forename the forename to set
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestPerson{" + "forename=" + forename + ", surname=" + surname + ", age=" + age + '}';
    }

}
