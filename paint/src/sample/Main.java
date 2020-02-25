/**The drawing application
 * This program allows to draw and erase some figures on the canvas and
 * save them in png-format, if it necessary. Also an user can copy, paste
 * some fragments, zoom the canvas, and paste a text.
 @author Chudopal Alexandr*/

package sample;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        MainWindow mainWindow = new MainWindow(stage, 700, 700);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
