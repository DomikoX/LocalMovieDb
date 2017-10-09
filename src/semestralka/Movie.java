/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;

/**
 * Class represent movie and all information about it
 * @author DomikoX
 */
public class Movie {
    private String imdbID;
    private String title;
    private String year;
    private String runtime;
    private ArrayList<String> genre;
    private String director;
    private ArrayList<String> actors;
    private String plot;
    private String country;
    private String poster;
    private float  imdbRating;

    /**
     *
     * @param o JsonObject containig all necesary data
     */
    public Movie(JsonObject o) {
        this.imdbID = o.get("imdbID").getAsString();
        this.title = o.get("Title").getAsString();
        this.year = o.get("Year").getAsString();
        this.runtime = o.get("Runtime").getAsString();
        this.genre =  new ArrayList<String>();
        for (String s : o.get("Genre").getAsString().split(",")) {
            genre.add(s);
        }
        this.director = o.get("Director").getAsString();
        this.actors =  new ArrayList<String>();
        for (String s : o.get("Actors").getAsString().split(",")) {
            actors.add(s);
        }
        this.plot = o.get("Plot").getAsString();
        this.country = o.get("Country").getAsString();
        this.poster = o.get("Poster").getAsString();
        this.imdbRating = o.get("imdbRating").getAsFloat();
        
    }
    
    

    
    
    
    
    /**
     * @return the imdbID
     */
    public String getImdbID() {
        return imdbID;
    }

    /**
     * @param imdbID the imdbID to set
     */
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the runtime
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * @param runtime the runtime to set
     */
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    /**
     * @return the arraylist of  genres
     */
    public ArrayList<String> getGenre() {
        return genre;
    }

    /**
     *
     * @return genres in one string
     */
    public String getGenresInOneString(){
        String ret = "";
        for (String g : genre) {
            ret += g + ", ";
        }
        return  ret;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the  arraylist of actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     *
     * @return Actors in one string
     */
    public String getActorsInOneString(){
        String ret = "";
        for (String g : actors) {
            ret += g + ", ";
        }
        return  ret;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return the plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     * @param plot the plot to set
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster the poster to set
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return the imdbRating
     */
    public float getImdbRating() {
        return imdbRating;
    }

    /**
     * @param imdbRating the imdbRating to set
     */
    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }
    
    
}
