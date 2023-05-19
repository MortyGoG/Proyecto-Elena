package src.gui;

import javax.swing.*;
import src.control.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class PantallaRegistrarProductos extends JPanel implements ActionListener{
    private JButton botonComenzar;
    private JLabel  labelCodigo, labelDescripcion, labelPrecio, labelPromocion,
                    labelPreciopromocion, labelFechaInicioPromocion, labelFechaTerminoPromocion, labelBeneficios;
    private JTextField  tfCodigo, tfDescripcion, tfPrecio, 
                    tfPrecioPromocion, tfFechaInicioPromocion, tfFechaTerminoPromocion, tfBeneficios;
    private JRadioButton trueButton, falseButton;
    private ButtonGroup buttonGroup;
    public PantallaRegistrarProductos() {

        //Panel para mostrar todo
        JPanel panelLabel = new JPanel(new BorderLayout());
        JPanel panelLabel2 = new JPanel(new BorderLayout());
        System.out.println("Mostrando RegisProdus");
        panelLabel.setOpaque(false);
        panelLabel2.setOpaque(false);

        /*---------------------------------Estilo---------------------------------*/
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 12; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);

        //Etiquetas de texto
        labelCodigo = new JLabel("Codigo: ");
        labelCodigo.setBorder(BorderFactory.createEmptyBorder());
        labelCodigo.setBackground(Color.BLACK);
        labelCodigo.setForeground(Color.WHITE);
        labelCodigo.setFont(sizedFont);

        labelDescripcion = new JLabel("Descripcion: ");
        labelDescripcion.setBorder(BorderFactory.createEmptyBorder());
        labelDescripcion.setBackground(Color.BLACK);
        labelDescripcion.setForeground(Color.WHITE);
        labelDescripcion.setFont(sizedFont);

        labelPrecio = new JLabel("Precio: ");
        labelPrecio.setBorder(BorderFactory.createEmptyBorder());
        labelPrecio.setBackground(Color.BLACK);
        labelPrecio.setForeground(Color.WHITE);
        labelPrecio.setFont(sizedFont);
        
        labelPromocion = new JLabel("Promocion: ");
        labelPromocion.setBorder(BorderFactory.createEmptyBorder());
        labelPromocion.setBackground(Color.BLACK);
        labelPromocion.setForeground(Color.WHITE);
        labelPromocion.setFont(sizedFont);
        
        labelPreciopromocion = new JLabel("Precio por Promocion: ");
        labelPreciopromocion.setBorder(BorderFactory.createEmptyBorder());
        labelPreciopromocion.setBackground(Color.BLACK);
        labelPreciopromocion.setForeground(Color.WHITE);
        labelPreciopromocion.setFont(sizedFont);
        
        labelFechaInicioPromocion = new JLabel("Fecha de Inicio de Promocion: ");
        labelFechaInicioPromocion.setBorder(BorderFactory.createEmptyBorder());
        labelFechaInicioPromocion.setBackground(Color.BLACK);
        labelFechaInicioPromocion.setForeground(Color.WHITE);
        labelFechaInicioPromocion.setFont(sizedFont);
        
        labelFechaTerminoPromocion = new JLabel("Fecha de Terminacion de Promocion");
        labelFechaTerminoPromocion.setBorder(BorderFactory.createEmptyBorder());
        labelFechaTerminoPromocion.setBackground(Color.BLACK);
        labelFechaTerminoPromocion.setForeground(Color.WHITE);
        labelFechaTerminoPromocion.setFont(sizedFont);
        
        labelBeneficios = new JLabel("Beneficios: ");
        labelBeneficios.setBorder(BorderFactory.createEmptyBorder());
        labelBeneficios.setBackground(Color.BLACK);
        labelBeneficios.setForeground(Color.WHITE);
        labelBeneficios.setFont(sizedFont);
        
        botonComenzar = new JButton("¡¡Registrar Producto!!");
        botonComenzar.addActionListener(this);

        //Botones
        trueButton = new JRadioButton("Si");
        trueButton.setFont(sizedFont);
        trueButton.setForeground(Color.WHITE);
        trueButton.setOpaque(false);

        falseButton = new JRadioButton("No");
        falseButton.setFont(sizedFont);
        falseButton.setForeground(Color.WHITE);
        falseButton.setOpaque(false);
        falseButton.setSelected(true);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(trueButton);
        buttonGroup.add(falseButton);     


        //Cajas de texto
        Font fuente = new Font("Arial", Font.PLAIN, 20);  // Ejemplo: Arial, tamaño 20
        tfCodigo = new JTextField();
        tfCodigo.setPreferredSize(new java.awt.Dimension(150, 10));
        tfCodigo.setFont(fuente);

        tfDescripcion = new JTextField();
        tfDescripcion.setPreferredSize(new java.awt.Dimension(150, 10));
        tfDescripcion.setFont(fuente);

        tfPrecio = new JTextField();
        tfPrecio.setPreferredSize(new java.awt.Dimension(150, 10));
        tfPrecio.setFont(fuente);

        tfPrecioPromocion = new JTextField();
        tfPrecioPromocion.setPreferredSize(new java.awt.Dimension(150, 10));
        tfPrecioPromocion.setFont(fuente);

        tfFechaInicioPromocion = new JTextField();
        tfFechaInicioPromocion.setPreferredSize(new java.awt.Dimension(150, 10));
        tfFechaInicioPromocion.setFont(fuente);

        tfFechaTerminoPromocion = new JTextField();
        tfFechaTerminoPromocion.setPreferredSize(new java.awt.Dimension(150, 10));
        tfFechaTerminoPromocion.setFont(fuente);

        tfBeneficios = new JTextField();
        tfBeneficios.setPreferredSize(new java.awt.Dimension(150, 10));
        tfBeneficios.setFont(fuente);


        //Agregamos etiquetas y cajas de texto a un panel para centrarlo
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
        panelLabel.add(labelCodigo);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfCodigo);
        panelLabel.add(Box.createVerticalStrut(20));
        panelLabel.add(labelDescripcion);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfDescripcion);
        panelLabel.add(Box.createVerticalStrut(20));
        panelLabel.add(labelPrecio);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfPrecio);
        panelLabel.add(Box.createVerticalStrut(20));
        panelLabel.add(labelPromocion);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(trueButton);
        panelLabel.add(falseButton);
        panelLabel.add(Box.createVerticalStrut(20)); 
        panelLabel.add(labelPreciopromocion);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfPrecioPromocion);
        panelLabel.add(Box.createVerticalStrut(20)); 
        panelLabel.add(labelFechaInicioPromocion);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfFechaInicioPromocion);
        panelLabel.add(Box.createVerticalStrut(20)); 
        panelLabel.add(labelFechaTerminoPromocion);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfFechaTerminoPromocion);
        panelLabel.add(Box.createVerticalStrut(20)); 
        panelLabel.add(labelBeneficios);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(tfBeneficios);
        panelLabel.add(Box.createVerticalStrut(10));

        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.X_AXIS));
        panelLabel2.add(Box.createHorizontalStrut(200));
        panelLabel2.add(botonComenzar);

        //Añadimos este label al otro label en PantallaProductos
        JPanel panelVentana = new JPanel();
        panelVentana.setPreferredSize(new Dimension(600, 600));
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
    String codigo = "";
    String descripcion = "";
    float precio = 0;
    boolean promocion = false;
    float precioPromocion = 0;
    String fechaInicioPromocion = "";
    String fechaTerminoPromocion = "";
    String beneficios = "";
    String archivoCSV;

    //Al colocar la info y registrar el producto tenemos que comprobar la info
        if (e.getSource() == botonComenzar) {
            //Codigo
            if(tfCodigo.getText().isEmpty() || tfCodigo.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
            } else {
                codigo = tfCodigo.getText();//Obtenemos codigo
            }
            
            //Descripcion
            if(tfDescripcion.getText().isEmpty() || tfDescripcion.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca la descripcion del producto");
            } else {
                descripcion = tfDescripcion.getText();//Obtenemos descripcion
            }
            
            //Precio
            if(tfPrecio.getText().isEmpty() || tfPrecio.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el precio del producto");
            } else {
                precio = Float.parseFloat(tfPrecio.getText());//Obtenemos precio
            }
            
            //PrecioPromocion
            if(tfPrecioPromocion.getText().isEmpty() || tfPrecioPromocion.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el precio de promocion del producto");
            } else {
                precioPromocion = Float.parseFloat(tfPrecioPromocion.getText());//Obtenemos descripcion
            }
            
            //Fecha Inicio Promocion
            if(tfFechaInicioPromocion.getText().isEmpty() || tfFechaInicioPromocion.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca la fecha de inicio de la promocion");
            } else {
                fechaInicioPromocion = tfFechaInicioPromocion.getText();//Obtenemos Fecha inicio promo
            }

            //Fecha Termina Promocion
            if(tfFechaTerminoPromocion.getText().isEmpty() || tfFechaTerminoPromocion.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca la fecha de terminacion de la promocion");
            } else {
                fechaTerminoPromocion = tfFechaTerminoPromocion.getText();//Obtenemos Fecha Termino Promo
            }

            //Beneficios
            if(tfBeneficios.getText().isEmpty() || tfBeneficios.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca los beneficios del producto");
            } else {
                beneficios = tfBeneficios.getText();//Obtenemos beneficios
            }

            //BD archivoCSV
            archivoCSV = "src\\data\\producto.csv";

            //Registra Producto si se llenaron los campos
            if( !tfCodigo.getText().isEmpty() && tfCodigo.getText() != null && !tfDescripcion.getText().isEmpty() 
            && tfDescripcion.getText() != null && !tfPrecio.getText().isEmpty() && tfPrecio.getText() != null 
            && !tfPrecioPromocion.getText().isEmpty() && tfPrecioPromocion.getText() != null 
            && !tfFechaInicioPromocion.getText().isEmpty() && tfFechaInicioPromocion.getText() != null 
            && !tfFechaTerminoPromocion.getText().isEmpty() && tfFechaTerminoPromocion.getText() != null 
            && !tfBeneficios.getText().isEmpty() && tfBeneficios.getText() != null){
                try {
                    RegistrarProductos RegPro = new RegistrarProductos();
                    if(trueButton.isSelected() == true){
                        promocion = true;
                    } else if (falseButton.isSelected() == true){
                        promocion = false;
                    }

                    RegPro.RegistrarProducto(codigo, descripcion, precio, promocion,
                                             precioPromocion, fechaInicioPromocion, fechaTerminoPromocion
                                             , beneficios,  archivoCSV);
                    //Limpiamos
                    tfCodigo.setText("");
                    tfDescripcion.setText("");
                    tfPrecio.setText("");
                    falseButton.setSelected(true);
                    tfPrecioPromocion.setText("");
                    tfFechaInicioPromocion.setText("");
                    tfFechaTerminoPromocion.setText("");
                    tfBeneficios.setText("");
                    
                } catch (IOException e1) {
                    System.out.println("Eror en registrar el producto");
                }
            }
        }
    }
}