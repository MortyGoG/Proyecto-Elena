package src.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
        //panel y cardlayout para ventanas en la misma
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

        //Boton Registrar Productos
        botonRegistrarProducto = new JButton("Registra un producto");
        //botonRegistrarProducto.setPreferredSize(new Dimension(200, 30));
        //botonRegistrarProducto.setBorder(BorderFactory.createEmptyBorder());
        //ImageIcon imgBoton1 = new ImageIcon("src\\gui\\boton1.png");
        //botonRegistrarProducto.setIcon(imgBoton1);
        botonRegistrarProducto.addActionListener(this);

        //Boton Modificar Productos
        botonModificarProducto = new JButton("Modifica un Productos");
        botonModificarProducto.addActionListener(this);

        //Boton Borrar Productos
        botonBorrarProducto = new JButton("Borrar un Producto");        
        botonBorrarProducto.addActionListener(this);

        //Boton Borrar Productos
        botonMostrarProducto = new JButton("Mostrar un Producto");        
        botonMostrarProducto.addActionListener(this);

        //Boton Salir
        botonMenu = new  JButton("Salir al Menu");
        botonMenu.addActionListener(this);

        //Panel Botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonRegistrarProducto);
        panelBotones.add(botonModificarProducto);
        panelBotones.add(botonBorrarProducto);
        panelBotones.add(botonMostrarProducto);
        panelBotones.setOpaque(false);

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
        // Agregar el panel de botones y el panel principal al frame
        ImageIcon imagenDeFondo = new ImageIcon("src\\gui\\fondo.jpg");
        // Crea el JLabel con el ImageIcon y establece su posición y tamaño
        JLabel fondo = new JLabel(imagenDeFondo);
        fondo.setBounds(0, 0, imagenDeFondo.getIconWidth(), imagenDeFondo.getIconHeight());
        // Agrega el JLabel al JPanel
        panelImagen.add(fondo);    

        //Agregar Paneles al Panel Ventana
        panelVentana.add(panelBotones, BorderLayout.NORTH);
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
        frameProductos.setPreferredSize(new Dimension(800, 800));
        frameProductos.pack();
        frameProductos.setResizable(true);
        frameProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProductos.setLocationRelativeTo(null);
        frameProductos.setVisible(true);
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
