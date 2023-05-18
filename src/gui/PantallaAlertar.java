package src.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import src.control.AlertarCumpleaños;
import src.control.MostrarClientes;

public class PantallaAlertar extends JPanel implements ActionListener{
    private JButton botonComenzar;
    private JLabel  labelnombre;
    private JTextField  tfNombre;
    private JPanel panelLabel0, panelLabel1, panelLabel2;
    private JTextArea labelBusqueda;
    private String texto;

    public PantallaAlertar(){

        //Tipografia
        //Labels
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);
        //TextField
        Font fuente = new Font("Arial", Font.PLAIN, 20);  // Ejemplo: Arial, tamaño 20

        //Buttons
        botonComenzar = new JButton("Mostrar Alertas");
        botonComenzar.addActionListener(this);

        //Panel Label 1 (Panel de Busqueda)
        panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(botonComenzar);
        panelLabel1.setOpaque(false);

        //Panel Label 2 (Panel de espaciado)
        JPanel panelLabel2 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(350, 50));
        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.Y_AXIS));
        panelLabel2.setOpaque(false);

        //Text Area Mostrar Producto
        labelBusqueda = new JTextArea();
        labelBusqueda.setFont(fuente);
        
        labelBusqueda.setEditable(false);
        labelBusqueda.setPreferredSize(new Dimension(250, 400));
        JScrollPane scrollPane = new JScrollPane(labelBusqueda); //Para deslizar
        Font font1 = labelBusqueda.getFont();
        float newSize1 = font1.getSize() + 10; // Aumentar el tamaño en 5 puntos
        labelBusqueda.setFont(font1.deriveFont(newSize1));

        //Panel Principal
        JPanel panelLabel0 = new JPanel(new BorderLayout());
        panelLabel0.setLayout(new BoxLayout(panelLabel0, BoxLayout.Y_AXIS));
        panelLabel0.add(panelLabel1);
        panelLabel0.add(panelLabel2);
        panelLabel0.add(scrollPane);
        panelLabel0.setOpaque(false);
        add(panelLabel0);//Agregamos el Panel
    }

    private static Font loadCustomFont(String path) {
        try {
            // Cargar la tipografía desde el archivo OTF
            File fontFile = new File(path);
            return Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            // En caso de error, devolver la fuente por defecto
            return new JButton().getFont();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //Mostrar la coincidencia
        if (e.getSource() == botonComenzar) {
                AlertarCumpleaños AlertCumple = new AlertarCumpleaños();
                texto = AlertCumple.AlertarCumpleaño();
                labelBusqueda.setText(null);
                labelBusqueda.append(texto);
        }
    }
}