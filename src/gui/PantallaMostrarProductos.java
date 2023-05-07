package src.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import src.control.MostrarProductos;

public class PantallaMostrarProductos extends JPanel implements ActionListener{
    private JButton botonComenzar;
    private JLabel  labelCodigo;
    private JTextField  tfCodigo;
    private JPanel panelLabel0, panelLabel1, panelLabel2;
    private JTextArea labelBusqueda;
    private String texto;

    public PantallaMostrarProductos(){

        //Interfaz
        //Labels
        labelCodigo = new JLabel("Codigo: ");
        //Text Fields
        tfCodigo = new JTextField();
        tfCodigo.setPreferredSize(new Dimension(200, 30));
        //Buttons
        botonComenzar = new JButton("Mostrar Producto");
        botonComenzar.addActionListener(this);

        //Panel Label 1 (Panel de Busqueda)
        panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(labelCodigo);
        panelLabel1.add(tfCodigo);
        panelLabel1.add(botonComenzar);
        panelLabel1.setOpaque(false);

        //Panel Label 2 (Panel de espaciado)
        JPanel panelLabel2 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(350, 50));
        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.Y_AXIS));
        panelLabel2.setOpaque(false);

        //Text Area Mostrar Producto
        labelBusqueda = new JTextArea();
        labelBusqueda.setEditable(false);
        labelBusqueda.setPreferredSize(new Dimension(200, 250));
        JScrollPane scrollPane = new JScrollPane(labelBusqueda); //Para deslizar
        
        //Panel Principal
        JPanel panelLabel0 = new JPanel(new BorderLayout());
        panelLabel0.setLayout(new BoxLayout(panelLabel0, BoxLayout.Y_AXIS));
        panelLabel0.add(panelLabel1);
        panelLabel0.add(panelLabel2);
        panelLabel0.add(scrollPane);
        panelLabel0.setOpaque(false);
        add(panelLabel0);//Agregamos el Panel
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    String codigo = "";
    //Mostrar la coincidencia
        if (e.getSource() == botonComenzar) {
            //Codigo
            if(tfCodigo.getText().isEmpty() || tfCodigo.getText() == null){
                JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
            } else {
                codigo = tfCodigo.getText();//Obtenemos codigo
                MostrarProductos MosPro = new MostrarProductos();
                texto = (MosPro.MostrarProducto(codigo));
                labelBusqueda.setText(null);
                labelBusqueda.append(texto);
            }
        }
    }
}
