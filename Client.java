package com.company;

import java.io.IOException;
import java.net.*;

public class Client {
    private DatagramSocket socket;
    private InetAddress ipAdress;
    private byte[] buffer;

    public Client(){
        try {
            socket = new DatagramSocket();
            ipAdress = InetAddress.getLocalHost();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String message){

        buffer = message.getBytes();
        DatagramPacket messagePacket = new DatagramPacket(buffer,buffer.length,ipAdress,1337);
        try {
            socket.send(messagePacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = new byte[buffer.length];
        messagePacket = new DatagramPacket(buffer,buffer.length);

        try {
            socket.setSoTimeout(1000);
            socket.receive(messagePacket);
        } catch (SocketTimeoutException e){
            System.out.println("Connection timed out!!!");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(messagePacket.getData(),0,messagePacket.getLength());
    }

    public void closeConnection(){
        socket.close();
    }

}
