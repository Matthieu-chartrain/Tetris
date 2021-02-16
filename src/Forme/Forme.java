package Forme;

import Main.Point;
import Main.Tetris;


public abstract class Forme {
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	private int couleur;
	private int etatForme;
	
	public Forme(Point a, Point b, Point c, Point d, int  couleur) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.couleur = couleur;
		this.etatForme = 1;
	}
	
	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getC() {
		return c;
	}

	public Point getD() {
		return d;
	}

	public int getCouleur() {
		return couleur;
	}
	
	public abstract void descendre(int vitesse);
	
	public abstract void miseForme1();
	public abstract void miseForme2();
	public abstract void miseForme3();
	public abstract void miseForme4();
	
	public void tomber() {
		this.a.setY(this.a.getY()+Tetris.TAILLE);
		this.b.setY(this.b.getY()+Tetris.TAILLE);
		this.c.setY(this.c.getY()+Tetris.TAILLE);
		this.d.setY(this.d.getY()+Tetris.TAILLE);
	}
	
	private boolean peutDesendre(Point p) {
        int xi = p.getX() / Tetris.TAILLE;
        int yi = p.getY() / Tetris.TAILLE;
        return Tetris.grille[0].length != yi + 1 && Tetris.grille[xi][yi + 1] == 0;
    }

    public boolean collisionBas() {
        return !(this.peutDesendre(a) && this.peutDesendre(b) && this.peutDesendre(c) && this.peutDesendre(d));
    }
    
    private boolean peutGauche(Point p) {
    	int xi = p.getX() / Tetris.TAILLE;
    	int yi = p.getY() / Tetris.TAILLE;
    	return (xi != 0 && Tetris.grille[xi - 1][yi] == 0);
    }
    public boolean collisionGauche() {
    	return !(this.peutGauche(a) && this.peutGauche(b) && this.peutGauche(c) && this.peutGauche(d));
    }
    
    public void allerGauche() {
    	if (!(collisionGauche())){
    		this.a.setX(this.a.getX()-Tetris.TAILLE);
    		this.b.setX(this.b.getX()-Tetris.TAILLE);
    		this.c.setX(this.c.getX()-Tetris.TAILLE);
    		this.d.setX(this.d.getX()-Tetris.TAILLE);
    	}
    }
    
    private boolean peutDroite(Point p) {
    	int xi = p.getX() / Tetris.TAILLE;
    	int yi = p.getY() / Tetris.TAILLE;
    	return (xi != Tetris.TAILLE_X_GRILLE-1 && Tetris.grille[xi + 1][yi] == 0);
    }
    public boolean collisionDroite() {
    	return !(this.peutDroite(a) && this.peutDroite(b) && this.peutDroite(c) && this.peutDroite(d));
    }
    
    public void allerDroite() {
    	if (!(collisionDroite())){
    		this.a.setX(this.a.getX()+Tetris.TAILLE);
    		this.b.setX(this.b.getX()+Tetris.TAILLE);
    		this.c.setX(this.c.getX()+Tetris.TAILLE);
    		this.d.setX(this.d.getX()+Tetris.TAILLE);
    	}
    }
    
	public void tournerDroite() {
		this.etatForme += 1;
		if (etatForme == 5) {
			etatForme = 1;
		}
		this.miseEnForme();
		if (this.collisionPivot()) {
			this.tournerGauche();
			if (!(collisionDroite())){
				this.allerDroite();
				this.etatForme += 1;
				if (etatForme == 5) {
					etatForme = 1;
				}
				this.miseEnForme();
				if (this.collisionPivot()) {
					this.tournerGauche();
					this.allerGauche();
				}
			}
			else if (!(collisionGauche())){
				this.allerGauche();
				this.etatForme += 1;
				if (etatForme == 5) {
					etatForme = 1;
				}
				this.miseEnForme();
				if (this.collisionPivot()) {
					this.tournerGauche();
					this.allerDroite();
				}
			}
		}
	}
	
	public void tournerGauche() {
		this.etatForme -= 1;
		if (etatForme == 0) {
			etatForme = 4;
		}
		this.miseEnForme();
		if (this.collisionPivot()) {
			this.tournerDroite();
			if (!(collisionGauche())){
				this.allerGauche();
				this.etatForme -= 1;
				if (etatForme == 0) {
					etatForme = 4;
				}
				this.miseEnForme();
				if (this.collisionPivot()) {
					this.tournerDroite();
					this.allerDroite();
				}
			}
			else if (!(collisionDroite())){
				this.allerDroite();
				this.etatForme -= 1;
				if (etatForme == 0) {
					etatForme = 4;
				}
				this.miseEnForme();
				if (this.collisionPivot()) {
					this.tournerDroite();
					this.allerGauche();
				}
			}
		}
	}
	
	private void miseEnForme() {
		switch (this.etatForme) {
		case 1 : this.miseForme1();
		break;
		case 2 : this.miseForme2();
		break;
		case 3 : this.miseForme3();
		break;
		case 4 : this.miseForme4();
		break;
		default : this.miseForme1();
		break;
		}
	}
    
    public boolean collisionPivot() {
    	return (this.echecPlacementCarre(a) || this.echecPlacementCarre(b) ||
    			this.echecPlacementCarre(c) || this.echecPlacementCarre(d));
    }
    
    private boolean echecPlacementCarre(Point p) {
    	int xi = p.getX() / Tetris.TAILLE;
    	int yi = p.getY() / Tetris.TAILLE;
    	return ((p.getX()< 0) || (p.getX() >= Tetris.TAILLE_X_MAX) || 
    			(p.getY() < 0 || p.getY() >= Tetris.TAILLE_Y_MAX) || (Tetris.grille[xi][yi] != 0));
    }
}