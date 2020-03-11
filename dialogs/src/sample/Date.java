package sample;

public class Date {

    private int year, month, day;

    Date(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    Date(String date){
        this.day = Integer.parseInt(date.substring(0, date.length() - 8));
        this.month = Integer.parseInt(date.substring(3, date.length() - 5));
        this.year = Integer.parseInt(date.substring(6, date.length()));//xx:xx:xxxx
    }

    private int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public String getStringDate(){
        String date = "";
        date += this.day + ":" + this.month + ":" + this.year;
        return date;
    }
}
