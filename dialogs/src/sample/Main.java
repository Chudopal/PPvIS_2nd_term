/**The football table application
 * It is a table with 6 columns, in wich
 * is information about people in the team.
 * The user can add new rows, delete ald rows,
 * and watch records.
 @author Alexandr Chudopal*/

package sample;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("HERE");
        ArrayList <Footballer> footballers = new ArrayList<>();

        footballers.add(new Footballer("surName", "FirstName", "Middle name", new Date("12:03:2000"), "Team", "City", "Struct", "pos"));

        footballers.add(new Footballer("Chudopal", "Alex", "Serg", new Date("12:03:2000"), "Team", "City", "Struct", "pos"));

        DOMParser domParser = new DOMParser(footballers, "xml_file1.xml");
        SAXPar saxPar = new SAXPar();
        //Controller controller = new Controller(primaryStage, 800, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
