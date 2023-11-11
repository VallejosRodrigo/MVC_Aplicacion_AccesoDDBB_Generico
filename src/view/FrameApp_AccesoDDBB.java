package view;

import controller.ControladorCargaBotonContenidoTablas;
import controller.ControladorCargaComboBox;

import javax.swing.*;
import java.awt.*;

//todo-----Front---------Clase intefase usuario-------------
public class FrameApp_AccesoDDBB extends JFrame {
    //------------------------------------------------
    JPanel jPanelPrincipal, jPanelCombobox, jPanelBoton;
    JButton botonConsultar;
    public JComboBox jComboBox;
    public JTextArea jTextArea;
    JScrollPane jScrollPane;
    //------------------------------------------------

    public FrameApp_AccesoDDBB(){

        iniciaFrame();
        elementosSwing();

        add(jPanelPrincipal);
        addWindowListener(new ControladorCargaComboBox(this));

        setVisible(true);
    }

    private void iniciaFrame(){
        setBounds(500,100,700,550);
        setTitle("Lector genérico Bases de Datos mySQL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void elementosSwing(){
        //---------------------Paneles---------------------------
        jPanelPrincipal = new JPanel();
        jPanelCombobox = new JPanel();
        jPanelBoton = new JPanel();

        jPanelPrincipal.setLayout(new BorderLayout());
        jPanelCombobox.setLayout(new FlowLayout());
        jPanelBoton.setLayout(new FlowLayout());

        //------------------combobox------------------------------
        jComboBox = new JComboBox();
        jComboBox.setEditable(false);

        jComboBox.addActionListener(new ControladorCargaBotonContenidoTablas(this));

        //-------------------boton-----------------------------
        botonConsultar = new JButton("Consultar");

        //------------------------text area------------------------
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);

        jScrollPane = new JScrollPane(jTextArea);

        //-----------------------Agrega elementos a paneles-------------------------
        jPanelCombobox.add(jComboBox);
        jPanelBoton.add(botonConsultar);

        jPanelPrincipal.add(jPanelCombobox, BorderLayout.NORTH);
        jPanelPrincipal.add(jPanelBoton, BorderLayout.SOUTH);
        jPanelPrincipal.add(jScrollPane);

    }

}
