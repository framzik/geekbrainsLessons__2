package ru.khrebtov.Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  private static final int PORT = 4545;
  private static final String SERVER_ADDR = "localhost";


  public static void main(String[] args) {
    try (Socket socket = new Socket(SERVER_ADDR, PORT)) {
      System.out.println("Client started");

      Thread t1 = new Thread(() -> {
        try (Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
          while (true) {
            String str = sc.nextLine();
            if (str.equals("/end")) {
              out.println("/end");
              break;
            }
            out.println(str);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      t1.setDaemon(true);
      t1.start();

      try (Scanner scSocket = new Scanner(socket.getInputStream())) {
        while (true) {
          String str;
          if (scSocket.hasNext()) {
            str = scSocket.nextLine();
          } else {
            str = "/end";
          }

          if (str.equals("/end")) {
            System.out.println("Server disconnected");
            System.out.println("Client stopped");
            break;
          }
          System.out.println("Server:" + str);
        }


      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
