package BaseDatos.bokuNoHero.Mysql;

import BaseDatos.NeoProyecto.Model.Login;
import BaseDatos.bokuNoHero.Model.Heroe;
import BaseDatos.bokuNoHero.Model.Quirks;
import BaseDatos.bokuNoHero.Util.DatabaseConnection;

import java.sql.*;

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



    //class
}
