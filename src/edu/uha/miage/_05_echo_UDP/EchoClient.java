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
package edu.uha.miage._05_echo_UDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Un client au comportement similaire à _02_client_echo.EchoClient 
 * Par extension de la classe javax.swing.JLabel et à l'aide des threads,
 * développer une classe DayTimeClient capable d'afficher le jour et l’heure en
 * lançant des requêtes au serveur DayTimeService.
 * mais en
 * utilisant le protocole UDP.
 */
public class EchoClient {

    public static /**
     * Le client envoie des messages au serveur tant qu'il le souhaite.
     */
    
    void main(String[] args) throws SocketException, IOException {
        // TODO 1.05
        try (DatagramSocket socket = new DatagramSocket();
				Scanner sc = new Scanner(System.in)) {
           while (true) {
                System.out.print("Message à envoyer : ");
                String message = sc.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                byte[] tampon = message.getBytes();
                DatagramPacket packet = new DatagramPacket(tampon, tampon.length, InetAddress.getByName("localhost"), 1414);
                socket.send(packet);
                packet = new DatagramPacket(tampon, tampon.length);
                socket.receive(packet);
                System.out.println("Message reçu : " + new String(packet.getData()));
           }
            
            // for (int i = 0; i < 100; i++) {
            //     String message = "Message " + i;
            //     byte[] buffer = message.getBytes();
            //     DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 1414);
            //     socket.send(packet);
            //     packet = new DatagramPacket(buffer, buffer.length);
            //     socket.receive(packet);
            //     System.out.println("Message reçu : " + new String(packet.getData()));

            // }
       // }
        }        
    }
}
