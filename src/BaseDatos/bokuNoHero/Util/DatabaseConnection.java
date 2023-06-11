package BaseDatos.bokuNoHero.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //privado ya que no queremos que nadie acceda al a conexión.
    //Y statico ya que quiero que haya solo una conexion
    private static Connection connection = null;


    static {
        //Este es un campo static que me permite dar valor a connection que es static.
        String url = "jdbc:mysql://localhost/bokuNoHero";
        String user = "root";
        String password = "Warrilinux";
        try{
            //Aquí a lo mejor falta meterlo el user y password.
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            e.printStackTrace();
        }

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
