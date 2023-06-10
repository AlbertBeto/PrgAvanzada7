package BaseDatos.NeoProyecto.Mysql;

import BaseDatos.NeoProyecto.Model.Login;
import BaseDatos.NeoProyecto.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginHandleDB {

    //insert
    public void addLogin(Login usuarioLogin){
        Connection c = DatabaseConnection.getConnection();
        String query = "INSERT INTO login (username,password,createdAt) values(?,?,?)";
        try{
                PreparedStatement pS= c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           pS.setString(1,usuarioLogin.getUsername());
            pS.setString(2,usuarioLogin.getPassword());
            pS.setObject(3,usuarioLogin.getCreatedAt());
            //"++","+usuarioLogin.getPassword()+","+usuarioLogin.getCreatedAt()+"

            pS.execute();

            pS.close();
            c.close();
     }catch (SQLException e){

        System.out.println(e.getMessage());
    }
    }

    //select
    //update
    //delete
    // Otro metodo o busqueda

    //Lanzo el error hacia arriba, ya que este metodo solo devuelve los logins el resto que lo hagan arriba
    public List<Login> getLogins() throws SQLException {
        String query = "SELECT * FROM login";
        Connection c = DatabaseConnection.getConnection();
        try (Statement stat = c.createStatement()){
            List<Login> lg = new ArrayList<>();
            //Llamo a mi query
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()){
                Login login = new Login("Patri","PatriPatri");
                login.setId(rs.getInt(1));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setCreatedAt(rs.getTimestamp("created").toLocalDateTime());
                lg.add(login);
            }
            return lg;
        }

    }

}
