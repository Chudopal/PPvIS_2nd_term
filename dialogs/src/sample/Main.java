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
        FootballerController footballerController = new FootballerController(primaryStage, 800, 800);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
