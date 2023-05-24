package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {

    public static void main(String[] args) {

        String user = "root";
        String password = "Warrilinux";
        String url = "jdbc:mysql://localhost/mydb";

        String sql = "INSERT INTO login (username, password, created) VALUES ('patri', '123', '2023-01-01 10:01:00')";

        //IMPORTANTE: ESTO ES UN TRY WITH RESOURCES, QUE YA CIERRA TODA LAS CONEXIONES AUTOMATICAMENTE.
        try(Connection connection = DriverManager.getConnection(url,user,password); Statement statement = connection.createStatement()){
            statement.execute(sql);

            /* Otra manera es esta o la mas tradicional:
            Statement statement = connection.createStatement();
             statement.execute(sql);
             statement.close();
            Cuidado que si da un error hay que hacer una movida y hay que crear catch con
             */

            System.out.println(connection.getCatalog());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


        //main
    }

    //class
}
