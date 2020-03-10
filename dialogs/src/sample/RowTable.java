package sample;

public class RowTable {

    private String surName = "";
    private String firstName = "";
    private String middleName = "";
    private String birthDate = "";
    private String team = "";
    private String homeCity = "";
    private String commandStructure = "";
    private String position = "";

    RowTable(String surName, String firstName, String middleName,
             String birthDate, String team, String homeCity,
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

    String getSurName(){
        return this.surName;
    }

    String getFirstName(){
        return this.firstName;
    }

    String getMiddleName(){
        return this.middleName;
    }

    String birthDate(){
        return this.birthDate;
    }

    String getTeam(){
        return this.team;
    }

    String getHomeCity() {return this.homeCity;}

    String getCommandStructure(){return this.commandStructure;}

    String getPosition(){return this.position; }
}
