package src.gui;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class PantallaMenu implements ActionListener{

    private JButton botonPantallaProducto, botonPantallaCliente, botonUnknown, botonUnknown2;
    private JFrame frame;

    public PantallaMenu() {

        //BotonProductos
        botonPantallaProducto = new JButton();
        botonPantallaProducto = new JButton("Productos");
        botonPantallaProducto.setBorder(BorderFactory.createEmptyBorder());
        botonPantallaProducto.setBackground(Color.BLACK);
        botonPantallaProducto.setForeground(Color.WHITE);
        botonPantallaProducto.setContentAreaFilled(false);
        botonPantallaProducto.setFocusPainted(false);
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 30; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);
        botonPantallaProducto.setFont(sizedFont);
        botonPantallaProducto.addActionListener(this);
        botonPantallaProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonPantallaProducto.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonPantallaProducto.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        // botonPantallaProducto.setPreferredSize(new Dimension(250, 50));
        // botonPantallaProducto.setBorder(BorderFactory.createEmptyBorder());
        // ImageIcon imgBoton1 = new ImageIcon("src\\gui\\boton1.png");
        // ImageIcon hoverIcon = new ImageIcon("src\\gui\\boton1hover.png");
        // botonPantallaProducto.setIcon(imgBoton1);
        // botonPantallaProducto.setHorizontalTextPosition(JButton.CENTER);
        // botonPantallaProducto.setVerticalTextPosition(JButton.CENTER);
        // botonPantallaProducto.addActionListener(this);
        // botonPantallaProducto.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseEntered(MouseEvent e) {
        //         botonPantallaProducto.setIcon(hoverIcon); // Cambiar la imagen al pasar el mouse
        //     }

        //     @Override
        //     public void mouseExited(MouseEvent e) {
        //         botonPantallaProducto.setIcon(imgBoton1); // Restaurar la imagen normal al salir del mouse
        //     }
        // });

        //BotonClientes
        botonPantallaCliente = new JButton();
        botonPantallaCliente = new JButton("Clientes");
        botonPantallaCliente.setBorder(BorderFactory.createEmptyBorder());
        botonPantallaCliente.setBackground(Color.BLACK);
        botonPantallaCliente.setForeground(Color.WHITE);
        botonPantallaProducto.setContentAreaFilled(false);
        botonPantallaCliente.setFocusPainted(false);
        botonPantallaCliente.setFont(sizedFont);
        botonPantallaCliente.addActionListener(this);
        botonPantallaCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonPantallaCliente.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonPantallaCliente.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        // botonPantallaCliente.setPreferredSize(new Dimension(250, 50));
        // botonPantallaCliente.setBorder(BorderFactory.createEmptyBorder());
        // ImageIcon imgBoton2 = new ImageIcon("src\\gui\\boton2.png");
        // ImageIcon hoverIcon2 = new ImageIcon("src\\gui\\boton2hover.png");
        // botonPantallaCliente.setIcon(imgBoton2);
        // botonPantallaCliente.setHorizontalTextPosition(JButton.CENTER);
        // botonPantallaCliente.setVerticalTextPosition(JButton.CENTER);
        // botonPantallaCliente.addActionListener(this);
        // botonPantallaCliente.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseEntered(MouseEvent e) {
        //         botonPantallaCliente.setIcon(hoverIcon2); // Cambiar la imagen al pasar el mouse
        //     }

        //     @Override
        //     public void mouseExited(MouseEvent e) {
        //         botonPantallaCliente.setIcon(imgBoton2); // Restaurar la imagen normal al salir del mouse
        //     }
        // });

        //OtroBoton
        botonUnknown = new JButton();
        botonUnknown.setPreferredSize(new Dimension(250, 50));
        botonUnknown.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgBoton3 = new ImageIcon("src\\gui\\boton3.png");
        botonUnknown.setIcon(imgBoton3);
        botonUnknown.setHorizontalTextPosition(JButton.CENTER);
        botonUnknown.setVerticalTextPosition(JButton.CENTER);
        botonUnknown.addActionListener(this);

        //OtroBoton 2
        botonUnknown2 = new JButton();
        botonUnknown2.setPreferredSize(new Dimension(250, 50));
        botonUnknown2.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgBoton4 = new ImageIcon("src\\gui\\boton4.png");
        botonUnknown2.setIcon(imgBoton4);
        botonUnknown2.setHorizontalTextPosition(JButton.CENTER);
        botonUnknown2.setVerticalTextPosition(JButton.CENTER);
        botonUnknown2.addActionListener(this);

        //Panel Botones 1
        JPanel panelBoton = new JPanel(new BorderLayout());
        panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.X_AXIS));
        panelBoton.add(botonPantallaProducto);
        panelBoton.add(Box.createHorizontalStrut(70));
        panelBoton.add(botonPantallaCliente);
        panelBoton.setOpaque(false);

        //Panel Botones 2
        JPanel panelBoton2 = new JPanel(new BorderLayout());
        panelBoton2.setLayout(new BoxLayout(panelBoton2, BoxLayout.X_AXIS));
        panelBoton2.add(botonUnknown);
        panelBoton2.add(Box.createHorizontalStrut(70));
        panelBoton2.add(botonUnknown2);
        panelBoton2.setOpaque(false);


        //Panel Principal   
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        OverlayLayout layout = new OverlayLayout(panelPrincipal);
        panelPrincipal.setLayout(layout);
        panelPrincipal.setOpaque(false);


        //Panel Botones Verticales
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(panelBoton);
        panelBotones.add(panelBoton2);
        panelBotones.setOpaque(false);        

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
        panelPrincipal.add(panelBotones);
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
        if (e.getSource() == botonPantallaProducto) {
            frame.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaProducto();
            });
            
        }
    }
    
}
