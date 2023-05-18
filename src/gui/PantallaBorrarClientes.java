package src.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import src.control.BorrarClientes;
import src.control.MostrarClientes;

public class PantallaBorrarClientes extends JPanel implements ActionListener{
    private JButton botonComenzar, botonBorrar;
    private JLabel  labelNombreCliente;
    private JTextField  tfNombreCliente;
    private JPanel panelLabel0, panelLabel1, panelLabel2;
    private JTextArea labelBusqueda;
    private String texto;

    public PantallaBorrarClientes(){

        //Tipografia
        //Labels
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);
        //TextField
        Font fuente = new Font("Arial", Font.PLAIN, 20);  // Ejemplo: Arial, tamaño 20


        //Labels
        labelNombreCliente = new JLabel("Nombre cliente: ");
        labelNombreCliente.setForeground(Color.WHITE);
        labelNombreCliente.setFont(sizedFont);

        //Text Fields
        tfNombreCliente = new JTextField();
        tfNombreCliente.setPreferredSize(new Dimension(170, 25));
        tfNombreCliente.setFont(fuente);

        //Buttons
        botonComenzar = new JButton("Mostrar cliente");
        botonComenzar.addActionListener(this);
        botonBorrar = new JButton("Borrar Cliente");
        botonBorrar.addActionListener(this);


        //Panel Label 1 (Panel de Busqueda)
        panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(labelNombreCliente);
        panelLabel1.add(tfNombreCliente);
        panelLabel1.add(Box.createHorizontalStrut(20));
        panelLabel1.add(botonComenzar);
        panelLabel1.setOpaque(false);

        //Panel Label 2 (Panel de espaciado)
        JPanel panelLabel2 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(350, 50));
        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.Y_AXIS));
        panelLabel2.setOpaque(false);

        //Text Area Mostrar Cliente
        labelBusqueda = new JTextArea();
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
        panelLabel0.add(Box.createVerticalStrut(20));
        panelLabel0.add(botonBorrar);
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
        String nombreCliente = "";
        
    //Mostrar la coincidencia
        if (e.getSource() == botonComenzar) {
        //nombreCliente
        if(tfNombreCliente.getText().isEmpty() || tfNombreCliente.getText() == null){
            JOptionPane.showMessageDialog(null, "Coloca el nombre del cliente");
        } else {
            nombreCliente = tfNombreCliente.getText();//Obtenemos nombreCliente
            MostrarClientes MosClie = new MostrarClientes();  //CAMBIAR CUANDO SE HAGA LA CLASE RESPECTIVA <-----------------------------------MosClie = new MostrarClientes( //CAMBIAR CUANDO SE HAGA LA CLASE RESPECTIVA <-----------------------------------);
            texto = (MosClie.MostrarCliente(nombreCliente));
            labelBusqueda.setText(null);
            labelBusqueda.append(texto);
        }
        }
        if (e.getSource() == botonBorrar) {
            if(tfNombreCliente.getText().isEmpty() || tfNombreCliente.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el nombre del cliente");
            } else {
                nombreCliente = tfNombreCliente.getText();//Obtenemos nombreCliente
                BorrarClientes BorrClie = new BorrarClientes();
                BorrClie.BorrarCliente(nombreCliente);
                labelBusqueda.setText(null);
                texto = "";
            }
        }
    }
}
