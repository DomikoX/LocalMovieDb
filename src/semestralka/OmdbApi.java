/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DomikoX
 */
public class OmdbApi {

    private static final String URL ="http://www.omdbapi.com/?";;
    private static final String TITLE = "t=";
    private static final String SEARCH = "s=";
    private static final String ID = "i=";
    
    /**
     *
     * @param title Tittle of movie used to find 
     * @return JsonObject witch contain result of searching
     */
    public static JsonObject findByTitle(String title){
        return find(TITLE, title);
        
    }
    
    /**
     *
     * @param id imdbID  of movie  used to find 
     * @return JsonObject witch contain result of searching
     */
    public static  JsonObject findById(String id){
        return find(ID,id);
    }
    
    /**
     *
     * @param search search phrase to used to find
     * @return JsonObject witch contain result of searching
     */
    public static JsonObject findBySearch(String search){
        return find(SEARCH, search);
    }
    
    private static JsonObject  find(String type, String param){
        try {
            String finalURl = URL+type+prepareString(param);
            return new JsonParser().parse(readUrl(finalURl)).getAsJsonObject();          
            
        } catch (Exception ex) {
            Logger.getLogger(OmdbApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static  String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read); 

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }

    }
    
    private static  String prepareString(String str){
        String s = str.trim().replaceAll(" ", "+");
        
        return s;
    }

}
