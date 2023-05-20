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

public class PantallaAlertarCumpleaños implements ActionListener{

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonAlertarCumpleaños, botonMenu;
    private JFrame frameProductos;
    
    public PantallaAlertarCumpleaños() {

        /*------------------------------Estilo------------------------------*/
        //Tipografia
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);

        //Boton Registrar Productos
        botonAlertarCumpleaños = new JButton("Alertas pendientes");
        botonAlertarCumpleaños.setBorder(BorderFactory.createEmptyBorder());
        botonAlertarCumpleaños.setBackground(Color.BLACK);
        botonAlertarCumpleaños.setForeground(Color.WHITE);
        botonAlertarCumpleaños.setContentAreaFilled(false);
        botonAlertarCumpleaños.setFocusPainted(false);
        botonAlertarCumpleaños.setFont(sizedFont);
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

        /*------------------------------Paneles------------------------------*/

        //Panel y cardlayout para ventanas en la misma
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        panelPrincipal.setPreferredSize(new Dimension(1000, 600));
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        panelPrincipal.setOpaque(false);
        
        //Ventanas a mostrar en la misma por CardLayout
        PantallaAlertar ventana1 = new PantallaAlertar();
        ventana1.setOpaque(false);

        // Agregar las ventanas al panel principal
        panelPrincipal.add(ventana1, "ventana1");

        //Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelBotones.add(botonAlertarCumpleaños);
        panelBotones.setOpaque(false);

        //Panel Footer
        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new BorderLayout());
        JPanel rightAlignedPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        rightAlignedPanel.add(botonMenu);
        panelFooter.add(rightAlignedPanel, BorderLayout.SOUTH);
        rightAlignedPanel.setOpaque(false); 
        panelFooter.setOpaque(false); 

        //Panel Ventana
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false);
        panelVentana.revalidate();
        panelVentana.repaint();
        BoxLayout boxLayout = new BoxLayout(panelVentana , BoxLayout.Y_AXIS);
        panelVentana.setLayout(boxLayout);

        //Agregar Paneles al Panel Ventana
        panelVentana.add(Box.createVerticalStrut(35));
        panelVentana.add(panelBotones, BorderLayout.NORTH);
        panelVentana.add(Box.createVerticalStrut(30));
        panelVentana.add(panelPrincipal); 
        panelVentana.add(panelFooter);

        //Ventana Producto CRUD  
        frameProductos = new JFrame("Proyecto Elena v1.0");
        frameProductos.getContentPane().add(panelVentana);
        frameProductos.setPreferredSize(new Dimension(1500, 800));
        frameProductos.getContentPane().setBackground(Color.BLACK);
        ImageIcon icono = new ImageIcon("src\\gui\\icono.png");
        frameProductos.setIconImage(icono.getImage());
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
        if (e.getSource() == botonAlertarCumpleaños) {
            cardLayout.show(panelPrincipal, "ventana1");
            System.out.println("Mostrando ventana");
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
