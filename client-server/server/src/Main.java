import controller.FootballerController;
import javafx.application.Application;
import javafx.stage.Stage;
import server.Server;
import view.MainWindow;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FootballerController footballerController = new FootballerController();
        Server server = new Server(footballerController);
        MainWindow mainWindow = new MainWindow(primaryStage, server);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
