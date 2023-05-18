package src.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import src.control.ModificarClientes;
import src.control.ModificarProductos;

public class PantallaModificarClientes extends JPanel implements ActionListener {
    private JButton botonBusqueda, botonModificar;
    // Busqueda
    private JLabel labelNombreBusqueda;
    private JTextField tfNombreBusqueda;
    private JPanel panelLabel0, panelLabel1;
    private JTextArea labelBusqueda;
    private String texto;
    // Modificar
    private JPanel panelLabel3, panelLabel4;
    private JLabel labelNombreCliente, labelEmail, labelTelefono, labelFechaNacimiento,
            labelProductoComprado;
    private JTextField tfNombreCliente, tfEmail, tfTelefono,
            tfFechaNacimiento, tfProductoComprado;

    public PantallaModificarClientes() {
        // Tipografia
        // Labels
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 18; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);
        // TextField
        Font fuente = new Font("Arial", Font.PLAIN, 20); // Ejemplo: Arial, tamaño 20

        // Labels
        labelNombreBusqueda = new JLabel("Nombre: ");
        labelNombreBusqueda.setForeground(Color.WHITE);
        labelNombreBusqueda.setFont(sizedFont);

        // Text Fields
        tfNombreBusqueda = new JTextField();
        tfNombreBusqueda.setPreferredSize(new Dimension(170, 25));
        tfNombreBusqueda.setFont(fuente);

        // Buttons
        botonBusqueda = new JButton("Mostrar Cliente");
        botonBusqueda.addActionListener(this);

        // Panel Label 1 (Panel de Busqueda)
        panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(labelNombreBusqueda);
        panelLabel1.add(tfNombreBusqueda);
        panelLabel1.add(Box.createHorizontalStrut(10)); // espacio vertical
        panelLabel1.add(botonBusqueda);
        panelLabel1.setOpaque(false);

        // Panel Principal
        JPanel panelLabel0 = new JPanel(new BorderLayout());
        panelLabel0.setLayout(new BoxLayout(panelLabel0, BoxLayout.Y_AXIS));
        panelLabel0.add(panelLabel1);
        panelLabel0.add(Box.createVerticalStrut(30));
        panelLabel0.setOpaque(false);

        // Modificar
        // Panel para mostrar todo
        panelLabel3 = new JPanel(new BorderLayout());
        panelLabel3.setOpaque(false);

        panelLabel4 = new JPanel(new BorderLayout());
        panelLabel4.setPreferredSize(new Dimension(300, 25));
        panelLabel4.setOpaque(false);

        // Titulo
        JLabel label = new JLabel("                            Modificar Producto");
        label.setForeground(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 24); // Fuente con tamaño de 24 puntos y estilo negrita
        label.setFont(font);

        /*---------------------------------Estilo---------------------------------*/
        // Etiquetas de texto
        labelNombreCliente = new JLabel("Nombre Cliente: ");
        labelNombreCliente.setBorder(BorderFactory.createEmptyBorder());
        labelNombreCliente.setBackground(Color.BLACK);
        labelNombreCliente.setForeground(Color.WHITE);
        labelNombreCliente.setFont(sizedFont);

        labelEmail = new JLabel("Email: ");
        labelEmail.setBorder(BorderFactory.createEmptyBorder());
        labelEmail.setBackground(Color.BLACK);
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setFont(sizedFont);

        labelTelefono = new JLabel("Telefono: ");
        labelTelefono.setBorder(BorderFactory.createEmptyBorder());
        labelTelefono.setBackground(Color.BLACK);
        labelTelefono.setForeground(Color.WHITE);
        labelTelefono.setFont(sizedFont);

        labelFechaNacimiento = new JLabel("Fecha Nacimiento: ");
        labelFechaNacimiento.setBorder(BorderFactory.createEmptyBorder());
        labelFechaNacimiento.setBackground(Color.BLACK);
        labelFechaNacimiento.setForeground(Color.WHITE);
        labelFechaNacimiento.setFont(sizedFont);

        labelProductoComprado = new JLabel("Producto comprado: ");
        labelProductoComprado.setBorder(BorderFactory.createEmptyBorder());
        labelProductoComprado.setBackground(Color.BLACK);
        labelProductoComprado.setForeground(Color.WHITE);
        labelProductoComprado.setFont(sizedFont);

        botonModificar = new JButton("¡¡Registrar cliente!!");
        botonModificar.addActionListener(this);

        // Cajas de texto
        tfNombreCliente = new JTextField();
        tfNombreCliente.setPreferredSize(new java.awt.Dimension(150, 30));
        tfNombreCliente.setFont(fuente);

        tfEmail = new JTextField();
        tfEmail.setPreferredSize(new java.awt.Dimension(150, 30));
        tfEmail.setFont(fuente);

        tfTelefono = new JTextField();
        tfTelefono.setPreferredSize(new java.awt.Dimension(150, 30));
        tfTelefono.setFont(fuente);

        tfFechaNacimiento = new JTextField();
        tfFechaNacimiento.setPreferredSize(new java.awt.Dimension(150, 30));
        tfFechaNacimiento.setFont(fuente);

        tfProductoComprado = new JTextField();
        tfProductoComprado.setPreferredSize(new java.awt.Dimension(150, 30));
        tfProductoComprado.setFont(fuente);

