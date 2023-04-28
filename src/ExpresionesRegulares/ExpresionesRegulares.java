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



}

        //main
    }


    //class
}
