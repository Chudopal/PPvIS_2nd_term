package model;

import java.time.LocalDate;

public class Footballer {
    private String surName = "";
    private String firstName = "";
    private String middleName = "";
    private LocalDate birthDate;

    private String team = "";
    private String homeCity = "";
    private String commandStructure = "";
    private String position = "";

    public Footballer(String surName, String firstName, String middleName,
               LocalDate birthDate, String team, String homeCity,
               String commandStructure, String position){

        this.surName = surName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.team = team;
        this.homeCity = homeCity;
        this.commandStructure = commandStructure;
        this.position = position;

    }

    public boolean equal(Footballer footballer){
        if(footballer.getFirstName().equals(this.firstName)                &&
           footballer.getMiddleName().equals(this.middleName)              &&
           footballer.getSurName().equals(this.surName)                    &&
           footballer.getHomeCity().equals(this.homeCity)                  &&
           footballer.getBirthDate().equals(this.birthDate)                &&
           footballer.getTeam().equals(this.team)                          &&
           footballer.getCommandStructure().equals(this.commandStructure)  &&
           footballer.getPosition().equals(this.position)){
            return true;
        }
        return false;
    }

    public String getSurName(){
        return this.surName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getMiddleName(){
        return this.middleName;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public String getTeam(){
        return this.team;
    }

    public String getHomeCity() {return this.homeCity;}

    public String getCommandStructure(){return this.commandStructure;}

    public String getPosition(){return this.position; }
}
