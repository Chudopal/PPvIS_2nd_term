/**
 *The drawing application
 * This program allows to draw and erase some figure on the canvas and
 * save them in png-format, if it necessary. Also an user can copy, paste
 * some fragments, zoom the canvas, and write text.
 @author Chudopal Alexandr*/

package sample;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        //stage.setScene(new Scene((Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"))));
        MainWindow mainWindow = new MainWindow(stage, 800, 800);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
