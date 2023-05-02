package ExpresionesRegulares;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {

    public static void main(String[] args) {
        String texto = "Él compra patatas";
        System.out.println(texto.replaceAll("Él","Ella"));

String a = "abcDeeeT67uuiiiijjj83";

        System.out.println(a.replaceAll(".?","Z"));
        //cambiar un aparte
        System.out.println(a.replaceAll("^abcDeee","JAVA"));
        System.out.println(a.replaceAll("[abe]","X"));
        System.out.println(a.replaceAll("[ace][TD]","X"));
        System.out.println(a.replaceAll("[uj]{2}iii","X"));
        System.out.println(a.replaceAll("[^abcdeuij]","X"));
        String b  = "hola texto hola";

        System.out.println(b.replaceAll("^hola","ei"));
        System.out.println(b.replaceAll("hola$","ei"));

        String c = "aabbccddaa";
        System.out.println(c.matches("aa$"));//false
        System.out.println(c.matches("^aa"));//false
        System.out.println(c.matches(".aa$"));//false
        System.out.println(c.matches("^a.*a$"));//true
        System.out.println(c.matches(".*a$"));//true
        System.out.println(c.matches("[a-z]{10}"));//true

        String f = "abcDeeFG345jjj9";
        System.out.println(f.replaceAll("[abcdef345678]", "o"));
        System.out.println(f.replaceAll("[a-f3-8]", "o"));
        System.out.println(f.replaceAll("(?i)[a-f3-8]", "o")); //Para afectar mays and mins
        //REmplazar todos los digits
        System.out.println(f.replaceAll("[0-9]", "o"));
        System.out.println(f.replaceAll("[\\d]", "o"));
        //lo que no es digito
        System.out.println(f.replaceAll("\\D", "o"));

        String g = "Tenemos tabulacion\t y salto de linea\n";
        System.out.println(g.replaceAll("[\t\n]",""));
            System.out.println(g.replaceAll("[\\s]","")); //Todo lo que sea con \ fuera
            System.out.println(g.replaceAll("[\\S]","")); //Todo lo que no sean /algo fuera
            //Delimitar palabras se usa con <> para crear etiquetas.
            //System.out.println(g.replaceAll("[\\b]","-"));


            // Cuantificadores

            String a2 = "abcDeeeT67uuiiiijjj83";
            //Cada vez que veas 2 una u cambialo por
            System.out.println(a2.replaceAll("u{2}","d"));
            // aparece al menos una vez
            System.out.println(a2.replaceAll("u+","d"));
            // aparece 0 o muchas veces
            System.out.println(a2.replaceAll("u*","d"));
            // aparece entre 1 y 4 veces
            System.out.println(a2.replaceAll("u{1,4}","d"));
            //Que la j aparezca tres veces o mas
            System.out.println(a2.replaceAll("u+i*j{3,}","d"));

            //MATCHES
            String num = "(96) 667-24-42";
            System.out.println(num.matches("\\(96\\)[ ]\\d{3}[-]\\d{2}[-]\\d{2}"));
String texto2 = "Curso 2022-2023";
String rg = " ";
        System.out.println(texto2.matches("^[aA-zZ]{5}[ ][0-9]{4}[-][0-9]{4}"));
        System.out.println(texto2.matches("^\\w{5}[ ]\\d{4}[-]\\d{4}"));


        //PATTERN
        System.out.println("PATTERN..............");
        StringBuilder html = new StringBuilder("<h1>Head</h1>");
        html.append("<h2>Etiqueta h2 de encabezado</h2>");
        html.append("<p>Esto es un parrafo</p>");
        html.append("<h2>Resumen</h2>");
        html.append("<p>Fin de html</p>");

        /*
        Pattern pattern = Pattern.compile(".*<h2>.*");
        Matcher matcher = pattern.matcher(html);
        System.out.println(matcher.matches());

int i = 0;
matcher.reset(); //poner al principio
while(matcher.find()){
    i++;
    System.out.println("Coincidencia " + i + " en posición"
    + matcher.start() + " hasta " + matcher.end()
    );
*/
//con groups
        Pattern pattern = Pattern.compile("(<h2>)(.*?)(</h2>)"); //Desde le primer h2 hasta el ultimo /h2 -- Con el ? hacemos que se quede con el primer match
        Matcher matcher = pattern.matcher(html);
        System.out.println(matcher.matches());

        matcher.reset(); //poner al principio
        while(matcher.find()){

            System.out.println("Coincidencia " + matcher.group(2)); // Con grupo 0 sacaria all de concidencias.

}

        // OR []
        String expre = "He ido al (cine|supermecado)";
        System.out.println("He ido al cine".matches(expre));
        System.out.println("pablo".matches("[Pp]ablo"));
        System.out.println("Pablo".matches("[Pp]ablo"));
        System.out.println("pablo".matches("(P|p)ablo"));
        System.out.println("Pablo".matches("[P|p]ablo"));

        //and
        System.out.println("pablo".matches("[Pp]abc"));

        //not
        String cd = "crcdctc";
        String expreR = "c[^d]";
        String expreR2 = "c(?!d)"; //Look head Con esto hacemos que compare c y luego puede que no haya nada o que vaya algo que no sea una d
        String expreR22 = "c(?=d)"; // Si quieres todas las ocurrencias de c con d
        Pattern pat = Pattern.compile(expreR);
        Matcher matc = pat.matcher(cd);

        int i = 0;
        while (matcher.find()){
            i++;
            System.out.println("Coincidencia " + i + matc.start() + " " + matc.end());
        }

        System.out.println("*******************************************************************");

// (+35) 677-888-999

        String telefono = "(+35) 677-888-999";
        //String expeTele = "([\\(+])([0-9][0-9])[ ]([0-9]{3})[-]([0-9]{3})[-]([0-9]{3})"; Este es el mio
        String expeTele = "^(\\(\\+\\d{1,4}\\))[ ](\\d{3}[-]\\d{3}[-]\\d{3})$";
        Pattern patronTel = Pattern.compile(expeTele);
        Matcher matchTel = patronTel.matcher(telefono);
        System.out.println(matchTel.matches());

        matchTel.reset();
        while (matchTel.find()){

            System.out.println(matchTel.group(2));
        }

        /*
        int j = 0;
        matcher.reset();
        while (matcher.find()){
            j++;
            System.out.println("Coincidencia " + j + matchTel.start() + " " + matchTel.end());
           // System.out.println("Coincidencia grupo pais" + matchTel.group(2)); // Con grupo 0 sacaria all de concidencias.
        }*/


        //main
    }


    //class
}
