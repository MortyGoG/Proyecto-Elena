package src.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import src.control.MostrarProductos;

public class PantallaMostrarProductos extends JPanel implements ActionListener{
    private JButton botonComenzar;
    private JLabel  labelCodigo, labelBusqueda;
    private JTextField  tfCodigo;

    public PantallaMostrarProductos(){
        labelCodigo = new JLabel("Codigo: ");
        tfCodigo = new JTextField();
        tfCodigo.setPreferredSize(new Dimension(200, 30));
        botonComenzar = new JButton("Mostrar Producto");
        labelBusqueda = new JLabel("");
        botonComenzar.addActionListener(this);

        JPanel panelLabel1 = new JPanel(new BorderLayout());
        panelLabel1.setLayout(new BoxLayout(panelLabel1, BoxLayout.X_AXIS));
        panelLabel1.add(labelCodigo);
        panelLabel1.add(tfCodigo);
        panelLabel1.add(botonComenzar);
        panelLabel1.setOpaque(false);



        JPanel panelLabel2 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(300, 50));
        panelLabel2.setLayout(new BoxLayout(panelLabel2, BoxLayout.Y_AXIS));
        panelLabel2.add(labelBusqueda);
        panelLabel2.setOpaque(false);


        JPanel panelLabel0 = new JPanel(new BorderLayout());
        panelLabel2.setPreferredSize(new Dimension(600, 100));
        panelLabel0.setLayout(new BoxLayout(panelLabel0, BoxLayout.Y_AXIS));
        panelLabel0.add(panelLabel1);
        panelLabel0.add(panelLabel2);
        panelLabel0.setOpaque(false);

        add(panelLabel0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    String codigo = "";
        if (e.getSource() == botonComenzar) {
        //Codigo
        if(tfCodigo.getText().isEmpty() || tfCodigo.getText() == null){
            JOptionPane.showMessageDialog(null, "Coloca el codigo del producto");
        } else {
            codigo = tfCodigo.getText();//Obtenemos codigo
            MostrarProductos MosPro = new MostrarProductos();
            labelBusqueda.setText(MosPro.MostrarProducto(codigo));
        }
        }
    }
}
