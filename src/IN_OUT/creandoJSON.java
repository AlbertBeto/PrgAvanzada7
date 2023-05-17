package IN_OUT;

import org.json.JSONArray;
import org.json.JSONObject;

public class creandoJSON {

    public static void main(String[] args) {
        //Bloque results

        JSONArray synonyms = new JSONArray();
        synonyms.put("examination");
        synonyms.put("test");

        JSONObject resultsObj1 = new JSONObject();
       resultsObj1.put("definition","a set of questions or exercises evaluating skill or knowledge");
       resultsObj1.put("partOfSpeech", "noun");
       resultsObj1.put("synonyms",synonyms);

        //Bloque syllables

        JSONArray list = new JSONArray();
        list.put("ex");
        list.put("am");

        JSONObject syllablesObj = new JSONObject();
        syllablesObj.put("count", "2");
        syllablesObj.put("list", list);

        JSONArray results = new JSONArray();
        results.put(resultsObj1);

        JSONObject json1 = new JSONObject();

        json1.put("word", "exam");
        json1.put("results", results);
        json1.put("syllables",syllablesObj);

        System.out.println(json1.toString());

        //****************** Ejercicio 2 **************************
        System.out.println("****************** Ejercicio 2 **************************");






                //main
    }
    //class
}
