package sample;

public class Footballer {
    private String surName = "";
    private String firstName = "";
    private String middleName = "";
    private Date birthDate;
    private String team = "";
    private String homeCity = "";
    private String commandStructure = "";
    private String position = "";

    Footballer(String surName, String firstName, String middleName,
               Date birthDate, String team, String homeCity,
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

    public String getSurName(){
        return this.surName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getMiddleName(){
        return this.middleName;
    }

    public String getBirthDate(){
        return this.birthDate.getStringDate();
    }

    public String getTeam(){
        return this.team;
    }

    public String getHomeCity() {return this.homeCity;}

    public String getCommandStructure(){return this.commandStructure;}

    public String getPosition(){return this.position; }
}
