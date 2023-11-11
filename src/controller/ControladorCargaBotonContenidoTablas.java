package controller;

import java.awt.event.*;
import java.sql.*;
import java.util.*;
import view.*;
import model.*;

public class ControladorCargaBotonContenidoTablas implements ActionListener {
    //--------------------------------------------
    FrameApp_AccesoDDBB frameApp_accesoDDBB;
    CargaBotonConenidoTablas cargaBotonConenidoTablas;
    ResultSet resultSet;
    //--------------------------------------------

    public ControladorCargaBotonContenidoTablas(FrameApp_AccesoDDBB frameApp_accesoDDBB){
        this.frameApp_accesoDDBB = frameApp_accesoDDBB;
        cargaBotonConenidoTablas = new CargaBotonConenidoTablas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameApp_accesoDDBB.jTextArea.setText("");

        String nombreTabla = (String)frameApp_accesoDDBB.jComboBox.getSelectedItem();
        ArrayList<String> campos;
        int cont = 1;
        resultSet = null;

        try {

            resultSet = cargaBotonConenidoTablas.ejectutaSQLtxtArea(nombreTabla);

            campos = cargaBotonConenidoTablas.cargaArregloBotonTabla(resultSet);


                while (resultSet.next()) {
                    frameApp_accesoDDBB.jTextArea.append(cont + "- ");
                    for (String nombreCampo : campos) {
                        frameApp_accesoDDBB.jTextArea.append(resultSet.getString(nombreCampo) + " | ");
                    }
                    frameApp_accesoDDBB.jTextArea.append("\n");
                    cont ++;
                }

                resultSet.close();

            } catch(SQLException | NullPointerException fie){
            frameApp_accesoDDBB.jTextArea.append("Error: " + fie.getMessage());

        } catch(Exception fcss){
        System.out.println("queonda1");
    }


    }

}