        // Agregamos etiquetas y cajas de texto a un panel para centrarlo
        // Agregamos etiquetas y cajas de texto a un panel para centrarlo
        panelLabel3.setLayout(new BoxLayout(panelLabel3, BoxLayout.Y_AXIS));
        panelLabel3.add(labelNombreCliente);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(tfNombreCliente);
        panelLabel3.add(Box.createVerticalStrut(30));
        panelLabel3.add(labelEmail);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(tfEmail);
        panelLabel3.add(Box.createVerticalStrut(30));
        panelLabel3.add(labelTelefono);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(tfTelefono);
        panelLabel3.add(Box.createVerticalStrut(30));
        panelLabel3.add(labelFechaNacimiento);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(tfFechaNacimiento);
        panelLabel3.add(Box.createVerticalStrut(30));
        panelLabel3.add(labelProductoComprado);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(tfProductoComprado);
        panelLabel3.add(Box.createVerticalStrut(30));

        panelLabel4.setLayout(new BoxLayout(panelLabel4, BoxLayout.X_AXIS));
        panelLabel4.add(Box.createHorizontalStrut(100));
        panelLabel4.add(botonModificar);

        // Añadimos este label al otro label en PantallaProductos
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false);

        BoxLayout boxLayout = new BoxLayout(panelVentana, BoxLayout.Y_AXIS);
        panelVentana.setLayout(boxLayout);
        panelVentana.add(panelLabel0);
        panelVentana.add(panelLabel3);
        panelVentana.add(panelLabel4);

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
        if (e.getSource() == botonBusqueda) {
            if (tfNombreBusqueda.getText().isEmpty() || tfNombreBusqueda.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
            } else {
                String archivoCSV = "src\\data\\cliente.csv";
                String line = "";
                String cvsSplitBy = ",";
                String nombreBuscado;
                try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
                    nombreBuscado = tfNombreBusqueda.getText();
                    while ((line = br.readLine()) != null) {

                        String[] data = line.split(cvsSplitBy);
                        String nombreCliente = data[0]; // asumiendo que el codigo se encuentra en la primera columna

                        if (nombreCliente.equals(nombreBuscado)) {
                            // coincidencia encontrada mostrar el resto de datos de la misma fila
                            String email = data[1];
                            String telefono = data[2];
                            String fechaNacimiento = data[3];
                            String productoComprado = data[4];
                            tfNombreCliente.setText(nombreCliente);
                            tfEmail.setText(email);
                            tfTelefono.setText(telefono);
                            tfFechaNacimiento.setText(fechaNacimiento);
                            tfProductoComprado.setText(productoComprado);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "No encontrado");
                } catch (IOException a) {
                    a.printStackTrace();
                }
            }
        }
        // Atributos
        String nombreCliente = "";
        String nombreBuscado = "";
        String email = "";
        String telefono = "";
        String fechaNacimiento = "";
        String productoComprado = "";

        // Al colocar la info y registrar el cliente tenemos que comprobar la info
        if (e.getSource() == botonModificar) {
            // nombreCliente
            if (tfNombreCliente.getText().isEmpty() || tfNombreCliente.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el nombre del cliente");
            } else {
                nombreBuscado = tfNombreCliente.getText();// Obtenemos nombreCliente
            }

            // email
            if (tfEmail.getText().isEmpty() || tfEmail.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca la email del cliente");
            } else {
                email = tfEmail.getText();// Obtenemos email
            }

            // telefono
            if (tfTelefono.getText().isEmpty() || tfTelefono.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el telefono del cliente");
            } else {
                telefono = tfTelefono.getText();// Obtenemos telefono
            }

            // FechaNacimiento
            if (tfFechaNacimiento.getText().isEmpty() || tfFechaNacimiento.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca la fecha de nacimiento del cliente");
            } else {
                fechaNacimiento = tfFechaNacimiento.getText();// Obtenemos fecha de nacimiento
            }

            // ProductoComprado
            if (tfProductoComprado.getText().isEmpty() || tfProductoComprado.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el producto comprado");
            } else {
                productoComprado = tfProductoComprado.getText();// Obtenemos el producto comprado
            }

            // Codigo de Busqueda
            if (tfNombreBusqueda.getText().isEmpty() || tfNombreBusqueda.getText() == null) {
                JOptionPane.showMessageDialog(null, "Coloca el Nombre del cliente");
            } else {
                nombreCliente = tfNombreBusqueda.getText(); // Obtenemos beneficios
            }
            // Registra Producto si se llenaron los campos
            if (!tfNombreCliente.getText().isEmpty() && tfNombreCliente.getText() != null
                    && !tfEmail.getText().isEmpty()
                    && tfEmail.getText() != null && !tfTelefono.getText().isEmpty() && tfTelefono.getText() != null
                    && !tfFechaNacimiento.getText().isEmpty() && tfFechaNacimiento.getText() != null
                    && !tfProductoComprado.getText().isEmpty() && tfProductoComprado.getText() != null) {
                try {
                    ModificarClientes RegClie = new ModificarClientes();
                    RegClie.ModificarCliente(nombreBuscado, nombreCliente, email, telefono, fechaNacimiento,
                            productoComprado);
                    // Limpiamos
                    tfNombreCliente.setText("");
                    tfEmail.setText("");
                    tfTelefono.setText("");
                    tfFechaNacimiento.setText("");
                    tfProductoComprado.setText("");

                } catch (IOException e1) {
                    System.out.println("Eror en registrar el cliente");
                }
            }
        }
    }
}
