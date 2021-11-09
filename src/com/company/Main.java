package com.company;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        System.out.println("Сервер запущен");
        int port = 8000;// на этом порту ждем подключение от клиента

        ServerSocket serverSocket = new ServerSocket(port);// создаем серверный сокет, для серверного подключения
        //на сервере создаем ожидание клиента
        Socket clientSocket = serverSocket.accept();// суть команды - принять от клиента подключение, будет отключена только после подключения
        // клиента к нашему серверу, зависнет- будет ожидать
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Соединение принято");
        final String name = in.readLine();
        out.println(String.format("Привет %s, твой порт %d", name, clientSocket.getPort()));
        serverSocket.close();


        PrintWriter pr = new PrintWriter(clientSocket.getOutputStream(),true);
        pr.println("Напиши свое имя");
        pr.flush();

        InputStreamReader in2 = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bf2 = new BufferedReader(in2);
        String str2 = bf2.readLine();
        System.out.println(("Клиент: " + str2));


        PrintWriter pr2 = new PrintWriter(clientSocket.getOutputStream(),true);
        pr.println("Ты ребенок?");
        pr.flush();

        InputStreamReader in3 = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bf3 = new BufferedReader(in3);
        String str3 = bf3.readLine();
        System.out.println("Клиент: " + str3);

        PrintWriter pr3 = new PrintWriter(clientSocket.getOutputStream());
        if (str3.equals("да")){
            pr3.println(" Добро пожаловать в детский уголок " + str2 +". Давайте играть!");
        } else {
            pr3.println(" Добро пожаловать во взрослый уголок " + str2 + " ! Хорошего дня!");
        }
        pr3.flush();
    }
}
