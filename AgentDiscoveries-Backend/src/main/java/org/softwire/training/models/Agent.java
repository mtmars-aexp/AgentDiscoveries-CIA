package org.softwire.training.models;

import java.time.LocalDate;

public class Agent {

    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int rank;
    private String callSign;

    public Agent() {

    }

    public Agent(int userId, String firstName, String lastName, LocalDate dateOfBirth, int rank, String callSign) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.rank = rank;
        this.callSign = callSign;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getUserId(){return userId;}

    public void setUserId(int userId){this.userId = userId;}
}
