package BaseDatos.bokuNoHero;

import BaseDatos.bokuNoHero.Model.Heroe;
import BaseDatos.bokuNoHero.Model.Quirks;
import BaseDatos.bokuNoHero.Mysql.BokuNoHeroeHandleBD;

public class Main {

    public static void main(String[] args) {

   //     Heroe.createHeroe1Poder("Lemilion","Mirio Togata", 18, "Permeabilidad","transformacion");

//Heroe.createHeroe2Poderes("Deku","Izuku Midoriya", 16,"Sin don","Nada","One for All","Emisor");

        BokuNoHeroeHandleBD.verHeroes();

        //main
    }
//class
}
