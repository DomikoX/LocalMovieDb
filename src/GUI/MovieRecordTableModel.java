/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import semestralka.MovieRecord;

/**
 *
 * @author DomikoX
 */
public class MovieRecordTableModel extends AbstractTableModel {

    private ArrayList<MovieRecord> movies;
    private String[] columns;

    /**
     *Table Model witch contains MovieRocords
     * @param movies List of MovieRecord to show  in table 
     */
    public MovieRecordTableModel(ArrayList<MovieRecord> movies) {

        super();
        this.movies = movies;
        columns = new String[]{"Title", "Year", "Genres", "Correct"};
    }

   

    // Number of column of your table
    public int getColumnCount() {
        return columns.length;
    }

    // Number of row of your table
    public int getRowCount() {
        return getMovies().size();
    }

    // The object to render in a cell
    public Object getValueAt(int row, int col) {
        MovieRecord m = getMovies().get(row);
        switch (col) {
            case 0:
                return m.haveAllData() ? m.getMovie().getTitle() : m.getFilename();
            case 1:
                return m.haveAllData() ? m.getMovie().getYear() : "-";
            case 2:
                return m.haveAllData() ? m.getMovie().getGenresInOneString() : "-";
            case 3:
                return m.haveAllData() ?  (m.getMatch()? "YES" : "UNCONFIRMED") : "NO";
            default:
                return null;
        }
    }

    // Optional, the name of your column
    public String getColumnName(int col) {
        return columns[col];
    }

    /**
     *
     * @param m Movie record to add
     */
    public void addRow(MovieRecord m) {
        getMovies().add(m);
        fireTableRowsInserted(getMovies().size() - 1, getMovies().size() - 1);
    }

    /**
     *
     * @param rowIndex index of row which will be deleted
     */
    public void deleteRow(int rowIndex) {
        if ((rowIndex < 0) | (rowIndex > getMovies().size())) {
            JOptionPane.showMessageDialog(null, "Vyber riadok z tabulky!", "Chyba", JOptionPane.ERROR_MESSAGE);
        } else {
            getMovies().remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    /**
     * @return the movies
     */
    public ArrayList<MovieRecord> getMovies() {
        return movies;
    }

}
