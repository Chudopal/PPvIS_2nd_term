package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;


public class TableDisplay {

    TableDisplay(Group root){
        this.createTable(root);
    }

    private void createTable(Group root){


        Date date = new Date(1,2,2000);

        ObservableList <Footballer> footballers = FXCollections.observableArrayList(
                new Footballer("Surname",
                        "firstName",
                        "MiddleName",
                        date,
                        "Team",
                        "HomeCity",
                        "Struct",
                        "Pos")

        );

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

        ObservableList <RowTable> rows = FXCollections.observableArrayList(
                new RowTable(footballers.get(0)),
                new RowTable(footballers.get(1))
        );

        TableView<RowTable> table = new TableView<RowTable>(rows);

        table.setPrefWidth(800);

        table.setPrefHeight(500);

        TableColumn<RowTable, String> fullNameCol
            = new TableColumn<RowTable, String>("Full Name");

        TableColumn<RowTable, String> surnameCol
                = new TableColumn<RowTable, String>("Surname");

        TableColumn<RowTable, String> firstNameCol
                = new TableColumn<RowTable, String>("First Name");

        TableColumn<RowTable, String> middleNameCol
                = new TableColumn<RowTable, String>("Middle name");

        TableColumn<RowTable, String> birthDateCol
                = new TableColumn<RowTable, String>("Birth date");

        TableColumn<RowTable, String> teamCol
                = new TableColumn<RowTable, String>("Team");

        TableColumn<RowTable, String> homeCityCol
                = new TableColumn<RowTable, String>("Home City");

        TableColumn<RowTable, String> structureCol
                = new TableColumn<RowTable, String>("Structure of the team");

        TableColumn<RowTable, String> positionCol
                = new TableColumn<RowTable, String>("Position");

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
