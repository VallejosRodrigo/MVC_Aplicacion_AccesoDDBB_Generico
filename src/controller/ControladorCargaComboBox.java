package controller;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.*;
import model.*;


//todo---------------Controlador para cargar los combo box de DDBB a FRONT--------
public class ControladorCargaComboBox extends WindowAdapter{
    //--------------------------------------
    FrameApp_AccesoDDBB frameApp_accesoDDBB;
    CargaComboBox cargaComboBox;
    ResultSet resultSet;
    //--------------------------------------

    public ControladorCargaComboBox(FrameApp_AccesoDDBB frameApp_accesoDDBB){
        this.frameApp_accesoDDBB = frameApp_accesoDDBB;
        cargaComboBox = new CargaComboBox();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        resultSet = null;
        resultSet = cargaComboBox.EjecutaConsulta();

        try{
            while(resultSet.next()){
                frameApp_accesoDDBB.jComboBox.addItem(resultSet.getString("TABLE_NAME"));
            }

            resultSet.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }


}
