package src.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PantallaProducto implements ActionListener{

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonRegistrarProducto, botonModificarProducto, botonBorrarProducto;
    private JFrame frameProductos;

    public PantallaProducto() {
        //panel y cardlayout para ventanas en la misma
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        //Ventanas a mostrar en la misma por CardLayout
        JPanel ventana0 = new JPanel();
        PantallaRegistrarProductos ventana1 = new PantallaRegistrarProductos();
        PantallaModificarProductos ventana2 = new PantallaModificarProductos();
        PantallaBorrarProductos ventana3 = new PantallaBorrarProductos();
        PantallaMostrarProductos ventana4 = new PantallaMostrarProductos();


        // Agregar las ventanas al panel principal
        panelPrincipal.add(ventana0, "ventana0");
        panelPrincipal.add(ventana1, "ventana1");
        panelPrincipal.add(ventana2, "ventana2");
        panelPrincipal.add(ventana3, "ventana3");
        panelPrincipal.add(ventana4, "ventana4");

        // Crear botones para cambiar entre las ventanas
        botonRegistrarProducto = new JButton("Registra un producto");
        botonModificarProducto = new JButton("Modifica un Productos");
        botonBorrarProducto = new JButton("Borrar un Producto");

        botonRegistrarProducto.addActionListener(this);
        botonModificarProducto.addActionListener(this);
        botonBorrarProducto.addActionListener(this);

        // Agregar los botones a un panel secundario (panelBotones)
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonRegistrarProducto);
        panelBotones.add(botonModificarProducto);
        panelBotones.add(botonBorrarProducto);      
        
        //Ventana Producto CRUD  
        frameProductos = new JFrame("Proyecto Elena v1.0");
        frameProductos.add(panelBotones, "North");
        frameProductos.getContentPane().add(panelPrincipal);
        frameProductos.setPreferredSize(new Dimension(800, 600));
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
        }
    }
    
}
