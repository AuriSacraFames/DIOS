package com.mycompany.servertcp;

import java.net.*;
import java.io.*;
import java.util.*;
public class ServerTCP {

    public static void main(String[] args) {
       try{
           ServerSocket ss = new ServerSocket(5000);
           System.out.println("Cliente DiosaDeDiosa esperando...");
           Socket server = ss.accept();
           System.out.println("Conectado al servidor DIOSDEDIOS.");
           
           //ENVIAMOS LOS DATOS AL CLIENTE
           Scanner sc = new Scanner(System.in);
           PrintWriter pw = new PrintWriter(server.getOutputStream());
           while(true){
               System.out.print("Estos son los datos DiosaDeDiosa: ");
               String data = sc.nextLine();
               pw.println(data);
               pw.flush();
           }
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
}