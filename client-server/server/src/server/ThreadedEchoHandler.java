package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;
    /**
     * Конструирует обработчик
     * @param currentSocket Входящий сокет
     */

    public ThreadedEchoHandler(Socket currentSocket) {
        incoming = currentSocket;
    }
    public void run() {
        try {
            try {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true);
                // автоматическая очистка
                out.println("Hello! Enter BYE to exit.");
                // передать обратно данные, полученные от клиента
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if (line.trim().equals("BYE"))
                        done = true;
                }
            } finally {
                incoming.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
