package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    public static void main(String[] args) {

        String user = "root";
        String password = "Warrilinux";
        String url = "jdbc:mysql://localhost/PELICULAS";

        try(Connection connection = DriverManager.getConnection(url,user,password)){
            System.out.println(connection.getCatalog());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


        //main
    }

    //class
}
