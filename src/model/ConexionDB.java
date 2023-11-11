package model;

import java.io.*;
import java.sql.*;

//todo---------Clase conecta DDBB------------------
public class ConexionDB {
    //-----------------------------------------
    Connection connection;
    FileReader fileReader;
    //-----------------------------------------

    public ConexionDB(){
        connection = null;
    }


    public Connection conectar(){
        String datos[] = new String[3]; //arreglo donde se van a almacenar los 3 datos importantes para la coneccion

        try {
            fileReader = new FileReader("D:\\Archivos\\Desktop\\configDB.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < 3; i++) {
                datos[i] = bufferedReader.readLine();
            }

            connection = DriverManager.getConnection(datos[0], datos[1], datos[2]);

            fileReader.close();

        } catch (SQLException | IOException e) {

            return connection=null;
        }

        return connection;

    }
}
