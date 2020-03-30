package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class TableDisplay {

    private VBox root;
    private double sizeX;
    private double sizeY;

    private ObservableList<Footballer> footballers = FXCollections.observableArrayList();

    private TableView<Footballer> table = new TableView<Footballer>(footballers);

    private TableColumn<Footballer, String> fullNameCol
            = new TableColumn<Footballer, String>("Full Name");

    private TableColumn<Footballer, String> surnameCol
            = new TableColumn<Footballer, String>("Surname");

    private TableColumn<Footballer, String> firstNameCol
            = new TableColumn<Footballer, String>("First Name");

    private TableColumn<Footballer, String> middleNameCol
            = new TableColumn<Footballer, String>("Middle name");

    private TableColumn<Footballer, String> birthDateCol
            = new TableColumn<Footballer, String>("Birth date");

    private TableColumn<Footballer, String> teamCol
            = new TableColumn<Footballer, String>("Team");

    private TableColumn<Footballer, String> homeCityCol
            = new TableColumn<Footballer, String>("Home City");

    private TableColumn<Footballer, String> structureCol
            = new TableColumn<Footballer, String>("Structure of the team");

    private TableColumn<Footballer, String> positionCol
            = new TableColumn<Footballer, String>("Position");

    TableDisplay(VBox root, double sizeX, double sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.root = root;
    }

    public void setFootballers(ArrayList<Footballer> footballers){
        this.footballers.clear();

        //ObservableList<Footballer> buffFootballers = FXCollections.observableArrayList(footballers);
        this.footballers.setAll(footballers);

    }



    public void clearTable(){
        table.getItems().clear();
    }

    public void createTable(){

        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surName"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        teamCol.setCellValueFactory(new PropertyValueFactory<>("team"));
        homeCityCol.setCellValueFactory(new PropertyValueFactory<>("homeCity"));
        structureCol.setCellValueFactory(new PropertyValueFactory<>("commandStructure"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        fullNameCol.getColumns().addAll(surnameCol, firstNameCol, middleNameCol);
        surnameCol.setSortType(TableColumn.SortType.DESCENDING);
        table.getColumns().addAll(fullNameCol, birthDateCol, teamCol, homeCityCol, structureCol, positionCol);
        table.setPrefWidth(sizeX);
        table.setPrefHeight(sizeY/2);
        root.getChildren().add(table);
    }
}
