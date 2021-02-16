package Main;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Forme.Barre;
import Forme.Forme;
import Forme.Carre;
import Forme.FormeT;
import Forme.LInverse;
import Forme.FormeS;
import Forme.FormeZ;
import Forme.FormeL;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	Forme forme1;
	int k;

	int score = 0;
	public final Point pointInitial = new Point(Tetris.TAILLE*5, Tetris.TAILLE);
	
    public Scene() {
        super();
        this.reset();
        System.out.println("\n\n\nScore : " + score);
        k = 0;
        forme1 = this.nouvellePiece();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());
        
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    private void reset() {
        for (int i=0; i<Tetris.grille.length;i++) {
            for (int j = 0; j<Tetris.grille[0].length;j++) {
                Tetris.grille[i][j]= 0;
            }
        }
    }
    
    public Forme nouvellePiece() {
    	int random;
    	Forme f;
    	random = (int) (Math.random() * 7) + 1;
    	switch (random) {
    	case 1 : f = new Barre(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // barre
    	break;
    	case 2 : f = new Carre(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // carre
    	break;
    	case 3 : f = new FormeZ(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // Z
    	break;
    	case 4 : f = new FormeS(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // S
    	break;
    	case 5 : f = new FormeL(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // L
    	break;
    	case 6 : f = new LInverse(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // L inversé
    	break;
    	case 7 : f = new FormeT(new Point(Tetris.TAILLE*5, Tetris.TAILLE)); // T
    	break;
    	default : f = new Barre(new Point(Tetris.TAILLE*5, Tetris.TAILLE));
    	break;
    	}
    	return f;
    }
    
    public void figerPiece(Forme f) {
    	Tetris.grille[forme1.getA().getX()/Tetris.TAILLE][forme1.getA().getY()/Tetris.TAILLE] = f.getCouleur();
    	Tetris.grille[forme1.getB().getX()/Tetris.TAILLE][forme1.getB().getY()/Tetris.TAILLE] = f.getCouleur();
    	Tetris.grille[forme1.getC().getX()/Tetris.TAILLE][forme1.getC().getY()/Tetris.TAILLE] = f.getCouleur();
    	Tetris.grille[forme1.getD().getX()/Tetris.TAILLE][forme1.getD().getY()/Tetris.TAILLE] = f.getCouleur();
    }
    
    public Color couleur (int c) {
    	Color couleur;
    	switch(c) {
    	case 0 : couleur = Color.white; // vide
    	break;
    	case 1 : couleur = Color.cyan; // barre
    	break;
    	case 2 : couleur = Color.yellow; // carre
    	break;
    	case 3 : couleur = Color.red; // Z
    	break;
    	case 4 : couleur = Color.green; // S
    	break;
    	case 5 : couleur = Color.blue; // L
    	break;
    	case 6 : couleur = Color.orange; // L inversé
    	break;
    	case 7 : couleur = Color.magenta; // T
    	break;
    	case 8 : couleur = Color.black;
    	break;
    	default : couleur = Color.white;
    	break;
    	}
    	return couleur;
    }
    
    
    private void viderLigne() {
    	boolean lignePleine = true;
    	boolean nouveauScore = false;
    	for (int i = 0 ; i<Tetris.grille[0].length; i++) {
    		lignePleine = true;
            for (int j = 0; j< Tetris.grille.length ; j++) {
            	if (Tetris.grille[j][i] == 0) {
            		lignePleine = false;
            	}
            }
            if (lignePleine == true) {
            	nouveauScore = true;
            	score = score + 10;
            	for (int j = 0; j<Tetris.grille.length;j++) {
            		for (int k = i ; k > 0; k--) {
            			Tetris.grille[j][k] = Tetris.grille[j][k-1];
            		}
                }
            }
        }
    	if (nouveauScore == true) {
    		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    		System.out.println("Score : " + score);
    	}
    }
    
    
    public boolean defaite (Forme f) {
    	return (Tetris.grille[f.getA().getX()/Tetris.TAILLE][f.getA().getY()/Tetris.TAILLE]) != 0
    		|| (Tetris.grille[f.getB().getX()/Tetris.TAILLE][f.getB().getY()/Tetris.TAILLE]) != 0
    		|| (Tetris.grille[f.getC().getX()/Tetris.TAILLE][f.getC().getY()/Tetris.TAILLE]) != 0
    		|| (Tetris.grille[f.getD().getX()/Tetris.TAILLE][f.getD().getY()/Tetris.TAILLE]) != 0;
    	
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        Scanner pause = new Scanner(System.in);
        g2.setColor(this.couleur(this.forme1.getCouleur()));
        g2.fillRect((int)forme1.getA().getX(), (int)forme1.getA().getY(), Tetris.TAILLE, Tetris.TAILLE);
        g2.fillRect((int)forme1.getB().getX(), (int)forme1.getB().getY(), Tetris.TAILLE, Tetris.TAILLE);
        g2.fillRect((int)forme1.getC().getX(), (int)forme1.getC().getY(), Tetris.TAILLE, Tetris.TAILLE);
        g2.fillRect((int)forme1.getD().getX(), (int)forme1.getD().getY(), Tetris.TAILLE, Tetris.TAILLE);
        
        for (int i=0; i<Tetris.grille.length;i++) {
            for (int j = 0; j<Tetris.grille[0].length;j++) {
            	g2.setColor(this.couleur(Tetris.grille[i][j]));
                if(Tetris.grille[i][j] != 0) {
                	g2.fillRect(i*Tetris.TAILLE, j*Tetris.TAILLE, Tetris.TAILLE, Tetris.TAILLE);
                }
                g2.setColor(Color.lightGray);
                g2.drawRect(i*Tetris.TAILLE, j*Tetris.TAILLE, Tetris.TAILLE, Tetris.TAILLE);
            }
        }
        if (k > 20) {
        	if (!(forme1.collisionBas())){
            	this.forme1.tomber();	
            }
            else {
            	figerPiece(forme1);
            	this.viderLigne();
            	forme1 = this.nouvellePiece();
            }
        	k = 0;
        }
        
        if (this.defaite(forme1)) {
        	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        	System.out.println("Game Over");
        	System.out.println("Score final : " + score);
        	System.out.println("appuyer sur entrée pour quitter");
        	pause.nextLine();
        	pause.close();
        	System.exit(0);
        }
        else {
        	k++;
        }
    }
}