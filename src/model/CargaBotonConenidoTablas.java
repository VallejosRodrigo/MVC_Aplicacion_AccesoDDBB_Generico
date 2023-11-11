package model;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CargaBotonConenidoTablas {
    //------------------------------------------
    ConexionDB conexionDB;
    ResultSet resultSet;
    //------------------------------------------

    public CargaBotonConenidoTablas() {
        conexionDB = new ConexionDB();
    }
//---------------------------------------------------------------------------
    public ResultSet ejectutaSQLtxtArea(String nombreTabla) throws SQLException, IOException {
        resultSet = null;

        String consulta = "SELECT * FROM " + nombreTabla;

        Connection connection = conexionDB.conectar();


            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(consulta);



        return resultSet;
    }
//-----------------------------------------------------------------------------------
    public ArrayList<String> cargaArregloBotonTabla(ResultSet resultSet1) throws SQLException {
        ArrayList<String> camposs = new ArrayList<>();

        ResultSetMetaData resultSetMetaData = null; //almacena en esta variable los metadatos del resulset

            resultSetMetaData = resultSet1.getMetaData();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) { //recorre los campos del resulset/resulsetmetadata.
                camposs.add(resultSetMetaData.getColumnLabel(i)); //indica por parametro que columna se quiere obtener
            }

        return camposs;

    }
}
