package src.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PantallaCliente implements ActionListener {

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonRegistrarCliente, botonModificarCliente, botonBorrarCliente, botonMenu, botonMostrarCliente;
    private JFrame frameClientes;

    public PantallaCliente() {

        /*------------------------------Estilo------------------------------*/
        // Tipografia
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);

        // Boton Registrar clientes
        botonRegistrarCliente = new JButton("Registra un cliente");
        botonRegistrarCliente.setBorder(BorderFactory.createEmptyBorder());
        botonRegistrarCliente.setBackground(Color.BLACK);
        botonRegistrarCliente.setForeground(Color.WHITE);
        botonRegistrarCliente.setContentAreaFilled(false);
        botonRegistrarCliente.setFocusPainted(false);
        botonRegistrarCliente.setFont(sizedFont);
        botonRegistrarCliente.addActionListener(this);
        botonRegistrarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonRegistrarCliente.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonRegistrarCliente.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        // Boton Modificar Cliente
        botonModificarCliente = new JButton("Modifica un cliente");
        botonModificarCliente.setBorder(BorderFactory.createEmptyBorder());
        botonModificarCliente.setBackground(Color.BLACK);
        botonModificarCliente.setForeground(Color.WHITE);
        botonModificarCliente.setContentAreaFilled(false);
        botonModificarCliente.setFocusPainted(false);
        botonModificarCliente.setFont(sizedFont);
        botonModificarCliente.addActionListener(this);
        botonModificarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonModificarCliente.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonModificarCliente.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        // Boton Borrar clientes
        botonBorrarCliente = new JButton("Borrar un Cliente");
        botonBorrarCliente.setBorder(BorderFactory.createEmptyBorder());
        botonBorrarCliente.setBackground(Color.BLACK);
        botonBorrarCliente.setForeground(Color.WHITE);
        botonBorrarCliente.setContentAreaFilled(false);
        botonBorrarCliente.setFocusPainted(false);
        botonBorrarCliente.setFont(sizedFont);
        botonBorrarCliente.addActionListener(this);
        botonBorrarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonBorrarCliente.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonBorrarCliente.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        // Boton Mostrar clientes
        botonMostrarCliente = new JButton("Mostrar un Cliente");
        botonMostrarCliente.setBorder(BorderFactory.createEmptyBorder());
        botonMostrarCliente.setBackground(Color.BLACK);
        botonMostrarCliente.setForeground(Color.WHITE);
        botonMostrarCliente.setContentAreaFilled(false);
        botonMostrarCliente.setFocusPainted(false);
        botonMostrarCliente.setFont(sizedFont);
        botonMostrarCliente.addActionListener(this);
        botonMostrarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonMostrarCliente.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonMostrarCliente.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        // Boton Salir
        botonMenu = new JButton("Salir al Menu");
        botonMenu.setBorder(BorderFactory.createEmptyBorder());
        botonMenu.setBackground(Color.BLACK);
        botonMenu.setForeground(Color.WHITE);
        botonMenu.setContentAreaFilled(false);
        botonMenu.setFocusPainted(false);
        Font customFontMenu = loadCustomFont("src\\gui\\undertale.otf");
        float fontSizeMenu = 18; // Tamaño de la letra deseado
        Font sizedFontMenu = customFontMenu.deriveFont(fontSizeMenu);
        botonMenu.setFont(sizedFontMenu);
        botonMenu.addActionListener(this);
        botonMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonMenu.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonMenu.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        /*------------------------------Paneles------------------------------*/

        // Panel y cardlayout para ventanas en la misma
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        panelPrincipal.setPreferredSize(new Dimension(1000, 600));
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        panelPrincipal.setOpaque(false);

        // Ventanas a mostrar en la misma por CardLayout
        JPanel ventana0 = new JPanel();
        ventana0.setOpaque(false);
        ventana0.setPreferredSize(new Dimension(1000, 600));
        ventana0.revalidate();
        ventana0.repaint();
        ventana0.setOpaque(false);
        PantallaRegistrarClientes ventana1 = new PantallaRegistrarClientes();
        ventana1.setOpaque(false);
        PantallaModificarClientes ventana2 = new PantallaModificarClientes();
        ventana2.setOpaque(false);
        PantallaBorrarClientes ventana3 = new PantallaBorrarClientes();
        ventana3.setOpaque(false);
        PantallaMostrarClientes ventana4 = new PantallaMostrarClientes();
        ventana4.setOpaque(false);

        // Agregar las ventanas al panel principal
        panelPrincipal.add(ventana0, "ventana0");
        panelPrincipal.add(ventana1, "ventana1");
        panelPrincipal.add(ventana2, "ventana2");
        panelPrincipal.add(ventana3, "ventana3");
        panelPrincipal.add(ventana4, "ventana4");

        // Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.add(botonRegistrarCliente);
        panelBotones.add(Box.createHorizontalStrut(35));
        panelBotones.add(botonModificarCliente);
        panelBotones.add(Box.createHorizontalStrut(35));
        panelBotones.add(botonBorrarCliente);
        panelBotones.add(Box.createHorizontalStrut(35));
        panelBotones.add(botonMostrarCliente);
        panelBotones.setOpaque(false);

        // Panel Footer
        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BorderLayout());
        JPanel rightAlignedPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        rightAlignedPanel.add(botonMenu);
        panelFooter.add(rightAlignedPanel, BorderLayout.SOUTH);
        rightAlignedPanel.setOpaque(false);
        panelFooter.setOpaque(false);

        // Panel Ventana
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false);
        panelVentana.revalidate();
        panelVentana.repaint();
        BoxLayout boxLayout = new BoxLayout(panelVentana, BoxLayout.Y_AXIS);
        panelVentana.setLayout(boxLayout);

        // Agregar Paneles al Panel Ventana
        panelVentana.add(Box.createVerticalStrut(35));
        panelVentana.add(panelBotones, BorderLayout.NORTH);
        panelVentana.add(Box.createVerticalStrut(30));
        panelVentana.add(panelPrincipal);
        panelVentana.add(panelFooter);

        // Ventana Producto CRUD
        frameClientes = new JFrame("Proyecto Elena v1.0");
        frameClientes.getContentPane().add(panelVentana);
        frameClientes.setPreferredSize(new Dimension(1500, 800));
        frameClientes.getContentPane().setBackground(Color.BLACK);
        ImageIcon icono = new ImageIcon("src\\gui\\icono.png");
        frameClientes.setIconImage(icono.getImage());
        frameClientes.pack();
        frameClientes.setResizable(true);
        frameClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameClientes.setLocationRelativeTo(null);
        frameClientes.setVisible(true);
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

    // Eventos de los botones para cambiar de ventana
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrarCliente) {
            cardLayout.show(panelPrincipal, "ventana1");
            System.out.println("Mostrando ventana");
        } else if (e.getSource() == botonModificarCliente) {
            cardLayout.show(panelPrincipal, "ventana2");
        } else if (e.getSource() == botonBorrarCliente) {
            cardLayout.show(panelPrincipal, "ventana3");
        } else if (e.getSource() == botonMostrarCliente) {
            cardLayout.show(panelPrincipal, "ventana4");
        } else if (e.getSource() == botonMenu) {
            System.out.println("Cerrando Ventana");
            frameClientes.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaMenu();
            });
            System.out.println("Ventana cerrada");

        }
    }

}
