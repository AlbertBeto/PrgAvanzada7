package BaseDatos.bokuNoHero.Model;

public class Quirks {
    private String nombre;
    private String tipo;
    private int idheroe;

    private Quirks(String nombre, String tipo, int idheroe) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.idheroe = idheroe;

    }

    private Quirks() {
    }

    public static Quirks createQuirk(String nombre, String tipo, int idheroe){
        Quirks quirk = new Quirks(nombre,tipo,idheroe);
return quirk;

    }

    public String getNombre() {
        return nombre;
    }


    public String getTipo() {
        return tipo;
    }

    public int getIdheroe() {
        return idheroe;
    }

    //class
}
