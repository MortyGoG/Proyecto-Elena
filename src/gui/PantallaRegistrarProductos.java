package src.gui;

import javax.swing.*;
import src.control.*;
import src.data.BaseDatos;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class PantallaRegistrarProductos extends JPanel implements ActionListener{
    private JButton botonComenzar;
    private JLabel  labelCodigo, labelDescripcion, labelPrecio, labelPromocion,
                    labelPreciopromocion, labelFechaInicioPromocion, labelFechaTerminoPromocion, labelBeneficios;
    private JTextField  tfCodigo, tfDescripcion, tfPrecio, 
                    tfPrecioPromocion, tfFechaInicioPromocion, tfFechaTerminoPromocion, tfBeneficios;
    private JRadioButton trueButton, falseButton;
    private ButtonGroup buttonGroup;

    public BaseDatos instanciaa;
    public PantallaRegistrarProductos() {

        //Panel para mostrar todo
        JPanel panelLabel = new JPanel(new BorderLayout());
        JPanel panelLabel2 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(300, 50));
        System.out.println("Mostrando RegisProdus");
        panelLabel.setOpaque(false);
        panelLabel2.setOpaque(false);


        //Etiquetas de texto
        labelCodigo = new JLabel("Codigo: ");
        labelDescripcion = new JLabel("Descripcion: ");
        labelPrecio = new JLabel("Precio: ");
        labelPromocion = new JLabel("Promocion: ");
        labelPreciopromocion = new JLabel("Precio por Promocion: ");
        labelFechaInicioPromocion = new JLabel("Fecha de Inicio de Promocion: ");
        labelFechaTerminoPromocion = new JLabel("Fecha de Terminacion de Promocion");
        labelBeneficios = new JLabel("Beneficios: ");
        botonComenzar = new JButton("¡¡Registrar Producto!!");
        botonComenzar.addActionListener(this);

        //Botones
        trueButton = new JRadioButton("Si");
        falseButton = new JRadioButton("No");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(trueButton);
        buttonGroup.add(falseButton);
        trueButton.setOpaque(false);
        falseButton.setOpaque(false);


        //Cajas de texto
        tfCodigo = new JTextField();
        tfDescripcion = new JTextField();
        tfPrecio = new JTextField();
        tfPrecioPromocion = new JTextField();
        tfFechaInicioPromocion = new JTextField();
        tfFechaTerminoPromocion = new JTextField();
        tfBeneficios = new JTextField();

        //Agregamos etiquetas y cajas de texto a un panel para centrarlo
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
        panelLabel.add(labelCodigo);
        panelLabel.add(tfCodigo);
        panelLabel.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel.add(labelDescripcion);
        panelLabel.add(tfDescripcion);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(labelPrecio);
        panelLabel.add(tfPrecio);
        panelLabel.add(Box.createVerticalStrut(10));
        panelLabel.add(labelPromocion);
        panelLabel.add(trueButton);
        panelLabel.add(falseButton);
        panelLabel.add(Box.createVerticalStrut(10)); 
        panelLabel.add(labelPreciopromocion);
        panelLabel.add(tfPrecioPromocion);
        panelLabel.add(Box.createVerticalStrut(10)); 
        panelLabel.add(labelFechaInicioPromocion);
        panelLabel.add(tfFechaInicioPromocion);
        panelLabel.add(Box.createVerticalStrut(10)); 
        panelLabel.add(labelFechaTerminoPromocion);
        panelLabel.add(tfFechaTerminoPromocion);
        panelLabel.add(Box.createVerticalStrut(10)); 
        panelLabel.add(labelBeneficios);
        panelLabel.add(tfBeneficios);
        panelLabel.add(Box.createVerticalStrut(20));

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
                    RegPro.RegistrarProducto(codigo, descripcion, precio, promocion,
                                             precioPromocion, fechaInicioPromocion, fechaTerminoPromocion
                                             , beneficios,  archivoCSV);
                    //Limpiamos
                    tfCodigo.setText("");
                    tfDescripcion.setText("");
                    tfPrecio.setText("");
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