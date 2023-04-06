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
package edu.uha.miage._03_serveur_echo;

import java.io.*;
import java.net.*;

/**
 * Le serveur "echo" attend un message d'un client pour lui retourner en
 * majuscule.
 */
public class EchoService {

    /**
     * Lance le serveur "echo".
     *
     * Le serveur se connecte à un port libre dont il affiche la valeur.
     *
     * Tant qu'un client ne met pas fin au serveur en lui envoyant la phrase
     * secrète "Serveur ! Ferme toi."
     *
     * ____Le serveur attend la connexion d'un client.
     *
     * ____Une fois connecté,
     *
     * ________le client envoie des messages que le serveur renvoie au client en majuscule (c'est l'écho).
     *
     * ____Tant que ce client n'envoie pas "FIN" ni "Serveur ! Ferme toi." au serveur.
     *
     * Et le serveur affiche "Fin du service"
     *
     * @param args
     * @throws java.io.IOException
     */

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(0)) {
            System.out.println("Serveur démarré sur le port " + serverSocket.getLocalPort());
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connecté");
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Message reçu : " + message);
                        if (message.equals("FIN") || message.equals("Serveur ! Ferme toi.")) {
                            break;
                        }
                        out.println(message.toUpperCase());
                    }
                    System.out.println("Fin du service");
                }
            }
        }
        
    }
}
