package Referencias;

import java.util.function.Function;
import java.util.function.Supplier;

interface Finder{
    int find(String s1, String s2);
}


public class ReferenciaOne {

    private int value;

    public ReferenciaOne(int value) {
        this.value = value;
    }
    //Creamos metodo estatico

    public static int doFind(String s1, String s2){
        return s1.indexOf(s2);
    }

    public static String toUpperCase(String s1){
        return s1.toUpperCase();
    }

    //Metodo no statico
    public String toLowerCase(String cadena){
        return cadena.toLowerCase();
    }

    public static void main(String[] args) {
//Llamamos al metodo estatico
        Finder finder = ReferenciaOne::doFind;

/*
        Finder finder = (s1, s2) -> s1.indexOf(s2);
        Finder f = String::indexOf;
        System.out.println(finder.find("Albert", "A"));
        System.out.println(f.find("Albert", "A"));
*/

        //Llamamos al metodo no statico pero  primero creamos objeto
        //ReferenciaOne referenciaOne = new ReferenciaOne();
        //Finder ff = referenciaOne::toLowerCase;

        //Supplier<ReferenciaOne> s = () -> new ReferenciaOne();
        //Supplier<ReferenciaOne> su = ReferenciaOne::new;
        Function<Integer, ReferenciaOne> fu = ReferenciaOne::new;


        //main
    }


    //class
}
