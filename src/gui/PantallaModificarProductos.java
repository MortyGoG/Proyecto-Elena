package src.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import src.control.ModificarProductos;

public class PantallaModificarProductos extends JPanel implements ActionListener{
    private JButton botonBusqueda, botonModificar;
    //Busqueda
    private JLabel  labelCodigoBuqueda;
    private JTextField  tfCodigoBusqueda;
    private JPanel panelLabel0, panelLabel1;
    private JTextArea labelBusqueda;
    private String texto;
    //Modificar
    private JPanel panelLabel3, panelLabel4; 
    private JLabel  labelCodigo, labelDescripcion, labelPrecio, labelPromocion,
                    labelPreciopromocion, labelFechaInicioPromocion, labelFechaTerminoPromocion, labelBeneficios;
    private JTextField  tfCodigo, tfDescripcion, tfPrecio, 
                    tfPrecioPromocion, tfFechaInicioPromocion, tfFechaTerminoPromocion, tfBeneficios;
    private JRadioButton trueButton, falseButton;
    private ButtonGroup buttonGroup;

    public PantallaModificarProductos(){
        //Interfaz
        //Labels
        labelCodigoBuqueda = new JLabel("Codigo: ");
        //Text Fields
        tfCodigoBusqueda = new JTextField();
        tfCodigoBusqueda.setPreferredSize(new Dimension(200, 30));
        //Buttons
        botonBusqueda = new JButton("Mostrar Producto");
        botonBusqueda.addActionListener(this);

        //Panel Label 1 (Panel de Busqueda)
        panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(labelCodigoBuqueda);
        panelLabel1.add(tfCodigoBusqueda);
        panelLabel1.add(botonBusqueda);
        panelLabel1.setOpaque(false);
        
        //Panel Principal
        JPanel panelLabel0 = new JPanel(new BorderLayout());
        panelLabel0.setLayout(new BoxLayout(panelLabel0, BoxLayout.Y_AXIS));
        panelLabel0.add(panelLabel1);
        panelLabel0.add(Box.createVerticalStrut(50));
        panelLabel0.setOpaque(false);
        //Agregamos el Panel

        //Modificar
        //Panel para mostrar todo
        panelLabel3 = new JPanel(new BorderLayout());
        panelLabel4 = new JPanel(new BorderLayout());
        panelLabel4.setPreferredSize(new Dimension(300, 25));
        panelLabel3.setOpaque(false);
        panelLabel4.setOpaque(false);

        //Titulo
        JLabel label = new JLabel("                            Modificar Producto");
        Font font = new Font("Arial", Font.BOLD, 24); // Fuente con tamaño de 24 puntos y estilo negrita
        label.setFont(font);

        //Etiquetas de texto
        labelCodigo = new JLabel("Codigo: ");
        labelDescripcion = new JLabel("Descripcion: ");
        labelPrecio = new JLabel("Precio: ");
        labelPromocion = new JLabel("Promocion: ");
        labelPreciopromocion = new JLabel("Precio por Promocion: ");
        labelFechaInicioPromocion = new JLabel("Fecha de Inicio de Promocion: ");
        labelFechaTerminoPromocion = new JLabel("Fecha de Terminacion de Promocion");
        labelBeneficios = new JLabel("Beneficios: ");
        botonModificar = new JButton("¡¡Modificar Producto!!");
        botonModificar.addActionListener(this);

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
        panelLabel3.setLayout(new BoxLayout(panelLabel3, BoxLayout.Y_AXIS));
        panelLabel3.add(label);
        panelLabel3.add(labelCodigo);
        panelLabel3.add(tfCodigo);
        panelLabel3.add(Box.createVerticalStrut(10)); // espacio vertical
        panelLabel3.add(labelDescripcion);
        panelLabel3.add(tfDescripcion);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(labelPrecio);
        panelLabel3.add(tfPrecio);
        panelLabel3.add(Box.createVerticalStrut(10));
        panelLabel3.add(labelPromocion);
        panelLabel3.add(trueButton);
        panelLabel3.add(falseButton);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelPreciopromocion);
        panelLabel3.add(tfPrecioPromocion);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelFechaInicioPromocion);
        panelLabel3.add(tfFechaInicioPromocion);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelFechaTerminoPromocion);
        panelLabel3.add(tfFechaTerminoPromocion);
        panelLabel3.add(Box.createVerticalStrut(10)); 
        panelLabel3.add(labelBeneficios);
        panelLabel3.add(tfBeneficios);
        panelLabel3.add(Box.createVerticalStrut(20));

        panelLabel4.setLayout(new BoxLayout(panelLabel4, BoxLayout.X_AXIS));
        panelLabel4.add(Box.createHorizontalStrut(100));
        panelLabel4.add(botonModificar);

        //Añadimos este label al otro label en PantallaProductos
        JPanel panelVentana = new JPanel();
        panelVentana.setOpaque(false); 
        
        BoxLayout boxLayout = new BoxLayout(panelVentana , BoxLayout.Y_AXIS);
        panelVentana.setLayout(boxLayout);
        panelVentana.add(panelLabel0);
        panelVentana.add(panelLabel3);
        panelVentana.add(panelLabel4);

        add(panelVentana);
        
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
