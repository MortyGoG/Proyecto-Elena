package src;

import src.data.*;
import src.gui.*;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){ 
        //Comprobamos Base de Datos
        BaseDatos instancia = new BaseDatos("src\\data\\producto.csv");
        instancia.CreateBD();

        //Iniciamos Ventana       
        SwingUtilities.invokeLater(() -> {
            new PantallaMenu();
        });


    }
}
