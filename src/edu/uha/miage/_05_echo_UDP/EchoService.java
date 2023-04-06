/*
 * Creative commons CC BY-NC-SA 2020 Yvan Maillot <yvan.maillot@uha.fr>
 *
 *     Share - You can copy and redistribute the material in any medium or format
 * 
 *     Adapt - You can remix, transform, and build upon the material 
 * 
 * Under the following terms :
 * 
 *     Attribution - You must give appropriate credit, provide a link to the license, 
 *     and indicate if changes were made. You may do so in any reasonable manner, 
 *     but not in any way that suggests the licensor endorses you or your use. 
 * 
 *     NonCommercial — You may not use the material for commercial purposes. 
 * 
 *     ShareAlike — If you remix, transform, or build upon the material, 
 *     you must distribute your contributions under the same license as the original. 
 * 
 * Notices:    You do not have to comply with the license for elements of 
 *             the material in the public domain or where your use is permitted 
 *             by an applicable exception or limitation. 
 * 
 * No warranties are given. The license may not give you all of the permissions 
 * necessary for your intended use. For example, other rights such as publicity, 
 * privacy, or moral rights may limit how you use the material. 
 * 
 * See <https://creativecommons.org/licenses/by-nc-sa/4.0/>.
 */
 // On crée un socket UDP
        // On crée un buffer pour recevoir les messages
        // On crée un datagramme pour recevoir les messages
        // On attend un message
        // On récupère l'adresse du client
        // On récupère le port du client
        // On récupère le message
        // On affiche le message
        // On crée un datagramme pour envoyer le message
        // On envoie le message
package edu.uha.miage._05_echo_UDP;

import java.io.*;
import java.net.*;

/**
 * Un serveur au comportement similaire à _01_serveur_echo.EchoService mais en
 * utilisant le protocole UDP.
 */
public class EchoService {

    public static void main(String[] args) throws SocketException, IOException {
       
    	
        try (DatagramSocket socket = new DatagramSocket(1414)) {
            byte[] buffer = new byte[256];

             DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            InetAddress clientAddress = packet.getAddress();

            int clientPort = packet.getPort();

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(message.toUpperCase());
            System.out.println("Message reçu : " + message);

            packet = new DatagramPacket(message.getBytes(), message.length(), clientAddress, clientPort);

            socket.send(packet);
           
                // for (int i = 0; i < 100; i++) {
                //     socket.receive(packet);
                //     InetAddress clientAddress = packet.getAddress();
                //     int clientPort = packet.getPort();
                //     String message = new String(packet.getData(), 0, packet.getLength());
                //     System.out.println("Message reçu : " + message);
                //     packet = new DatagramPacket(message.getBytes(), message.length(), clientAddress, clientPort);
                //     socket.send(packet);
                    
                // }

            socket.close();

        }        

    


    }
}
