package Main;

import java.awt.Dimension;

import javax.swing.JFrame;


public class Tetris {

    public static Scene scene;

    public final static int TAILLE = 25;
    public final static int TAILLE_X_GRILLE = 10;
    public final static int TAILLE_Y_GRILLE = 21;
    public final static int TAILLE_X_MAX = TAILLE_X_GRILLE * TAILLE;
    public final static int TAILLE_Y_MAX = TAILLE_Y_GRILLE * TAILLE;

    public static int [][] grille = new int [TAILLE_X_GRILLE][TAILLE_Y_GRILLE];

	public static void main(String[] args) {

        JFrame fenetre = new JFrame("Tetris");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);

        scene = new Scene();
        scene.setPreferredSize(new Dimension(TAILLE_X_MAX,TAILLE_Y_MAX));
        fenetre.setContentPane(scene);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }

}