/**The football table application
 * It is a table with 6 columns, in witch
 * is information about people in the team.
 * The user can add the new rows, delete the rows,
 * find the rows
 * and watch records.
 @author Alexandr Chudopal*/

import controller.FootballerController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainWindowHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FootballerController footballerController = new FootballerController();
        MainWindowHandler mainWindowHandler = new MainWindowHandler(
                footballerController,
                primaryStage,
                800,
                600);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
