package sample;

public class Date {

    private int year, month, day;

    Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
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
        date += this.year + ":" + this.month + ":" + this.day;
        return date;
    }
}
