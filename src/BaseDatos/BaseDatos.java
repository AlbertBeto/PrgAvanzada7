package BaseDatos;

import java.sql.*;
import java.time.LocalDateTime;

public class BaseDatos {


    public static void execute(){

        String url = "jdbc:mysql://localhost/mydb";
        String insert = "INSERT INTO login (username, password) VALUES (?, ?)";
        ResultSet result;

        try(Connection connection = DriverManager.getConnection(url); PreparedStatement pS= connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)){

            //Vamos a cambiar el autocommit
            boolean autocommit = connection.getAutoCommit();
            connection.setAutoCommit(false);

            //Establecemos valores en la query
            pS.setString(1,"user");
            pS.setString(2,"password");
            LocalDateTime now = LocalDateTime.now();
            pS.setTimestamp(3,Timestamp.valueOf(now));

            pS.execute();
            result= pS.getGeneratedKeys();

            if (result.next()) {
                int id = result.getInt(1);
                System.out.println(id);
            }
            //Queremos que cuando hagamos un commit actualize el campo de la fecha con la fecha del momento.


            //Realizamos el commit si no ha saltado ningun error
            connection.commit();
            connection.setAutoCommit(autocommit);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String user = "root";
        String password = "Warrilinux";
        String url = "jdbc:mysql://localhost/mydb";

        String sql = "INSERT INTO login (username, password, created) VALUES ('patri', '123', '2023-01-01 10:01:00')";
        String sqlpre = "INSERT INTO login (username, password, created) VALUES (?, ?, ?)";
        String sqlSelect = "SELECT * FROM login";
        //IMPORTANTE: ESTO ES UN TRY WITH RESOURCES, QUE YA CIERRA TODA LAS CONEXIONES AUTOMATICAMENTE.
        try(Connection connection = DriverManager.getConnection(url,user,password); Statement statement = connection.createStatement(); PreparedStatement preparedStatement = connection.prepareStatement(sqlpre,Statement.RETURN_GENERATED_KEYS);){

            // Desconecto el exequite sql ya que me da errores cuando lo lanzo una segunda vez.
            //  statement.execute(sql);
            preparedStatement.setString(1,"Edu");
            preparedStatement.setString(2,"Edu");
            LocalDateTime now = LocalDateTime.now();
            preparedStatement.setTimestamp(3,Timestamp.valueOf(now));
            preparedStatement.execute();

            //Con esto recuperamos un dato de la tabla de datos que es autogenerado. Por ejemplo el ID y ya guardado en una variable.
            ResultSet rs = preparedStatement.getGeneratedKeys();
            //Confirmamos que tenga un valor, es parecido a los itenadores, e imprimimos el valor.
            if (rs.next()){
                System.out.println(rs.getInt(1));
                //Con Id parece que no funciona al hacer el getGeneratedKeys
                //System.out.println(rs.getInt("id"));
            }

            ResultSet rs2 = statement.executeQuery(sqlSelect);
            while (rs2.next()){
                System.out.println(rs2.getInt("id")+" "+rs2.getString(2) + " ");
                System.out.println(rs2.getString(3));
                System.out.println();
            }




            /* Otra manera es esta o la más tradicional:
            Statement statement = connection.createStatement();
             statement.execute(sql);
             statement.close();
            Cuidado que si da un error hay que hacer una movida y hay que crear catch con
             */
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


        //main
    }

    //class
}
