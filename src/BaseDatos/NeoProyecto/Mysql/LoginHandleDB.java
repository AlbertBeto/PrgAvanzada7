package BaseDatos.NeoProyecto.Mysql;

import BaseDatos.NeoProyecto.Model.Login;
import BaseDatos.NeoProyecto.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginHandleDB {

    //insert
    //select
    //update
    //delete
    // Otro metodo o busqueda

    //Lanzo el erro hacia arriba ya que este metodo solo devuelve los logins el resto que lo hagan arriba
    public List<Login> getLogins() throws SQLException {
        String query = "SELECT * FROM login";
        Connection c = DatabaseConnection.getConnection();
        try (Statement stat = c.createStatement()){
            List<Login> lg = new ArrayList<>();
            //Llamo a mi query
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()){
                Login login = new Login();
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
