package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class TableDisplay {

    private Group root;
    private double sizeX;
    private double sizeY;
    private ObservableList<Footballer> footballers = FXCollections.observableArrayList();

    private TableView<Footballer> table = new TableView<Footballer>(footballers);

    TableDisplay(Group root, double sizeX, double sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.root = root;
        this.createTable();
    }

    public void setFootballers(ArrayList<Footballer> footballers){
        this.footballers.addAll(footballers);
        this.createTable();
    }

    private void createTable(){

        Date date = new Date(1,2,2000);

        footballers.add(new Footballer("Surnamenamenamenamenamenamenamena",
                        "firstName",
                        "MiddleName",
                        date,
                        "Team",
                        "HomeCity",
                        "Struct",
                        "Pos")

        );

        //System.out.println(footballers.get(0).getSurName());

        footballers.add(new Footballer(
                "Chudopal",
                "Alex",
                "Sergeevich",
                new Date(1,2,1999),
                "Blia",
                "Kir",
                "Govno",
                "Str")
        );

        //System.out.println(rows.get(0).getSurName());

        table.setPrefWidth(sizeX);

        table.setPrefHeight(sizeY/2);

        TableColumn<Footballer, String> fullNameCol
            = new TableColumn<Footballer, String>("Full Name");

        TableColumn<Footballer, String> surnameCol
                = new TableColumn<Footballer, String>("Surname");

        TableColumn<Footballer, String> firstNameCol
                = new TableColumn<Footballer, String>("First Name");

        TableColumn<Footballer, String> middleNameCol
                = new TableColumn<Footballer, String>("Middle name");

        TableColumn<Footballer, String> birthDateCol
                = new TableColumn<Footballer, String>("Birth date");

        TableColumn<Footballer, String> teamCol
                = new TableColumn<Footballer, String>("Team");

        TableColumn<Footballer, String> homeCityCol
                = new TableColumn<Footballer, String>("Home City");

        TableColumn<Footballer, String> structureCol
                = new TableColumn<Footballer, String>("Structure of the team");

        TableColumn<Footballer, String> positionCol
                = new TableColumn<Footballer, String>("Position");

        fullNameCol.getColumns().addAll(surnameCol, firstNameCol, middleNameCol);

        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surName"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        teamCol.setCellValueFactory(new PropertyValueFactory<>("team"));
        homeCityCol.setCellValueFactory(new PropertyValueFactory<>("homeCity"));
        structureCol.setCellValueFactory(new PropertyValueFactory<>("commandStructure"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        surnameCol.setSortType(TableColumn.SortType.DESCENDING);

        table.getColumns().addAll(fullNameCol, birthDateCol, teamCol, homeCityCol, structureCol, positionCol);

        root.getChildren().add(table);

    }

}
