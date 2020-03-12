package sample;

import javafx.collections.ObservableList;

public class Table {
    private ObservableList <RowTable> rows;
    Table(){}

    public void addRow(RowTable row){
        rows.add(row);
    }

    public void deleteRow(int index){
        rows.remove(index);
    }

    public RowTable getRow(int index){
        return rows.get(index);
    }

    public void createNewRow(Footballer footballer){
        RowTable rowTable = new RowTable(footballer);
        this.addRow(rowTable);
    }

    public void createTableOnList(ObservableList<Footballer> footballers){
        for(int i = 0; i < footballers.size(); i++){
            RowTable row = new RowTable(footballers.get(i));
        }
    }

    public ObservableList <RowTable> getList(){
        return rows;
    }
}
