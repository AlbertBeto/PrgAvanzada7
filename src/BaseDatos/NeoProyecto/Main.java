package BaseDatos.NeoProyecto;

import BaseDatos.NeoProyecto.Model.Login;
import BaseDatos.NeoProyecto.Mysql.LoginHandleDB;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
//Importante confirmar que tenemos las librerías necesarias instaladas tales como MySQL.

    public static void main(String[] args) {
        Login Albert = new Login("Albert","Beto");
        Login Mai = new Login("Mai","Maite");
        Login NeoMai= new Login("Maite","Mai");

        LoginHandleDB loginHandleDB = new LoginHandleDB();



        try {

            //loginHandleDB.addLogin(Albert);
           // loginHandleDB.addLogin(Mai);
            System.out.println(loginHandleDB.getLogins());
            //loginHandleDB.getId("Albert","Befffto");
           // loginHandleDB.deleteUser(13);
            loginHandleDB.update(Mai,NeoMai);

        }catch (SQLException e){
            System.out.println("Error al obtener la lista de logins de la base de datos.");
        }


       // System.out.println(Albert.toString());

        //main
    }


    //class
}
