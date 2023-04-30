package src;

import src.data.*;
import src.gui.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import java.awt.CardLayout;

public class Main {
    public static void main(String[] args){ 
        //Comprobamos Base de Datos
        BaseDatos instancia = new BaseDatos();
        instancia.CreateBD();

        //Iniciamos Ventana       
        SwingUtilities.invokeLater(() -> {
            new PantallaMenu();
        });


    }
}
