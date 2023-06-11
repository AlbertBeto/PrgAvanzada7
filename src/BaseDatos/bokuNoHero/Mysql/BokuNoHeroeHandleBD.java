package BaseDatos.bokuNoHero.Mysql;

import BaseDatos.NeoProyecto.Model.Login;
import BaseDatos.bokuNoHero.Model.Heroe;
import BaseDatos.bokuNoHero.Model.Quirks;
import BaseDatos.bokuNoHero.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BokuNoHeroeHandleBD {

    public int addHeroe(Heroe heroe){
        int salida=0;
        Connection c = DatabaseConnection.getConnection();
        String query = "INSERT INTO heroe (nickname,nombre,edad) values(?,?,?)";
        try{
            if (checkIdHeroe(heroe.getNickname())>=0){
                System.out.println("El nickname de heroe ya existe. Escoja otro nombre");
                salida= -1;
            }else {
                PreparedStatement pS= c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pS.setString(1, heroe.getNickname());
                pS.setString(2, heroe.getNombre());
                pS.setInt(3,heroe.getEdad());

                pS.execute();
                pS.close();
                int idHeroe=checkIdHeroe(heroe.getNickname());
                salida= idHeroe;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return salida;
    }



    public void addQuirk(Quirks poder){
        Connection c = BaseDatos.bokuNoHero.Util.DatabaseConnection.getConnection();
        String query = "INSERT INTO quirk (nombre,tipo,idHeroe) values(?,?,?)";
        try{
            PreparedStatement pS= c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pS.setString(1, poder.getNombre());
                pS.setString(2, poder.getTipo());
                pS.setInt(3,poder.getIdheroe());
                pS.execute();
                pS.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    //No necesario ya que se pueden repetir los poderes, aunque podriamos añadir comprobar el poder y el heroe.
    /*
    public int checkPower(String name) throws SQLException {
        Connection c = BaseDatos.bokuNoHero.Util.DatabaseConnection.getConnection();
        String query = "SELECT id FROM quirq WHERE nombre=?";
        PreparedStatement pS=c.prepareStatement(query);
        pS.setString(1,name);
        ResultSet rs = pS.executeQuery();
        if (rs.next()){
            int idPower=rs.getInt("id");
            System.out.println("El poder existe con id"+idPower);
            pS.close();
            return idPower;
        }else {
            System.out.println("El usuario no existe");
            pS.close();
            return -1;}

    }
*/

    public int checkIdHeroe(String nickname) throws SQLException {
        Connection c = BaseDatos.bokuNoHero.Util.DatabaseConnection.getConnection();
        String query = "SELECT id FROM heroe WHERE nickname=?";
        PreparedStatement pS=c.prepareStatement(query);
        pS.setString(1,nickname);
        ResultSet rs = pS.executeQuery();
        if (rs.next()){
            int idHeroe=rs.getInt("id");
           // System.out.println("El heroe existe con id"+idHeroe);
            pS.close();
            return idHeroe;
        }else {
            //System.out.println("El usuario no existe");
            pS.close();
            return -1;}
    }


    public static void verHeroes() {
            String query = "SELECT h.id,h.nickname,h.nombre,h.edad,q.nombre,q.tipo FROM heroe h JOIN quirk q on q.idHeroe=h.id";
            Connection c = BaseDatos.bokuNoHero.Util.DatabaseConnection.getConnection();
            try (Statement stat = c.createStatement()){

                ResultSet rs = stat.executeQuery(query);

                while (rs.next()){
                    System.out.println(rs.getInt(1)+": "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getInt(4)+". Poder: "+rs.getString(5)+" de tipo "+rs.getString(6));
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

public static void mediaEdad()  {
    String query = "SELECT avg(edad) AS media FROM heroe";
    Connection c = BaseDatos.bokuNoHero.Util.DatabaseConnection.getConnection();
    try {
        PreparedStatement pS = c.prepareStatement(query);
        ResultSet rs = pS.executeQuery();
        if (rs.next()) {
            double media = rs.getDouble("media");
            System.out.println("La media de edad de todos los Heroes es de: "+(int) media );
        }else{
            System.out.println("No hay datos para hacer la media de edad. ");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}


    //class
}
