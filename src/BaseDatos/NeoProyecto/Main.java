package BaseDatos.NeoProyecto;

import BaseDatos.NeoProyecto.Mysql.LoginHandleDB;

import java.sql.SQLException;

public class Main {
//Importante confirmar que tenemos las librerias necesarias instaladas tales como MySQL.

    public static void main(String[] args) {
        LoginHandleDB loginHandleDB = new LoginHandleDB();
        try {
            System.out.println(loginHandleDB.getLogins());
        }catch (SQLException e){
            System.out.println("Error al obtener la lista de logins de la base de datos.");
        }



        //main
    }


    //class
}
