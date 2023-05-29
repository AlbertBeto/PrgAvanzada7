package BaseDatos.NeoProyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //privado ya que no queremos que nadie acceda al a conexión.
    //Y statico ya que quiero que haya solo una conexion
    private static Connection connection = null;


    {
        //Este es un campo estatico que me perimitw dar valor a connection que es statico.
        String url = "jdbc:mysql://localhost/mydb";
        String user = "root";
        String password = "Warrilinux";
        try{
            connection = DriverManager.getConnection(url);
        }catch (SQLException e){}

    }
    private DatabaseConnection(){

    }

    //Con esto podemos llamar a la conexion.
    public static Connection getConnection(){
        return connection;
    }

    public static void close() throws SQLException{
        connection.close();
    }

    //class
}
