package model;
import java.sql.*;

//todo----------clase que carga el comboBox------------
public class CargaComboBox {
    //-----------------------------------------
    ConexionDB conexionDB;
    ResultSet resultSet;
    //-----------------------------------------

    public  CargaComboBox(){
        conexionDB = new ConexionDB();
    }

    //---------------------------------------------------
    public ResultSet EjecutaConsulta(){
        resultSet = null;

        try{
            Connection connection = conexionDB.conectar();

            DatabaseMetaData databaseMetaData = connection.getMetaData();

            resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});

            connection.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

}
