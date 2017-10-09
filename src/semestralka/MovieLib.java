/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import GUI.MovieRecordTableModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;

/**
 *
 * @author DomikoX
 */
public class MovieLib {

    private String root;
    private ArrayList<MovieRecord> movies;
    private MovieRecordTableModel mTableModel;
    private File movieDb;

    /**
     *
     * @param root path to Working directory
     */
    public MovieLib(String root) {
        this.root = root;
        this.movies = new ArrayList<>();
        this.mTableModel = new MovieRecordTableModel(getMovies());
        this.initialize();
    }

    private void initialize() {
        File rootDir = new File(root);
        movieDb = new File(rootDir, "MovieDb.data");

        this.loadAllVideos(rootDir);
        
        if (movieDb.exists()) {
            try {
                tryLoad();
                getmTableModel().fireTableDataChanged();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MovieLib.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MovieLib.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        getmTableModel().fireTableDataChanged();

    }

    private void tryLoad() throws FileNotFoundException, IOException {
        try (Reader reader = new FileReader(movieDb)) {
            Gson gson = new GsonBuilder().create();
            ArrayList<MovieRecord> fromFile = (ArrayList<MovieRecord>) gson.fromJson(reader, new TypeToken<ArrayList<MovieRecord>>(){}.getType());
            for (MovieRecord m : movies) {

                for (MovieRecord ff : fromFile) {
                    if (m.equals(ff)) {
                        m.setMovie(ff.getMovie());
                        if (ff.getMatch()) {
                            m.markAsMatch();
                        }
                        break;
                    }
                }

            }

        }
    }

    /**
     * Method save all MovieRecord into file "MovieDb.data"
     * @throws IOException while creating FileWriter
     */
    public void saveToFile() throws IOException {
        if(movies.isEmpty()) return;

        try (Writer writer = new FileWriter(movieDb)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(movies, writer);

        }

    }

    private void loadAllVideos(File rootDir) {
        for (File f : rootDir.listFiles()) {
            if (f.isDirectory()) {
                loadAllVideos(f);
            } else {
                String name = f.getPath();
                if (name.endsWith("mkv") || name.endsWith("mp4") || name.endsWith("avi")) {
                    movies.add(new MovieRecord(name));
                }
            }
        }
    }

    /**
     * @return the mTableModel
     */
    public MovieRecordTableModel getmTableModel() {
        return mTableModel;
    }

    /**
     * @return the movies
     */
    public ArrayList<MovieRecord> getMovies() {
        return movies;
    }

}
