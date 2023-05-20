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

import src.control.ModificarProductos;

public class PantallaModificarProductos extends JPanel implements ActionListener{
    private JButton botonBusqueda, botonModificar;
    //Busqueda
    private JLabel  labelCodigoBuqueda;
    private JTextField  tfCodigoBusqueda;
    private JPanel panelLabel1;
    
    //Modificar
    private JPanel panelLabel3, panelLabel4; 
    private JLabel  labelCodigo, labelDescripcion, labelPrecio, labelPromocion,
                    labelPreciopromocion, labelFechaInicioPromocion, labelFechaTerminoPromocion, labelBeneficios;
    private JTextField  tfCodigo, tfDescripcion, tfPrecio, 
                    tfPrecioPromocion, tfFechaInicioPromocion, tfFechaTerminoPromocion, tfBeneficios;
    private JRadioButton trueButton, falseButton;
    private ButtonGroup buttonGroup;

    public PantallaModificarProductos(){
        //Tipografia
        //Labels
        Font customFont = loadCustomFont("src\\gui\\undertale.otf");
        float fontSize = 10; // Tamaño de la letra deseado
        Font sizedFont = customFont.deriveFont(fontSize);
        //TextField
        Font fuente = new Font("Arial", Font.PLAIN, 15);  // Ejemplo: Arial, tamaño 20

        //Labels
        labelCodigoBuqueda = new JLabel("Codigo: ");
        labelCodigoBuqueda.setForeground(Color.WHITE);
        labelCodigoBuqueda.setFont(sizedFont);

        //Text Fields
        tfCodigoBusqueda = new JTextField();
        tfCodigoBusqueda.setPreferredSize(new Dimension(150, 20));
        tfCodigoBusqueda.setFont(fuente);

        //Buttons
        botonBusqueda = new JButton("Mostrar Producto");
        botonBusqueda.addActionListener(this);

        //Panel Label 1 (Panel de Busqueda)
        panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setPreferredSize(new Dimension(300, 20));
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(labelCodigoBuqueda);
        panelLabel1.add(tfCodigoBusqueda);
        panelLabel1.add(Box.createHorizontalStrut(10)); // espacio vertical
        panelLabel1.add(botonBusqueda);
        panelLabel1.setOpaque(false);
        
        //Panel Principal
        JPanel panelLabel0 = new JPanel();
        panelLabel1.setPreferredSize(new Dimension(600, 20));
        panelLabel0.add(panelLabel1);
        panelLabel0.setOpaque(false);

        //Modificar
        //Panel para mostrar todo
        panelLabel3 = new JPanel(new BorderLayout());
        panelLabel3.setPreferredSize(new Dimension(800, 500));
        panelLabel3.setOpaque(false);

        //Panel Boton
        panelLabel4 = new JPanel(new BorderLayout());
        panelLabel4.setLayout(new BoxLayout(panelLabel4, BoxLayout.X_AXIS));
        panelLabel4.setPreferredSize(new Dimension(800, 70));
        panelLabel4.setOpaque(false);
        
        botonModificar = new JButton("¡¡Registrar Producto!!");
        botonModificar.addActionListener(this);
        panelLabel4.add(botonModificar);
        panelLabel4.add(Box.createVerticalStrut(10));


        //Titulo
        JLabel label = new JLabel("                            Modificar Producto");
        label.setForeground(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 24); // Fuente con tamaño de 24 puntos y estilo negrita
        label.setFont(font);

        /*---------------------------------Estilo---------------------------------*/

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
        tfCodigo = new JTextField();
        tfCodigo.setPreferredSize(new java.awt.Dimension(100, 10));
        tfCodigo.setFont(fuente);

        tfDescripcion = new JTextField();
        tfDescripcion.setPreferredSize(new java.awt.Dimension(100, 10));
        tfDescripcion.setFont(fuente);

        tfPrecio = new JTextField();
        tfPrecio.setPreferredSize(new java.awt.Dimension(100, 10));
        tfPrecio.setFont(fuente);

        tfPrecioPromocion = new JTextField();
        tfPrecioPromocion.setPreferredSize(new java.awt.Dimension(100, 10));
        tfPrecioPromocion.setFont(fuente);

        tfFechaInicioPromocion = new JTextField();
        tfFechaInicioPromocion.setPreferredSize(new java.awt.Dimension(100, 10));
        tfFechaInicioPromocion.setFont(fuente);

        tfFechaTerminoPromocion = new JTextField();
        tfFechaTerminoPromocion.setPreferredSize(new java.awt.Dimension(100, 10));
        tfFechaTerminoPromocion.setFont(fuente);

        tfBeneficios = new JTextField();
        tfBeneficios.setPreferredSize(new java.awt.Dimension(100, 10));
        tfBeneficios.setFont(fuente);

        //Agregamos etiquetas y cajas de texto a un panel para centrarlo
        panelLabel3.setLayout(new BoxLayout(panelLabel3, BoxLayout.Y_AXIS));
        panelLabel3.add(labelCodigo);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfCodigo);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(labelDescripcion);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfDescripcion);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(labelPrecio);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfPrecio);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(labelPromocion);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(trueButton);
        panelLabel3.add(falseButton);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelPreciopromocion);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfPrecioPromocion);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelFechaInicioPromocion);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfFechaInicioPromocion);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelFechaTerminoPromocion);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfFechaTerminoPromocion);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelBeneficios);
        panelLabel3.add(Box.createVerticalStrut(5));
        panelLabel3.add(tfBeneficios);


        //Añadimos este label al otro label en PantallaProductos
        JPanel panelVentana = new JPanel();
        panelVentana.setPreferredSize(new Dimension(600, 600));
        panelVentana.setOpaque(false);  
        
        BoxLayout boxLayout = new BoxLayout(panelVentana , BoxLayout.Y_AXIS);
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
        if(e.getSource() == botonBusqueda){
            if(tfCodigoBusqueda.getText().isEmpty() || tfCodigoBusqueda.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
            } else {
                String archivoCSV = "src\\data\\producto.csv";
                String line = "";
                String cvsSplitBy = ",";
                String codigoBuscado;
                try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
                    codigoBuscado = tfCodigoBusqueda.getText();
                    while ((line = br.readLine()) != null) {
        
                        String[] data = line.split(cvsSplitBy);
                        String codigo = data[0]; // asumiendo que el codigo se encuentra en la primera columna
        
                        
                        if (codigo.equals(codigoBuscado)) {
                            // coincidencia encontrada mostrar el resto de datos de la misma fila
                            String descripcion = data[1];
                            String precio = data[2];
                            String promocion = data[3];
                            String precioPromocion = data[4];
                            String fechaInicioPromocion = data[5];
                            String fechaTerminoPromocion = data[6];
                            String beneficios = data[7];
                            tfCodigo.setText(codigo);
                            tfDescripcion.setText(descripcion);
                            tfPrecio.setText(precio);
                            if(promocion.equals("false")){
                                falseButton.setEnabled(true);
                            } else {
                                trueButton.setEnabled(true);
                            }
                            tfPrecioPromocion.setText(precioPromocion);
                            tfFechaInicioPromocion.setText(fechaInicioPromocion);
                            tfFechaTerminoPromocion.setText(fechaTerminoPromocion);
                            tfBeneficios.setText(beneficios);    
                            return;    
                        }
                    }
                    JOptionPane.showMessageDialog(null, "No encontrado");
                } catch (IOException a) {
                    a.printStackTrace();
                }
            }
        }

        if(e.getSource() == botonModificar){
            System.out.println("Comenzando");
            String codigoBuscado = "";
            String descripcion = "";
            float precio = 0;
            boolean promocion = false;
            float precioPromocion = 0;
            String fechaInicioPromocion = "";
            String fechaTerminoPromocion = "";
            String beneficios = "";
            String codigoOriginal = "";

            if(tfCodigo.getText().isEmpty() || tfCodigo.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
            } else {
                codigoBuscado = tfCodigo.getText();//Obtenemos codigo
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
                beneficios = tfBeneficios.getText();    //Obtenemos beneficios
            }
            
            //Codigo de Busqueda
            if(tfCodigoBusqueda.getText().isEmpty() || tfCodigoBusqueda.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
            } else {
                codigoOriginal = tfCodigoBusqueda.getText();    //Obtenemos beneficios
            }
            //Registra Producto si se llenaron los campos
            if( !tfCodigo.getText().isEmpty() && tfCodigo.getText() != null && !tfDescripcion.getText().isEmpty() 
            && tfDescripcion.getText() != null && !tfPrecio.getText().isEmpty() && tfPrecio.getText() != null 
            && !tfPrecioPromocion.getText().isEmpty() && tfPrecioPromocion.getText() != null 
            && !tfFechaInicioPromocion.getText().isEmpty() && tfFechaInicioPromocion.getText() != null 
            && !tfFechaTerminoPromocion.getText().isEmpty() && tfFechaTerminoPromocion.getText() != null 
            && !tfBeneficios.getText().isEmpty() && tfBeneficios.getText() != null){
                try {
                    ModificarProductos modPro = new ModificarProductos();
                    modPro.ModificarProducto(codigoBuscado, codigoOriginal, descripcion, precio, promocion,
                                             precioPromocion, fechaInicioPromocion, fechaTerminoPromocion
                                             , beneficios);
                    //Limpiamos
                    tfCodigo.setText("");
                    tfDescripcion.setText("");
                    tfPrecio.setText("");
                    tfPrecioPromocion.setText("");
                    tfFechaInicioPromocion.setText("");
                    tfFechaTerminoPromocion.setText("");
                    tfBeneficios.setText("");
                    
                } catch (IOException e1) {
                    System.out.println("Eror al modificar el producto");
                }
            }
        }
    }
}
