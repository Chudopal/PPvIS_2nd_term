import controller.FootballerController;
import model.Footballer;
import server.Server;

import java.io.File;
import java.io.IOException;

public class Main{


    public static void main(String[] args) throws IOException {
        FootballerController footballerController = new FootballerController();
        File file = new File(".//examples//file.xml");
        footballerController.readFile(file);
        /*for (Footballer footballer :footballerController.getPage(1,10)) {
            System.out.println(footballer.getSurName());
        }*/
        Server server = new Server(footballerController);
    }
}
