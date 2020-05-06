import controller.FootballerController;
import model.Footballer;
import server.Server;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main{


    public static void main(String[] args) throws IOException {

        FootballerController footballerController = new FootballerController();
        Server server = new Server(footballerController);
    }
}
