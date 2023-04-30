package src.gui;

import javax.swing.*;
import java.awt.*;


public class PantallaRegistrarProductos extends JPanel{
    private JButton botonComenzar;
    private JLabel  labelCodigo, labelDescripcion, labelPrecio, labelPromocion,
                    labelPreciopromocion, labelFechaInicioPromocion, labelFechaTerminoPromocion, labelBeneficios;
    private JTextField  tfCodigo, tfDescripcion, tfPrecio, tfPromocion,
                    tfPreciopromocion, tfFechaInicioPromocion, tfFechaTerminoPromocion, tfBeneficios;
    
    public PantallaRegistrarProductos(){
        JPanel panelLabel = new JPanel(new BorderLayout());
        System.out.println("Mostrando RegisProdus");

        //TEXTO
        labelCodigo = new JLabel("Codigo: ");
        labelDescripcion = new JLabel("Descripcion: ");
        labelPrecio = new JLabel("Precio: ");
        labelPromocion = new JLabel("Promocion: ");
        labelPreciopromocion = new JLabel("Precio por Promocion: ");
        labelFechaInicioPromocion = new JLabel("Fecha de Inicio de Promocion: ");
        labelFechaTerminoPromocion = new JLabel("Fecha de Terminacion de Promocion");
        labelBeneficios = new JLabel("Beneficios: ");
        botonComenzar = new JButton("¡¡Registrar Producto!!");
        
        //CAJAS DE TEXTO
        tfCodigo = new JTextField();
        tfDescripcion = new JTextField();
        tfPrecio = new JTextField();
        tfPromocion = new JTextField();
        tfPreciopromocion = new JTextField();
        tfFechaInicioPromocion = new JTextField();
        tfFechaTerminoPromocion = new JTextField();
        tfBeneficios = new JTextField();


        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
        panelLabel.add(labelCodigo);
        panelLabel.add(tfCodigo);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelDescripcion);
        panelLabel.add(tfDescripcion);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelPrecio);
        panelLabel.add(tfPrecio);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelPromocion);
        panelLabel.add(tfPromocion);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelPreciopromocion);
        panelLabel.add(tfPreciopromocion);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelFechaInicioPromocion);
        panelLabel.add(labelFechaInicioPromocion);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelFechaTerminoPromocion);
        panelLabel.add(tfFechaTerminoPromocion);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelBeneficios);
        panelLabel.add(tfBeneficios);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(botonComenzar);


        add(panelLabel);




    }

}