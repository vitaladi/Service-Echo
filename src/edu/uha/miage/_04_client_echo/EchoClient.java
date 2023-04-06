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
package edu.uha.miage._04_client_echo;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Client qui se connecte au serveur Echo pour répéter en echo les lignes
 * saisies au clavier tant que la ligne saisie n'est ni "FIN" ni "Serveur !
 * Fermet toi."
 */
public class EchoClient {

    /**
     * Demande à l'utilisateur d'entrer le numéro de port du serveur Echo.
     *
     * Le programme se connecte au serveur Echo (sur "localhost") à l'aide de ce
     * numéro de port.
     *
     * Une fois connecté :
     *
     * ____Le programme affiche à l'écran cette invite : "> " (sans saut de ligne)
     *
     * ____L'utilisateur saisit une ligne au clavier.
     *
     * ____Le programme envoie cette ligne au serveur.
     *
     * ____Le programme affiche la réponse du serveur
     *
     * Tant que l'utilisateur ne saisit pas "FIN" ni "Serveur ! Ferme toi."
     *
     * Et le programme affiche "Au revoir"
     *
     * @param args
     */
    public static void main(String[] args) {


        try (Scanner clavier = new Scanner(System.in)) {
            System.out.print("Numéro de port du serveur Echo : ");
            int port = clavier.nextInt();
            clavier.nextLine();
            try (Socket socket = new Socket("localhost", port)) {
                try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                        String line;
                        do {
                            System.out.print("> ");
                            line = clavier.nextLine();
                            out.println(line);
                            System.out.println(in.readLine());
                        } while (!line.equals("FIN") && !line.equals("Serveur ! Ferme toi."));
                    }
                }
            }
            System.out.println("Au revoir");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
