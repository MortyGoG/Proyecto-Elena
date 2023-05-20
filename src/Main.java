package src;

import src.data.*;
import src.entity.*;
import src.gui.*;


import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){ 
        //Comprobamos Base de Datos
        Cliente instanciaCliente = new Cliente("src\\data\\cliente.csv");
        instanciaCliente.ValidarCliente();

        Producto instanciaProducto = new Producto("src\\data\\producto.csv");
        instanciaProducto.ValidarProducto();

        BaseDatosTestimonios instanciaTestimonio = new BaseDatosTestimonios("src\\data\\testimonio.csv");
        instanciaTestimonio.ValidarBD();

        //Iniciamos Ventana       
        SwingUtilities.invokeLater(() -> {
            new PantallaMenu();
        });


    }
}
