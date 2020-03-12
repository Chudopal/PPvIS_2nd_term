package sample;

public class RowTable {

    Footballer footballer;

    RowTable(Footballer footballer){
        this.footballer = footballer;
    }

    public String getSurName(){
        return this.footballer.getSurName();
    }

    public String getFirstName(){
        return this.footballer.getFirstName();
    }

    public String getMiddleName(){
        return this.footballer.getMiddleName();
    }

    public String getBirthDate(){
        return this.footballer.getBirthDate().getStringDate();
    }

    public String getTeam(){
        return this.footballer.getTeam();
    }

    public String getHomeCity() {return this.footballer.getHomeCity();}

    public String getCommandStructure(){return this.footballer.getCommandStructure();}

    public String getPosition(){return this.footballer.getPosition(); }
}
