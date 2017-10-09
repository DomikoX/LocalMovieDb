/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import semestralka.Movie;
import semestralka.MovieRecord;
import semestralka.OmdbApi;

/**
 *
 * @author DomikoX
 */
public class MovieDetailSearchWindow extends javax.swing.JFrame {

    private MovieRecord movieRec;
    private JsonObject selectedMovie;
    private BufferedImage image;
    private final String root;
    private int i;

    /**
     * Creates new form MovieDetailSearchWindow
     *
     * @param m Movie data will be assign to this Movierecord
     * @param root Working directory path
     */
    public MovieDetailSearchWindow(MovieRecord m, String root) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.movieRec = m;
        this.i = 0;
        this.root = root;

        jLabelFile.setText(movieRec.getFilename());
        tryFind();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabelFile = new javax.swing.JLabel();
        jTextFieldFind = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEmpty = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find movie");

        jButton1.setText("Try Find another");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Select this Movie");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabelFile.setText("jLabel3");

        jButton3.setText("I'll try");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose witch one is your movie (or try find it)");

        jButtonEmpty.setText("Left empty");
        jButtonEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmptyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabelFile)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEmpty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButtonEmpty))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tryFind();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tryFind(String findText) {
        new Thread() {
            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.

                JsonObject o = OmdbApi.findBySearch(findText);
                ArrayList<JsonObject> list = new ArrayList<>();

                if (o.get("Response").getAsBoolean()) {

                    for (JsonElement g : o.get("Search").getAsJsonArray()) {
                        list.add(g.getAsJsonObject());
                    }
                    jTable1.setModel(new SearchMovieTableModel(list));
                }

            }

        }.start();

    }

    private void tryFind() {
        if (i >= movieRec.getNameTips().size() - 1) {
            i = 0;
        }
        tryFind(movieRec.getNameTips().get(i++));

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton2.setEnabled(true);
        selectedMovie = ((SearchMovieTableModel) jTable1.getModel()).getMovies().get(jTable1.getSelectedRow());
        image = null;
        new Thread() {

            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.

                try {
                    URL url = new URL(selectedMovie.get("Poster").getAsString());
                    image = ImageIO.read(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                jLabel2.setIcon(new ImageIcon(image));
                jLabel2.repaint();
            }
        }.start();


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Thread() {

            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.

                JsonObject o = OmdbApi.findById(selectedMovie.get("imdbID").getAsString());
                movieRec.setMovie(o);
                movieRec.markAsMatch();
                File n = new File(root, "_posters");
                if (!n.exists()) {
                    n.mkdir();
                }
                File i = new File(n, movieRec.getMovie().getTitle() + ".png");

                try {
                    ImageIO.write(image, "png", i);
                } catch (IOException ex) {
                    Logger.getLogger(MovieDetailSearchWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }.start();
        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String find = jTextFieldFind.getText();
        if (find.isEmpty()) {
            JOptionPane.showMessageDialog(this, "i dont know what to find !! :(");
            return;
        }
        tryFind(find);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmptyActionPerformed
        Movie m = null;
        movieRec.setMovie(m);
        movieRec.markAsMatch();
        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object
    }//GEN-LAST:event_jButtonEmptyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonEmpty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldFind;
    // End of variables declaration//GEN-END:variables

    private class SearchMovieTableModel extends AbstractTableModel {

        private ArrayList<JsonObject> movies;
        private String[] columns;

        public SearchMovieTableModel(ArrayList<JsonObject> movies) {

            super();
            this.movies = movies;
            columns = new String[]{"Title", "Year", "Type"};
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
            JsonObject m = getMovies().get(row);
            switch (col) {
                case 0:
                    return m.get("Title").getAsString();
                case 1:
                    return m.get("Year").getAsString();
                case 2:
                    return m.get("Type").getAsString();
                default:
                    return null;
            }
        }

        // Optional, the name of your column
        public String getColumnName(int col) {
            return columns[col];
        }

        public void addRow(JsonObject m) {
            getMovies().add(m);
            fireTableRowsInserted(getMovies().size() - 1, getMovies().size() - 1);
        }

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
        public ArrayList<JsonObject> getMovies() {
            return movies;
        }

    }

}
