/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralka;

import com.google.gson.JsonObject;
import java.awt.Component;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author DomikoX
 */
public class FinderWorker extends SwingWorker {

    private MovieLib movLib;
    private final Component c;
    private final JLabel loading;
    private final boolean toAll;

    /**
     *  This method try find movie data to all records in movLib
     * @param movLib MovieLib which contain list of MoviRecords
     * @param c Component for showing JOptionPanel
     * @param loading Jlable which show loading 
     * @param toAll indicate if all record should be reassign or just the unconfirmed ones
     */
    public FinderWorker(MovieLib movLib, Component c, JLabel loading, boolean toAll) {
        this.movLib = movLib;
        this.c = c;
        this.loading = loading;
        this.toAll = toAll;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (MovieRecord m : movLib.getMovies()) {

            if (!toAll && (m.haveAllData() || m.getMatch()))continue;

            try {
                String firt = m.getNameTips().get(0);
                JsonObject o = OmdbApi.findBySearch(firt);
                if (o.get("Response").getAsBoolean()) {

                    JsonObject ooo = OmdbApi.findById(o.get("Search").getAsJsonArray().get(0).getAsJsonObject().get("imdbID").getAsString());
                    m.setMovie(ooo);
                    m.unMark();

                }

            } catch (Exception e) {
            }

        }
        publish(null);

        return null;
    }

    @Override
    protected void process(List chunks) {
        super.process(chunks); //To change body of generated methods, choose Tools | Templates.
        movLib.getmTableModel().fireTableDataChanged();
    }

    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
        movLib.getmTableModel().fireTableDataChanged();
        loading.setVisible(false);
        JOptionPane.showMessageDialog(c, "Everything is up to date");

    }

}
