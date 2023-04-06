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
package edu.uha.miage._05_serveur_echo_multithread;

import java.io.*;
import java.net.*;
import java.util.*;

import edu.uha.miage._05_echo_UDP.EchoService;

/**
 * Serveur ECHO qui admet les multiples connexions simultannées.
 */
public class EchoServiceMultiple {

    /**
     * Si vous avez écrit le serveur _01_serveur.EchoService en respectant sa
     * spécification vous avez peut-être remarqué qu'il ne peut servir deux
     * clients en même temps.
     *
     * Faites l'essai suivant pour vous en convaincre :
     *
     * Lancer le serveur
     *
     * Lancer un client et commencer à envoyer des messages (sans finir)
     *
     * Lancer un 2eme client et envoyer un message (il est bloqué, car le
     * serveur doit terminer avec le 1er client avant de servir le 2nd.
     *
     * Terminer le 1er client en saisissant "FIN"
     *
     * Vous pourrez voir que le dialogue avec le 2nd client commence.
     *
     * Le but de l'exercice est de faire que le serveur puisse servir plusieurs
     * clients (02_client_echo.EchoClient) en même temps.
     *
     * @param args
     * @throws IOException
     */
       
    public static void main(String[] args) throws IOException {
    // TODO 1.07
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new EchoService(socket)).start();
            }
        }
    }
}
