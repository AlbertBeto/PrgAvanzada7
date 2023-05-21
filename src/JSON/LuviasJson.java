package JSON;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LuviasJson {

    public static String weatherJson(String url){
//https://api.tutiempo.net/json/?lan=es&apid=45EaXXaaaX4ggap&ll=38.267211910,-0.695218980
        try(InputStream input = new URL(url).openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader bf = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            int c;
            while((c = bf.read()) !=-1){
                sb.append((char)c);
            }
            return sb.toString();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) {
        try {
        Scanner sc = new Scanner(System.in);

        System.out.println("Longitud Elche: 38,267211910");
        System.out.println("Latitud Elche: -0,695218980");
        System.out.println("Longitud Barcelona: 2,1746589914");
        System.out.println("Latitud Barcelona: 41,3948528939");
        System.out.println("La API da error cuando le pasas coordenadas que no sean las de Elche, ????");
/*
        Double longitud = 38.267211910;
        Double latitud = -0.695218980;
*/
            Double longitud=0.0;
            Double latitud=0.0;


            //Este módulo es para confirmar el orden de los argumentos de entrada
            if (args[0].equals("-lon")){
                longitud = Double.parseDouble(args[1]);
                latitud = Double.parseDouble(args[3]);
            } else if (args[0].equals("-lat")) {
                longitud = Double.parseDouble(args[3]);
                latitud = Double.parseDouble(args[1]);
            } else{
                System.out.println("Ha introducido erroneamente los argumentos. Vuelva a intentarlo");
            }


            /*  //Este modulo es para introducir manualmente la longitud y la latitud
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca Longitud:");
        longitud= sc.nextDouble();
        System.out.println("Introduzca Latitud:");
        latitud= sc.nextDouble();
*/
        System.out.println("Que día de la semana quieres saber?");
        int diaVer;
        diaVer = sc.nextInt()-1;
        String url = "https://api.tutiempo.net/json/?lan=es&apid=45EaXXaaaX4ggap&ll="+longitud+","+latitud;
        String json = weatherJson(url);

        JSONObject jsonObject = new JSONObject(json);

        ArrayList<Dia> arraySemanaTemp = new ArrayList<>();
        for (int i = 1; i<8 ; i++){
            String diaNumero = "day"+i;
            JSONObject lolo = jsonObject.getJSONObject(diaNumero);
            Dia diaObj = new Dia(diaNumero,lolo.getInt("temperature_max"), lolo.getInt("temperature_min"),lolo.getString("text"));
            arraySemanaTemp.add(diaObj);
            }

           // Semana semanaTemp = new Semana(arraySemanaTemp);
            System.out.println("Dia semana: " + arraySemanaTemp.get(diaVer).getDia());
            System.out.println("Temperatura Maxima: " + arraySemanaTemp.get(diaVer).getTempMax());
            System.out.println("Temperatura Minima: " + arraySemanaTemp.get(diaVer).getTempMin());
            System.out.println("Pronostico: " + arraySemanaTemp.get(diaVer).getText());

            //try
        }
        catch(InputMismatchException | IndexOutOfBoundsException j) {
         System.out.println("Ha introducido un día de la semana erroneo.");
       }


        //main
    }
//class
}
