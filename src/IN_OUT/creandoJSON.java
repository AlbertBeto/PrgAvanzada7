package IN_OUT;

import org.json.JSONArray;
import org.json.JSONObject;

public class creandoJSON {

    public static void main(String[] args) {


        JSONObject json1 = new JSONObject();




                JSONArray synonyms = new JSONArray();
        synonyms.put("examination");
        synonyms.put("test");

        JSONArray list = new JSONArray();
        list.put("ex");
        list.put("am");

        JSONArray results = new JSONArray();
        JSONObject resultsObj1 = new JSONObject("definition","a set of questions or exercises evaluating skill or knowledge");
             JSONObject resultsObj2 = new JSONObject("partOfSpeech", "noun");

       resultsObj1.put("definition","a set of questions or exercises evaluating skill or knowledge");
        results.put(resultsObj2);
        results.put(synonyms);


        JSONObject syllablesObj = new JSONObject();
        syllablesObj.put("aqui va el index", "aqui va el valor");


        System.out.println(results.toString());


                //main
    }
    //class
}
