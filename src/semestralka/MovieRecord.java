/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Objects;

/**
 *Class respresent  movie fiel on disk and Movie class asigned to it 
 * @author DomikoX
 */
public class MovieRecord {

    private String filePath;
    private Movie movie;
    private boolean match;

    /**
     *
     * @param filePath path to movie file
     */
    public MovieRecord(String filePath) {
        this.match = false;
        this.movie = null;
        this.filePath = filePath;
    }

    /**
     *
     * @param filePath path to movie record
     * @param movie movie data about this movie
     */
    public MovieRecord(String filePath, Movie movie) {
        this.filePath = filePath;
        this.movie = movie;
    }

    /**
     *
     * @param o Json object containig all information about movie
     */
    public void setMovie(JsonObject o) {
        this.setMovie(new Movie(o));
    }

    /**
     * Set attribute match to true
     */
    public void markAsMatch() {
        this.match = true;
    }

    /**
     * Set attribute match to false
     */
    public void unMark() {
        this.match = false;
    }

    /**
     *
     * @return return true if user check movie data as good
     */
    public boolean getMatch() {
        return this.match;
    }

    /**
     *
     * @return true if this movie file have assigned Movie data
     */
    public boolean haveAllData() {
        return this.getMovie() != null;
    }

    /**
     *
     * @return Arraylist of strings  which should be used for find the right movie data
     */
    public ArrayList<String> getNameTips() {
        String name = getFilePath().substring(getFilePath().lastIndexOf('\\') + 1);
        name = name.replaceAll("-", ".");
        name = name.replaceAll(" ", ".");
        ArrayList<String> ret = new ArrayList<>();
        String findString = "";
        for (String s : name.split("\\.")) {
            findString += s + " ";
            ret.add(findString);
        }
        if (ret.size() == 0) {
            return ret;
        }
        String pom = ret.get(0).toLowerCase().trim();
        if (pom.equals("a") || pom.equals("the")) {
            ret.remove(0);
        }
        return ret;
    }

    /**
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     *
     * @return name of the movie file 
     */
    public String getFilename() {
        return getFilePath().substring(getFilePath().lastIndexOf('\\') + 1);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getFilePath());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieRecord other = (MovieRecord) obj;
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        return true;
    }

    /**
     * @param movie the movie to set
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

}
