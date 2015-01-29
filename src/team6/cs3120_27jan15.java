/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 * For liscense information see <http://www.gnu.org/licenses/>.
 */

package cs3120_27jan15;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cs3120_27jan15 {

    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Server GUI Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ServerTankObjectGUI test = new ServerTankObjectGUI();
        
        test.setOpaque(true); //content panes must be opaque
        frame.setContentPane(test);

        //Display the window.
        frame.pack();
        frame.setVisible(true);  
    }// end main
}//end main class

