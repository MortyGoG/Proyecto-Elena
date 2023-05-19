package src.gui;

import javax.swing.*;
import src.control.RegistrarTestimonios;
import src.data.BaseDatosClientes;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;

public class PantallaRegistrarTestimonios extends JPanel implements ActionListener {
    private JButton botonRegistrar;
    private JLabel labelNombreCliente, labelFecha, labelComentario, labelProductoServicio;
    private JTextField tfNombreCliente, tfFecha, tfComentario, tfProductoServicio;

    public BaseDatosClientes instanciaa;

    public PantallaRegistrarTestimonios() {

        // Panel para mostrar todo
        JPanel panelLabel = new JPanel(new BorderLayout());
        JPanel panelLabel2 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(300, 50));
        System.out.println("Mostrando RegisCliente");
        panelLabel.setOpaque(false);
        panelLabel2.setOpaque(false);

        /*---------------------------------Estilo---------------------------------*/
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);

        // Etiquetas de texto
        labelNombreCliente = new JLabel("Nombre cliente: ");
        labelNombreCliente.setBorder(BorderFactory.createEmptyBorder());
        labelNombreCliente.setBackground(Color.BLACK);
        labelNombreCliente.setForeground(Color.WHITE);
        labelNombreCliente.setFont(sizedFont);

        labelFecha = new JLabel("Fecha: ");
        labelFecha.setBorder(BorderFactory.createEmptyBorder());
        labelFecha.setBackground(Color.BLACK);
        labelFecha.setForeground(Color.WHITE);
        labelFecha.setFont(sizedFont);

        labelProductoServicio = new JLabel("Producto o Servicio: ");
        labelProductoServicio.setBorder(BorderFactory.createEmptyBorder());
        labelProductoServicio.setBackground(Color.BLACK);
        labelProductoServicio.setForeground(Color.WHITE);
        labelProductoServicio.setFont(sizedFont);

        labelComentario = new JLabel("Comentario: ");
        labelComentario.setBorder(BorderFactory.createEmptyBorder());
        labelComentario.setBackground(Color.BLACK);
        labelComentario.setForeground(Color.WHITE);
        labelComentario.setFont(sizedFont);

        botonRegistrar = new JButton("¡¡Registrar Testimonio!!");
        botonRegistrar.addActionListener(this);

        // Cajas de texto
        Font fuente = new Font("Arial", Font.PLAIN, 20); // Ejemplo: Arial, tamaño 20
        tfNombreCliente = new JTextField();
        tfNombreCliente.setPreferredSize(new java.awt.Dimension(150, 30));
        tfNombreCliente.setFont(fuente);

        tfFecha = new JTextField();
        tfFecha.setPreferredSize(new java.awt.Dimension(150, 30));
        tfFecha.setFont(fuente);

        tfProductoServicio = new JTextField();
        tfProductoServicio.setPreferredSize(new java.awt.Dimension(150, 30));
        tfProductoServicio.setFont(fuente);

        tfComentario = new JTextField();
        tfComentario.setPreferredSize(new java.awt.Dimension(150, 30));
        tfComentario.setFont(fuente);

        // Agregamos etiquetas y cajas de texto a un panel para centrarlo
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
        panelLabel.add(labelNombreCliente);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfNombreCliente);
        panelLabel.add(Box.createVerticalStrut(30));
        panelLabel.add(labelFecha);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfFecha);
        panelLabel.add(Box.createVerticalStrut(30));
        panelLabel.add(labelProductoServicio);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfProductoServicio);
        panelLabel.add(Box.createVerticalStrut(30));
        panelLabel.add(labelComentario);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfComentario);
        panelLabel.add(Box.createVerticalStrut(30));

        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.X_AXIS));
        panelLabel2.add(Box.createHorizontalStrut(100));
        panelLabel2.add(botonRegistrar);

        // Añadimos este label al otro label en PantallaProductos
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false);

        BoxLayout boxLayout = new BoxLayout(panelVentana, BoxLayout.Y_AXIS);
        panelVentana.setLayout(boxLayout);
        panelVentana.add(panelLabel);
        panelVentana.add(panelLabel2);
        add(panelVentana);
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
        // Atributos
        String nombreCliente = "";
        String fecha = "";
        String productoServicio = "";
        String comentario = "";

        // Al colocar la info y registrar el cliente tenemos que comprobar la info
        if (e.getSource() == botonRegistrar) {
            // nombreCliente
            if (tfNombreCliente.getText().isEmpty() || tfNombreCliente.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el nombre del cliente");
            } else {
                nombreCliente = tfNombreCliente.getText();// Obtenemos nombreCliente
            }

            // Fecha
            if (tfFecha.getText().isEmpty() || tfFecha.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca la fecha de nacimiento del cliente");
            } else {
                fecha = tfFecha.getText();// Obtenemos fecha de nacimiento
            }

            // Producto/Servicio
            if (tfProductoServicio.getText().isEmpty() || tfProductoServicio.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el producto comprado");
            } else {
                productoServicio = tfProductoServicio.getText();// Obtenemos el producto comprado
            }

            // Comentario
            if (tfComentario.getText().isEmpty() || tfComentario.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca la fecha del cliente");
            } else {
                comentario = tfComentario.getText();// Obtenemos fecha
            }

            // Registra Producto si se llenaron los campos
            if (!tfNombreCliente.getText().isEmpty() && tfNombreCliente.getText() != null
                    && !tfComentario.getText().isEmpty() && tfComentario.getText() != null
                    && !tfFecha.getText().isEmpty() && tfFecha.getText() != null
                    && !tfProductoServicio.getText().isEmpty() && tfProductoServicio.getText() != null) {
                try {
                    RegistrarTestimonios RegClie = new RegistrarTestimonios();
                    RegClie.RegistrarTestimonio(nombreCliente, fecha, productoServicio, comentario);
                    // Limpiamos
                    tfNombreCliente.setText("");
                    tfFecha.setText("");
                    tfProductoServicio.setText("");
                    tfComentario.setText("");

                } catch (IOException e1) {
                    System.out.println("Eror en registrar el cliente");
                }
            }
        }
    }
}