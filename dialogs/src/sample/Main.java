/**The football table application
 * It is a table with 6 columns, in wich
 * is information about people in the team.
 * The user can add new rows, delete ald rows,
 * and watch records.
 @author Alexandr Chudopal*/

package sample;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller(primaryStage, 800, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
