package ru.khrebtov.Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

  private static final int PORT = 4545;

  public static void main(String[] args) {
    try (ServerSocket server = new ServerSocket(PORT)) {
      System.out.println("Server started");
      try (Socket socket = server.accept()) {
        System.out.println("Client connected");

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
              System.out.println("Client disconnected");
              System.out.println("Server stopped");
              break;
            }
            System.out.println("Client:" + str);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


