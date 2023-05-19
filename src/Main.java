package src;

import src.data.*;
import src.entity.*;
import src.gui.*;


import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){ 
        //Comprobamos Base de Datos
        Cliente instanciaCliente = new Cliente("src\\data\\cliente.csv");
        instanciaCliente.CreateBD();

        Producto instanciaProducto = new Producto("src\\data\\producto.csv");
        instanciaProducto.CreateBD();

        BaseDatosTestimonios instanciaTestimonio = new BaseDatosTestimonios("src\\data\\testimonio.csv");
        instanciaTestimonio.CreateBD();

        //Iniciamos Ventana       
        SwingUtilities.invokeLater(() -> {
            new PantallaMenu();
        });


    }
}
