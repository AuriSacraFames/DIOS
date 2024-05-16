package com.mycompany.serversocketudp;

import java.net.*;

public class ServerSOCKETUDP {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        
        try {
            // Configurar el socket UDP para escuchar en todas las interfaces de red
            serverSocket = new DatagramSocket(12345, InetAddress.getByName("192.168.128.181"));
            
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
            System.out.println("El servidor está listo para recibir...");
            
            while (true) {
                // Recibir datos del cliente
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                // Convertir los datos recibidos a un entero y calcular el cuadrado
                String receivedNumber = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int number = Integer.parseInt(receivedNumber);
                int square = number * number;
                
                // Obtener la dirección IP y el puerto del cliente
                InetAddress clientIP = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                // Convertir el cuadrado a bytes y enviarlo al cliente
                sendData = String.valueOf(square).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}