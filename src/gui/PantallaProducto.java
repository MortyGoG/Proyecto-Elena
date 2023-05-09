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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;

public class PantallaProducto implements ActionListener{

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonRegistrarProducto, botonModificarProducto, botonBorrarProducto, botonMenu, botonMostrarProducto;
    private JFrame frameProductos;
    
    public PantallaProducto() {

        //Panel y cardlayout para ventanas en la misma
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        panelPrincipal.setOpaque(false);
        

        //Ventanas a mostrar en la misma por CardLayout
        JPanel ventana0 = new JPanel();
        ventana0.setOpaque(false);
        PantallaRegistrarProductos ventana1 = new PantallaRegistrarProductos();
        ventana1.setOpaque(false);
        PantallaModificarProductos ventana2 = new PantallaModificarProductos();
        ventana2.setOpaque(false);
        PantallaBorrarProductos ventana3 = new PantallaBorrarProductos();
        ventana3.setOpaque(false);
        PantallaMostrarProductos ventana4 = new PantallaMostrarProductos();
        ventana4.setOpaque(false);



        // Agregar las ventanas al panel principal
        panelPrincipal.add(ventana0, "ventana0");
        panelPrincipal.add(ventana1, "ventana1");
        panelPrincipal.add(ventana2, "ventana2");
        panelPrincipal.add(ventana3, "ventana3");
        panelPrincipal.add(ventana4, "ventana4");


        /*------------------------------Estilo------------------------------*/
        //Tipografia
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);

