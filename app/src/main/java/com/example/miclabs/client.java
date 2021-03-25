package com.example.miclabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client implements Runnable{

    public void run() {
        try {

            final Socket clientSocket;
            final BufferedReader in;
            final PrintWriter out;
            final Scanner sc = new Scanner(System.in);//pour lire à partir du clavier

            System.out.println("On va lancer une connexion");
            InetAddress serverAddr = InetAddress.getByName("192.168.43.228");
            clientSocket = new Socket(serverAddr,12805);
            System.out.println("TEEESEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEst");
            clientSocket.setSoTimeout(10);
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //La on envoie la string pour recevoir toutes les infos
            out.println("Fermer|");
            //out.println("Tout|");
            out.flush();
            /*
             * Pour recevoir la liste reduite : 'liste reduite|'
             * Pour recevoir les infos pour un id précis : 'id,info|'
             * Pour recevoir la photo d'un id précis : "id,photo|'
             */

            String msg;

            msg = in.readLine();

            System.out.println("Serveur : "+msg);

            System.out.println("Serveur déconecté");
            out.close();
            clientSocket.close();

            //Pour fermer le serveur quand on a terminé
            out.println("Fermer|");

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
