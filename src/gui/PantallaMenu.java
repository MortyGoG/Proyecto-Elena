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

    private JButton botonPantallaProducto, botonPantallaCliente, botonTestimonio, botonAlertarCumpleaños;
    private JFrame frame;

    public PantallaMenu() {

        //Estilo Botones 1
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 30; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);
        //BotonProductos
        botonPantallaProducto = new JButton("Productos");
        botonPantallaProducto.setBorder(BorderFactory.createEmptyBorder());
        botonPantallaProducto.setBackground(Color.BLACK);
        botonPantallaProducto.setForeground(Color.WHITE);
        botonPantallaProducto.setContentAreaFilled(false);
        botonPantallaProducto.setFocusPainted(false);
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

        //BotonClientes
        botonPantallaCliente = new JButton("Clientes");
        botonPantallaCliente.setBorder(BorderFactory.createEmptyBorder());
        botonPantallaCliente.setBackground(Color.BLACK);
        botonPantallaCliente.setForeground(Color.WHITE);
        botonPantallaCliente.setContentAreaFilled(false);
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

        //Estilo Botones 2
        Font customFont2 = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize2 = 20; // Tamaño de la letra deseado
        Font sizedFont2 = customFont2.deriveFont(fontSize2);

        //botonTestimonio
        botonTestimonio = new JButton("Generar Testimonio");
        botonTestimonio.setBorder(BorderFactory.createEmptyBorder());
        botonTestimonio.setBackground(Color.BLACK);
        botonTestimonio.setForeground(Color.WHITE);
        botonTestimonio.setContentAreaFilled(false);
        botonTestimonio.setFocusPainted(false);
        botonTestimonio.setFont(sizedFont2);
        botonTestimonio.addActionListener(this);
        botonTestimonio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonTestimonio.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonTestimonio.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        //Productos terminados
        botonAlertarCumpleaños = new JButton("Alertar cumpleaños");
        botonAlertarCumpleaños.setBorder(BorderFactory.createEmptyBorder());
        botonAlertarCumpleaños.setBackground(Color.BLACK);
        botonAlertarCumpleaños.setForeground(Color.WHITE);
        botonAlertarCumpleaños.setContentAreaFilled(false);
        botonAlertarCumpleaños.setFocusPainted(false);
        botonAlertarCumpleaños.setFont(sizedFont2);
        botonAlertarCumpleaños.addActionListener(this);
        botonAlertarCumpleaños.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonAlertarCumpleaños.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonAlertarCumpleaños.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

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
        panelBoton2.add(botonTestimonio);
        panelBoton2.add(Box.createHorizontalStrut(70));
        panelBoton2.add(botonAlertarCumpleaños);
        panelBoton2.setOpaque(false);


        //Panel Botones Verticales
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(panelBoton);
        panelBotones.add(panelBoton2);
        panelBotones.setOpaque(false);
        
        //Creamos la Ventana        
        frame = new JFrame("Proyecto Elena v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));
        frame.getContentPane().setBackground(Color.BLACK);
        ImageIcon icono = new ImageIcon("src\\gui\\icono.png");
        frame.setIconImage(icono.getImage());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.getContentPane().add(panelBotones);
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
        if (e.getSource() == botonPantallaCliente) {
            frame.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaCliente();
            });
            
        }
        if (e.getSource() == botonTestimonio) {
            frame.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaGenerarTestimonioClientes();
            });
            
        }
        if (e.getSource() == botonAlertarCumpleaños) {
            frame.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaAlertarCumpleaños();
            });
            
        }
    }
    
}