        //Boton Registrar Productos
        botonRegistrarProducto = new JButton("Registra un producto");
        botonRegistrarProducto.setBorder(BorderFactory.createEmptyBorder());
        botonRegistrarProducto.setBackground(Color.BLACK);
        botonRegistrarProducto.setForeground(Color.WHITE);
        botonRegistrarProducto.setContentAreaFilled(false);
        botonRegistrarProducto.setFocusPainted(false);
        botonRegistrarProducto.setFont(sizedFont);
        botonRegistrarProducto.addActionListener(this);
        botonRegistrarProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonRegistrarProducto.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonRegistrarProducto.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        //Boton Modificar Productos
        botonModificarProducto = new JButton("Modifica un Productos");
        botonModificarProducto.setBorder(BorderFactory.createEmptyBorder());
        botonModificarProducto.setBackground(Color.BLACK);
        botonModificarProducto.setForeground(Color.WHITE);
        botonModificarProducto.setContentAreaFilled(false);
        botonModificarProducto.setFocusPainted(false);
        botonModificarProducto.setFont(sizedFont);
        botonModificarProducto.addActionListener(this);
        botonModificarProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonModificarProducto.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonModificarProducto.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        //Boton Borrar Productos
        botonBorrarProducto = new JButton("Borrar un Producto");   
        botonBorrarProducto.setBorder(BorderFactory.createEmptyBorder());
        botonBorrarProducto.setBackground(Color.BLACK);
        botonBorrarProducto.setForeground(Color.WHITE);
        botonBorrarProducto.setContentAreaFilled(false);
        botonBorrarProducto.setFocusPainted(false);
        botonBorrarProducto.setFont(sizedFont);
        botonBorrarProducto.addActionListener(this);
        botonBorrarProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonBorrarProducto.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonBorrarProducto.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        //Boton Borrar Productos
        botonMostrarProducto = new JButton("Mostrar un Producto");   
        botonMostrarProducto.setBorder(BorderFactory.createEmptyBorder());
        botonMostrarProducto.setBackground(Color.BLACK);
        botonMostrarProducto.setForeground(Color.WHITE);
        botonMostrarProducto.setContentAreaFilled(false);
        botonMostrarProducto.setFocusPainted(false);
        botonMostrarProducto.setFont(sizedFont);
        botonMostrarProducto.addActionListener(this);
        botonMostrarProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonMostrarProducto.setForeground(Color.YELLOW); // Cambiar la imagen al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonMostrarProducto.setForeground(Color.WHITE); // Restaurar la imagen normal al salir del mouse
            }
        });

        //Boton Salir
        botonMenu = new  JButton("Salir al Menu");
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

        //Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.add(botonRegistrarProducto);
        panelBotones.add(Box.createHorizontalStrut(35));
        panelBotones.add(botonModificarProducto);
        panelBotones.add(Box.createHorizontalStrut(35));
        panelBotones.add(botonBorrarProducto);
        panelBotones.add(Box.createHorizontalStrut(35));
        panelBotones.add(botonMostrarProducto);
        panelBotones.setOpaque(false);

        /*------------------------------Paneles------------------------------*/
        //Panel Footer
        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BorderLayout());
        JPanel rightAlignedPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        rightAlignedPanel.add(botonMenu);
        panelFooter.add(rightAlignedPanel, BorderLayout.SOUTH);
        rightAlignedPanel.setOpaque(false); 
        panelFooter.setOpaque(false); 

        //Panel Fondo
        JPanel panelFondo = new JPanel();
        OverlayLayout layout = new OverlayLayout(panelFondo);
        panelFondo.setLayout(layout);
        panelFondo.setOpaque(false);

        //Panel Ventana
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false); 
        BoxLayout boxLayout = new BoxLayout(panelVentana , BoxLayout.Y_AXIS);
        panelVentana.setLayout(boxLayout);
               
        //Panel Fondo
        JPanel panelImagen = new JPanel();
        panelImagen.setOpaque(true);
        ImageIcon imagenDeFondo = new ImageIcon("src\\gui\\fondo.jpg"); //Colocamos la imagen de fondo
        JLabel fondo = new JLabel(imagenDeFondo); // Crea el JLabel con el ImageIcon y establece su posición y tamaño
        fondo.setBounds(0, 0, imagenDeFondo.getIconWidth(), imagenDeFondo.getIconHeight());
        panelImagen.add(fondo); // Agrega el JLabel al JPanel

        //Agregar Paneles al Panel Ventana
        panelVentana.add(Box.createVerticalStrut(35));
        panelVentana.add(panelBotones, BorderLayout.NORTH);
        panelVentana.add(Box.createVerticalStrut(30));
        panelVentana.add(panelPrincipal);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); 
        panelVentana.add(panelFooter, BorderLayout.SOUTH);

        //Agregamos todo a panelFondo
        panelFondo.add(panelVentana);
        panelFondo.add(panelImagen);

        //Mover Panel Botones
        // panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT);
        // panelBotones.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        // //Mover Panel Inferior
        // footerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // footerPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        // //Mover Panel Principal
        // panelPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);
        // panelPrincipal.setAlignmentY(Component.TOP_ALIGNMENT);

        //Ventana Producto CRUD  
        frameProductos = new JFrame("Proyecto Elena v1.0");
        // frameProductos.add(panelBotonesOL, "North");
        // frameProductos.add(panelFoterPanelOL, BorderLayout.SOUTH);
        // frameProductos.getContentPane().add(panelPrinciOL);
        frameProductos.getContentPane().add(panelFondo);
        frameProductos.setPreferredSize(new Dimension(1920, 1000));
        frameProductos.pack();
        frameProductos.setResizable(true);
        frameProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProductos.setLocationRelativeTo(null);
        frameProductos.setVisible(true);
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

        //Eventos de los botones para cambiar de ventana
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrarProducto) {
            cardLayout.show(panelPrincipal, "ventana1");
            System.out.println("Mostrando ventana");
        } else if (e.getSource() == botonModificarProducto) {
            cardLayout.show(panelPrincipal, "ventana2");
        } else if (e.getSource() == botonBorrarProducto) {
            cardLayout.show(panelPrincipal, "ventana3");
        } else if (e.getSource() == botonMostrarProducto) {
            cardLayout.show(panelPrincipal, "ventana4");
        } else if (e.getSource() == botonMenu) {
            System.out.println("Cerrando Ventana");
            frameProductos.dispose();
            SwingUtilities.invokeLater(() -> {
                new PantallaMenu();
            });
            System.out.println("Ventana cerrada");
            
        }
    }
    
}
