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
package edu.uha.miage._02_client_horaire;

/**
 * Par extension de la classe javax.swing.JLabel et à l'aide des threads,
 * développer une classe DayTimeClient capable d'afficher le jour et l’heure en
 * lançant des requêtes au serveur DayTimeService.
 *
 * @author Yvan Maillot <yvan.maillot@uha.fr>
 */
public class DayTimeClient extends javax.swing.JLabel {

    private static final long serialVersionUID = 1L;

	public DayTimeClient() {
    // TODO 1.02
        try {
            java.net.Socket socket = new java.net.Socket("localhost", 12345);
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
            String line = in.readLine();
            this.setText(line);
            socket.close();
        } catch (java.io.IOException ex) {
            this.setText("Error: " + ex.getMessage());
        }
    
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.getContentPane().add(new DayTimeClient());
        frame.pack();
        frame.setVisible(true);

       
    }
}
