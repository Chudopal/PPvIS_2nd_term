package sample;

public class Date {

    private String year, month, day;

    Date(String day, String month, String year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    Date(String date){
        this.day = date.substring(0, date.length() - 8);
        this.month = date.substring(3, date.length() - 5);
        this.year = date.substring(6, date.length());//xx:xx:xxxx
    }

    private String getYear(){
        return this.year;
    }

    public String getMonth(){
        return this.month;
    }

    public String getDay(){
        return this.day;
    }

    public String getStringDate(){
        String date = "";
        date += this.day + ":" + this.month + ":" + this.year;
        return date;
    }
}
