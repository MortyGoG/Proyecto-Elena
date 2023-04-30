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
        // Agregar el panel de botones y el panel principal al frame
        frame = new JFrame("Proyecto Elena v1.0");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(true);

        //Botones del Menu
        botonPantallaProducto = new JButton("Operaciones con Productos");
        botonPantallaCliente = new JButton("Operaciones con Clientes");
        botonUnknown = new JButton("Otra Opcion");
        
        botonPantallaProducto.addActionListener(this);
        botonPantallaCliente.addActionListener(this);
        botonUnknown.addActionListener(this);

        //Agregamos los botones
        JPanel panelBoton = new JPanel();
        panelBoton.add(botonPantallaProducto);
        panelBoton.add(botonPantallaCliente);
        panelBoton.add(botonUnknown);

        //Centrado de menu
        /*
        OverlayLayout overlay = new OverlayLayout(frame.getContentPane());
        frame.getContentPane().setLayout(overlay);
        frame.getContentPane().add(panelBoton);
        frame.getContentPane().add(espaciado);
        espaciado.setAlignmentX(Component.CENTER_ALIGNMENT);
        espaciado.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBoton.setPreferredSize(new Dimension(300, 300));
        espaciado.setPreferredSize(new Dimension(200, 200));
        */ 

        //Ventana Menu    
        frame.add(panelBoton, "Center");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
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
