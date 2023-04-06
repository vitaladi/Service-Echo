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
package edu.uha.miage._01_serveur_horaire;

import java.io.*;
import java.net.*;
import java.util.*;

/* TODO 1.01 Par composition avec la classe java.net.ServerSocket, écrire une classe
 * DayTimeService qui fournit l'heure et le jour à ses clients, sur un port
 * valide (par exemple 1313). */
// 
public class DayTimeService {

    private ServerSocket serverSocket;

    public DayTimeService(int port) throws IOException {
        serverSocket = new ServerSocket(1414);
    }

    public void run() throws IOException {
        while (true) {
            try (Socket socket = serverSocket.accept()) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("Connecté"+ new Date());
                out.println(new Date());
                out.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DayTimeService service = new DayTimeService(1414);
        service.run();
    }
}
