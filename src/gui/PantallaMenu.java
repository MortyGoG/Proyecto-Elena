package src.gui;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PantallaMenu implements ActionListener{

    private JButton botonPantallaProducto, botonPantallaCliente, botonUnknown;
    private JFrame frame;

    public PantallaMenu() {
        //Botones del Menu
        botonPantallaProducto = new JButton("Operaciones con Productos");
        botonPantallaProducto.setPreferredSize(new Dimension(200, 50));
        botonPantallaCliente = new JButton("Operaciones con Clientes");
        botonPantallaCliente.setPreferredSize(new Dimension(200, 50));
        botonUnknown = new JButton("Otra Opcion");
        botonUnknown.setPreferredSize(new Dimension(200, 50));
        
        botonPantallaProducto.addActionListener(this);
        botonPantallaCliente.addActionListener(this);
        botonUnknown.addActionListener(this);

        //Agregamos los botones
        JPanel panelBoton = new JPanel();
        panelBoton.add(Box.createVerticalStrut(100));
        panelBoton.add(botonPantallaProducto);
        panelBoton.add(Box.createVerticalStrut(20));
        panelBoton.add(botonPantallaCliente);
        panelBoton.add(Box.createVerticalStrut(20));
        panelBoton.add(botonUnknown);

        //Ventana Menu    
        //frame.add(panelBoton, "Center");
        //a
        // Agregar el panel de botones y el panel principal al frame
        frame = new JFrame("Proyecto Elena v1.0");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(true);
        frame.getContentPane().add(panelBoton);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //Centrado de menu
        frame.getContentPane().add(panelBoton);
        
    }

    @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonPantallaProducto) {
            frame.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaProducto();
            });
            
        }
    }
    
}
