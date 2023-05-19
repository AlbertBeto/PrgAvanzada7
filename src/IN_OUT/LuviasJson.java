package IN_OUT;

import org.apache.pdfbox.contentstream.operator.graphics.FillEvenOddRule;
import org.json.JSONArray;
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

        Scanner sc = new Scanner(System.in);

        Double longitud = 38.267211910;
        Double latitud = -0.695218980;
/*
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
        try {
        ArrayList<Dia> arraySemanaTemp = new ArrayList<>();
        for (int i = 1; i<8 ; i++){
            String diaNumero = "day"+i;

            JSONObject lolo = jsonObject.getJSONObject(diaNumero);
            Dia diaObj = new Dia(lolo.getInt("temperature_max"), lolo.getInt("temperature_min"),lolo.getString("text"));
            arraySemanaTemp.add(diaObj);
        }

            Semana semanaTemp = new Semana(arraySemanaTemp);
            System.out.println("Temperatura Maxima: " + arraySemanaTemp.get(diaVer).getTempMax());
            System.out.println("Temperatura Minima: " + arraySemanaTemp.get(diaVer).getTempMin());
            System.out.println("Pronostico: " + arraySemanaTemp.get(diaVer).getText());
        }

        catch(InputMismatchException j) {
            System.out.println("Ha introducido un día de la semana erroneo.");
        }
       catch(IndexOutOfBoundsException d) {
            System.out.println("Te has pasado de número.");
        }

        //main
    }
//class
}
