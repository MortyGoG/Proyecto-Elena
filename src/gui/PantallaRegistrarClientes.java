package src.gui;

import javax.swing.*;
import src.control.RegistrarClientes;
import src.data.BaseDatosClientes;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;


public class PantallaRegistrarClientes extends JPanel implements ActionListener{
    private JButton botonComenzar;
    private JLabel  labelNombreCliente, labelEmail, labelTelefono, labelFechaNacimiento,
                    labelProductoComprado;
    private JTextField  tfNombreCliente, tfEmail, tfTelefono, 
                    tfFechaNacimiento, tfProductoComprado;

    public BaseDatosClientes instanciaa;
    public PantallaRegistrarClientes() {

        //Panel para mostrar todo
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

        //Etiquetas de texto
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
        
        botonComenzar = new JButton("¡¡Registrar cliente!!");
        botonComenzar.addActionListener(this); 


        //Cajas de texto
        Font fuente = new Font("Arial", Font.PLAIN, 20);  // Ejemplo: Arial, tamaño 20
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


        //Agregamos etiquetas y cajas de texto a un panel para centrarlo
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
        panelLabel.add(labelNombreCliente);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfNombreCliente);
        panelLabel.add(Box.createVerticalStrut(30));
        panelLabel.add(labelEmail);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfEmail);
        panelLabel.add(Box.createVerticalStrut(30));
        panelLabel.add(labelTelefono);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfTelefono);
        panelLabel.add(Box.createVerticalStrut(30));
        panelLabel.add(labelFechaNacimiento);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfFechaNacimiento);
        panelLabel.add(Box.createVerticalStrut(30)); 
        panelLabel.add(labelProductoComprado);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfProductoComprado);
        panelLabel.add(Box.createVerticalStrut(30)); 

        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.X_AXIS));
        panelLabel2.add(Box.createHorizontalStrut(100));
        panelLabel2.add(botonComenzar);

        //Añadimos este label al otro label en PantallaProductos
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false); 
        
        BoxLayout boxLayout = new BoxLayout(panelVentana , BoxLayout.Y_AXIS);
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
    //Atributos
    String nombreCliente = "";
    String email = "";
    String telefono = "";
    String fechaNacimiento = "";
    String productoComprado = "";

    //Al colocar la info y registrar el cliente tenemos que comprobar la info
        if (e.getSource() == botonComenzar) {
            //nombreCliente
            if(tfNombreCliente.getText().isEmpty() || tfNombreCliente.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el nombre del cliente");
            } else {
                nombreCliente = tfNombreCliente.getText();//Obtenemos nombreCliente
            }
            
            //email
            if(tfEmail.getText().isEmpty() || tfEmail.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca la email del cliente");
            } else {
                email = tfEmail.getText();//Obtenemos email
            }
            
            //telefono
            if(tfTelefono.getText().isEmpty() || tfTelefono.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el telefono del cliente");
            } else {
                telefono = tfTelefono.getText();//Obtenemos telefono
            }
            
            //FechaNacimiento
            if(tfFechaNacimiento.getText().isEmpty() || tfFechaNacimiento.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca la fecha de nacimiento del cliente");
            } else {
                fechaNacimiento = tfFechaNacimiento.getText();//Obtenemos fecha de nacimiento 
            }

            //ProductoComprado
            if(tfProductoComprado.getText().isEmpty() || tfProductoComprado.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el producto comprado");
            } else {
                productoComprado = tfProductoComprado.getText();//Obtenemos el producto comprado 
            }

            //BD archivoCSV
            //String archivoCSV = "src\\data\\cliente.csv";

            //Registra Producto si se llenaron los campos
            if( !tfNombreCliente.getText().isEmpty() && tfNombreCliente.getText() != null && !tfEmail.getText().isEmpty() 
            && tfEmail.getText() != null && !tfTelefono.getText().isEmpty() && tfTelefono.getText() != null 
            && !tfFechaNacimiento.getText().isEmpty() && tfFechaNacimiento.getText() != null 
            && !tfProductoComprado.getText().isEmpty() && tfProductoComprado.getText() != null){
                try {
                    RegistrarClientes RegClie = new RegistrarClientes();
                    RegClie.RegistrarCliente(nombreCliente, email, telefono, fechaNacimiento,
                                             productoComprado);
                    //Limpiamos
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