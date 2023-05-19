package src;

import src.data.*;
import src.gui.*;


import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){ 
        //Comprobamos Base de Datos
        BaseDatosProductos instancia1 = new BaseDatosProductos("src\\data\\producto.csv");
        instancia1.CreateBD();

        BaseDatosProductos instancia2 = new BaseDatosProductos("src\\data\\cliente.csv");
        instancia2.CreateBD();

        BaseDatosProductos instancia3 = new BaseDatosProductos("src\\data\\testimonio.csv");
        instancia3.CreateBD();

        //Iniciamos Ventana       
        SwingUtilities.invokeLater(() -> {
            new PantallaMenu();
        });


    }
}
