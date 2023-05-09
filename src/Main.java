package src;

import src.data.*;
import src.gui.*;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){ 
        //Comprobamos Base de Datos
        BaseDatosProductos instancia = new BaseDatosProductos("src\\data\\producto.csv");
        instancia.CreateBD();

        BaseDatosProductos instancia2 = new BaseDatosProductos("src\\data\\cliente.csv");
        instancia2.CreateBD();

        //Iniciamos Ventana       
        SwingUtilities.invokeLater(() -> {
            new PantallaMenu();
        });


    }
}
