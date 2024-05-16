package com.mycompany.socketudp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class SOCKETUDP {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        BufferedReader userInput = null;
        
        try {
            // Configurar el socket UDP
            clientSocket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getByName("192.168.128.181");
            int serverPort = 12345;
            
            // Leer el número ingresado por el usuario
            userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese un número: ");
            String number = userInput.readLine();
            
            // Convertir el número a bytes y enviarlo al servidor
            byte[] sendData = number.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, serverPort);
            clientSocket.send(sendPacket);
            
            // Recibir la respuesta del servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String receivedSquare = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("El cuadrado del número es: " + receivedSquare);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (userInput != null) {
                    userInput.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
