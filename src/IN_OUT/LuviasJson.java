package IN_OUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

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

        String url = "https://api.tutiempo.net/json/?lan=es&apid=45EaXXaaaX4ggap&ll=38.267211910,-0.695218980";
        String json = weatherJson(url);

        System.out.println(json);

        Dia uno = new Dia()

        //main
    }
//class
}
