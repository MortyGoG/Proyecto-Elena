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

        //BotonProductos
        botonPantallaProducto = new JButton();
        botonPantallaProducto.setPreferredSize(new Dimension(200, 50));
        botonPantallaProducto.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgBoton1 = new ImageIcon("src\\gui\\boton1.png");
        botonPantallaProducto.setIcon(imgBoton1);
        botonPantallaProducto.setHorizontalTextPosition(JButton.CENTER);
        botonPantallaProducto.setVerticalTextPosition(JButton.CENTER);
        botonPantallaProducto.addActionListener(this);

        //BotonClientes
        botonPantallaCliente = new JButton();
        botonPantallaCliente.setPreferredSize(new Dimension(200, 50));
        botonPantallaCliente.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgBoton2 = new ImageIcon("src\\gui\\boton2.png");
        botonPantallaCliente.setIcon(imgBoton2);
        botonPantallaCliente.setHorizontalTextPosition(JButton.CENTER);
        botonPantallaCliente.setVerticalTextPosition(JButton.CENTER);
        botonPantallaCliente.addActionListener(this);

        //OtroBoton
        botonUnknown = new JButton();
        botonUnknown.setPreferredSize(new Dimension(200, 50));
        botonUnknown.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgBoton3 = new ImageIcon("src\\gui\\boton3.png");
        botonUnknown.setIcon(imgBoton3);
        botonUnknown.setHorizontalTextPosition(JButton.CENTER);
        botonUnknown.setVerticalTextPosition(JButton.CENTER);
        botonUnknown.addActionListener(this);

        //Panel Botones
        JPanel panelBoton = new JPanel();
        panelBoton.add(Box.createVerticalStrut(500));
        panelBoton.add(botonPantallaProducto);
        panelBoton.add(Box.createVerticalStrut(50));
        panelBoton.add(botonPantallaCliente);
        panelBoton.add(Box.createVerticalStrut(50));
        panelBoton.add(botonUnknown);
        panelBoton.setOpaque(false);

        //Panel Principal   
        JPanel panelPrincipal = new JPanel();
        OverlayLayout layout = new OverlayLayout(panelPrincipal);
        panelPrincipal.setLayout(layout);        


        //Panel Fondo
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        // Agregar el panel de botones y el panel principal al frame
        ImageIcon imagenDeFondo = new ImageIcon("src\\gui\\fondo.jpg");
        // Crea el JLabel con el ImageIcon y establece su posición y tamaño
        JLabel fondo = new JLabel(imagenDeFondo);
        fondo.setBounds(0, 0, imagenDeFondo.getIconWidth(), imagenDeFondo.getIconHeight());
        // Agrega el JLabel al JPanel
        panel.add(fondo);

        //Agregamos Paneles     
        panelPrincipal.add(panelBoton);   
        panelPrincipal.add(panel);
        
        //Creamos la Ventana        
        frame = new JFrame("Proyecto Elena v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.getContentPane().add(panelPrincipal);
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
