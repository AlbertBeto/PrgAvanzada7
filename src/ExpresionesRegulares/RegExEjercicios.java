package ExpresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExEjercicios {
    public static void main(String[] args) {

      //Ejercicio 1

        String voyAl1 = "He ido al cine";
        String voyAl2 = "He ido al supermercado";

        System.out.println(voyAl2.matches("He ido al .*"));


        //Ejercicio 2

        Pattern patronVoyAl = Pattern.compile("He ido al .*");
        Matcher macheadorVoyAl = patronVoyAl.matcher(voyAl1);
        System.out.println(macheadorVoyAl.matches());

        //Ejercicio 3

        String blancoAGuion = "Ciclo formativo Desarrollo de aplicaciones multiplataforma.";
        System.out.println(blancoAGuion.replaceAll(" ","_"));

        //Ejercicio 4
        System.out.println("Ejercicio 4");
        String vocales1 = "aaabcccccccdddefffg";
        //System.out.println(vocales1.matches("^\\w{3}\\w\\w{7}\\w{3}\\w{1}\\w{3}\\w{1}$"));
        System.out.println(vocales1.matches("a{3}[b]c{7}d{3}[e]f{3}[g]"));

        //Ejercicio 5
        System.out.println("Ejercicio 5");
        //System.out.println(vocales1.matches("^\\w{3}\\w\\w{7}\\w{3}\\w{1}\\w{3}\\w{1}$"));
        System.out.println(vocales1.matches("^a{3}[b]c{7}d{3}[e]f{3}[g]$"));

        //Ejercicio 6
        System.out.println("Ejercicio 6");
        String letraPuntoDigito = "dsdwsddwe.233432";
        System.out.println(letraPuntoDigito.matches("^\\w+[.]\\d+$"));

        //Ejercicio 7
        System.out.println("Ejercicio 7");
        String letraPuntoDigito2 = "abcde.1234jd.6tjuk.000";

        Pattern patronLetPuntoDigito2 = Pattern.compile("(\\w+[.](\\d+))");
        Matcher macheadorLetPuntoDig2 = patronLetPuntoDigito2.matcher(letraPuntoDigito2);
       // System.out.println(macheadorLetPuntoDig2.matches());
       // macheadorLetPuntoDig2.reset();
        while (macheadorLetPuntoDig2.find()){
            System.out.println(macheadorLetPuntoDig2.group(2));
        }

        //Ejercicio 8
        System.out.println("Ejercicio 8");
        String letraPuntoDigitoTab = "abcde.1234\tjd.6\tjuk.000\n";

        Pattern patronLetPuntoDigitoTab = Pattern.compile("(([a-z]+)([\\.])([0-9]+)([\t\n]))+?");
        Matcher macheadorLetPuntoDigTab = patronLetPuntoDigitoTab.matcher(letraPuntoDigitoTab);
        while (macheadorLetPuntoDigTab.find()){
            System.out.println(macheadorLetPuntoDigTab.group(4));
        }

        //Ejercicio 9
        System.out.println("Ejercicio 9");
        String textoIndices = "abcde.1234\tjd.6\tjuk.000\n";
        int i = 0;
        Pattern patronTextoIndices = Pattern.compile("(([a-z]+)([\\.])([0-9]+)([\t\n]))+?");
        Matcher macheadorTextoIndices = patronTextoIndices.matcher(textoIndices);
        while (macheadorTextoIndices.find()){
            i++;
            System.out.println("Coincidencia " + i + " en posición"
                    + macheadorTextoIndices.start() + " hasta " + macheadorTextoIndices.end()
            );
            System.out.println(macheadorTextoIndices.group(4));
        }

//Ejercicio 10
        System.out.println("Ejercicio 10");
        String puntos = "{0,2},{1,5},{2,3},{3,4}";
        Pattern patron10 = Pattern.compile("([{]([0-9],[0-9])[}][,*])+?");
        Matcher macheadorPatron10 = patron10.matcher(puntos);

while (macheadorPatron10.find()){
    System.out.println(macheadorPatron10.group(2));
}

// Ejercicio 11
        System.out.println("Ejercicio 11");
        String cpBcn = "08020";
        System.out.println(cpBcn.matches("\\d{5}"));

// Ejercicio 12
        System.out.println("Ejercicio 12");
        String creditCard = "2233 5555 6565 7888 232";
        System.out.println(creditCard.matches("(\\d{4}([ ]*)){4}(\\d{3})"));

        // Ejercicio 13
        System.out.println("Ejercicio 13");
        String email = "test2@gmail.com";
        System.out.println(email.matches("((\\d|\\w)*)[@](\\w*).(\\w*)"));

        //main
    }
    //class
}
