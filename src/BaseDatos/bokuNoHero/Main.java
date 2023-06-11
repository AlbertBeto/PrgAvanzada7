package BaseDatos.bokuNoHero;

import BaseDatos.bokuNoHero.Model.Heroe;
import BaseDatos.bokuNoHero.Model.Quirks;
import BaseDatos.bokuNoHero.Mysql.BokuNoHeroeHandleBD;

public class Main {

    public static void main(String[] args) {

    Heroe.createHeroe1Poder("Lemilion","Mirio Togata", 18, "Permeabilidad","transformacion");

    Heroe.createHeroe2Poderes("Deku","Izuku Midoriya", 16,"Sin don","Nada","One for All","Emisor");

    Heroe.createHeroe2Poderes("Tomura Shigaraki","Tenko Shimura",22,"Deterioro","Emisor","All for One","Emisor");

    Heroe.createHeroe1Poder("Great Explosion Murder God Dynamight","Katsuki Bakugo",17,"Explosion","Emisor");

        BokuNoHeroeHandleBD.verHeroes();
        BokuNoHeroeHandleBD.mediaEdad();
        //main
    }
//class
}
