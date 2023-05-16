package IN_OUT;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.IntStream;

public class json {

    public static String downloadJson(String url){
//https://catfact.ninja/facts
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
String url = "https://catfact.ninja/facts";
String json = downloadJson(url);

        JSONObject jsonObject = new JSONObject(json);
        JSONArray array = jsonObject.getJSONArray("data");


        JSONObject fact0 = array.getJSONObject(0);
        System.out.println(fact0.getString("fact"));
        System.out.println(fact0.getInt("length"));

        // Aqui repasamos
        for (int i = 0; i < array.length(); i++){
            JSONObject o = array.getJSONObject(i);
            System.out.println(o.getString("fact"));
            System.out.println(o.getInt("length"));
        }


        System.out.println((jsonObject.getJSONArray("links")).getJSONObject(14).getString("label"));
        //main
    }



    //class
}
