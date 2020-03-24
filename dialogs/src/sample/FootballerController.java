package sample;

import javafx.stage.Stage;

import java.util.ArrayList;

public class FootballerController extends MainWindowView {

    private ArrayList <Footballer> footballers = new ArrayList<>();

    FootballerController(Stage stage, double sizeX, double sizeY){
        super(stage, sizeX, sizeY);
        this.Handler();
    }

    private void Handler(){
        Pars pars = new Pars("file.xml");
        footballers.clear();
        table.setFootballers(pars.readFile());
        table.createTable();
    }

}
