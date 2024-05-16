package com.mycompany.tcpsocket;

import java.net.*;
import java.io.*;
public class TCPSOCKET {

    public static void main(String[] args) {
        
        try{
        
            Socket Client = new Socket("192.168.128.181", 5000);
            System.out.println("DiosaDeDiosa se conectó.");
            
            //Leemos los datos que nos manda DIOSDEDIOSSERVEER
            BufferedReader br = new BufferedReader(new InputStreamReader(Client.getInputStream()));
            while(true){
                String data = br.readLine();
                System.out.println("Te mando estos datos impotantísimos DiosaDeDiosa: " + data);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
