package com.company;
import java.io.IOException;
import java.net.*;

public class Server extends Thread{
    private DatagramSocket socket;
    private boolean started;
    private byte[] buffer = new byte[256];

    public Server(){
        try {
            socket = new DatagramSocket(1337);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run(){
      startServer();
    }

    public void startServer(){
        started = true;
        while(started){
            DatagramPacket p = new DatagramPacket(buffer,buffer.length);
            try {
                socket.receive(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
            InetAddress senderAdress = p.getAddress();
            int senderPort = p.getPort();
            p = new DatagramPacket(buffer,buffer.length,senderAdress,senderPort);
            try {
                socket.send(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}