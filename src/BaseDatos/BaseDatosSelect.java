package BaseDatos;

import java.sql.*;
import java.time.LocalDateTime;

public class BaseDatosSelect {
//ESTO EN REALIDAD ES UNA TRANSACCION A LA BASE DE DATOS.
    public static void execute(){
        String user = "root";
        String password = "Warrilinux";
        String url = "jdbc:mysql://localhost/mydb";
        String insert = "INSERT INTO login (username, password) VALUES (?, ?)";
        String update = "UPDATE login SET created_At=? WHERE id = ?";
        ResultSet result;

        try(Connection connection = DriverManager.getConnection(url)){
            try(
            PreparedStatement pS= connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS); PreparedStatement pUpdate = connection.prepareStatement(update)){

            //Vamos a cambiar el autocommit
            boolean autocommit = connection.getAutoCommit();
            connection.setAutoCommit(false);

            //Establecemos valores en la query
            pS.setString(1,"user");
            pS.setString(2,"password");


            pS.execute();
            result= pS.getGeneratedKeys();

            if (result.next()) {
                int id = result.getInt(1);
                System.out.println(id);
                //Tot esto es para modificar la fecha una vez realizada la modificación
                LocalDateTime now = LocalDateTime.now();
                pUpdate.setTimestamp(1,Timestamp.valueOf(now));
                pUpdate.setInt(2, id);
                pUpdate.executeUpdate();

            }
            //Queremos que cuando hagamos un commit actualize el campo de la fecha con la fecha del momento.


            //Realizamos el commit si no ha saltado ningun error
            connection.commit();
            connection.setAutoCommit(autocommit);
        }catch (SQLException e){
            //
            System.out.println(e.getMessage());
        }

        }catch (SQLException e){
        //Este es catch de la conexion
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {

        execute();


        //main
    }



    //class
}
