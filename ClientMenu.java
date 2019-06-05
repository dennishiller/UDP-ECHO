package com.company;

import java.util.Scanner;

public class ClientMenu {

    public ClientMenu(){
        showMenu();
    }

    public void showMenu() {
        boolean started = true;
        Client client = new Client();

        while (started) {
            System.out.print("###########\n" +
                    "1. Send Message \n" +
                    "2. Exit \n" +
                    "###########\n" +
                    "Make your decision: \n");
            int decision = getInput();
            if (decision == 1) {
                System.out.println(client.sendMessage(messageInput()));
            } else if (decision == 2) {
                started = false;
            } else {
                getInput();
            }
        }
    }

    public int getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String messageInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
