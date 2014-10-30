package Heredada;

import java.util.ArrayList;

import acm.graphics.GImage;

public class SoldatMag extends Soldat {
	GImage bola = new GImage("fire.png");
	String mag = "SoldatMag";

	public String getMag() {
		return mag;
	}

	public void setMag(String mag) {
		this.mag = mag;
	}

	public SoldatMag(GImage a, GImage a2, int b, boolean c, int d, double[] e) {
		super (a,a2,b,c,d,e);
		bola.setSize(this.mida,this.mida);
	}

	public void ComprovaMort(Soldat a, double b, joc pantalla){
		if (b > 0.99){
			pantalla.add(bola);
			bola.setLocation(a.getImatge().getX(), a.getImatge().getY());
			a.restarVida();
			pantalla.pause(100);
			pantalla.remove(bola);
		}

		if (this.getImatge().getBounds().intersects(a.getImatge().getBounds())) {
			this.restarVida();
		}
	}

}
