package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TableDisplay {
    //Table table;

    TableDisplay(Group root){
        this.createTable(root);
    }

    private void createTable(Group root){

        ObservableList <RowTable>  people = FXCollections.observableArrayList(
            new RowTable("chudopal", "alexandr", "sergeevich",
                    "23.09.2000", "Teaaam", "Minsk", "Str",
                    "Pos"),
            new RowTable("asdas", "wef", "sergeevich",
                    "23.09.2000", "wef", "wefv", "ef",
                    "afc")
        );

        TableView<RowTable> table = new TableView<RowTable>();

        TableColumn<RowTable, String> fullNameCol //
            = new TableColumn<RowTable, String>("Full Name");

        TableColumn<RowTable, String> surnameCol //
                = new TableColumn<RowTable, String>("Surname");
        TableColumn<RowTable, String> firstNameCol //
                = new TableColumn<RowTable, String>("First Name");
        TableColumn<RowTable, String> middleNameCol //
                = new TableColumn<RowTable, String>("Middle name");

        TableColumn<RowTable, String> birthDateCol //
                = new TableColumn<RowTable, String>("Birth date");

        TableColumn<RowTable, String> teamCol //
                = new TableColumn<RowTable, String>("Team");

        TableColumn<RowTable, String> homeCityCol //
                = new TableColumn<RowTable, String>("Home City");

        TableColumn<RowTable, String> structureCol //
                = new TableColumn<RowTable, String>("Structure of the team");

        TableColumn<RowTable, String> positionCol //
                = new TableColumn<RowTable, String>("Position");

        fullNameCol.getColumns().addAll(surnameCol, firstNameCol, middleNameCol);

        table.getColumns().addAll(fullNameCol, birthDateCol, teamCol, homeCityCol, structureCol, positionCol);

        root.getChildren().add(table);

    }

}
