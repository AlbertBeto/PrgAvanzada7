package BaseDatos.NeoProyecto;

import BaseDatos.NeoProyecto.Model.Login;
import BaseDatos.NeoProyecto.Mysql.LoginHandleDB;

import java.sql.SQLException;

public class Main {
//Importante confirmar que tenemos las librerias necesarias instaladas tales como MySQL.

    public static void main(String[] args) {
        Login Albert = new Login("Albert","Beto");


        LoginHandleDB loginHandleDB = new LoginHandleDB();

        loginHandleDB.addLogin(Albert);

        try {
            System.out.println(loginHandleDB.getLogins());
        }catch (SQLException e){
            System.out.println("Error al obtener la lista de logins de la base de datos.");
        }


       // System.out.println(Albert.toString());

        //main
    }


    //class
}
