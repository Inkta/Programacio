package Heredada;

import java.util.ArrayList;

import acm.graphics.GImage;

public class SoldatNinja extends Soldat {
	public SoldatNinja(GImage a, GImage a2, int b, boolean c, int d, double[] e, String z) {
		super (a,a2,b,c,d,e,z);
	}

	public boolean Moure(){
		if (mov) {
			int vel = (int)(Math.random()*9);
			if (direccio) {
				if (this.getImatge().getX() < extrems[1]) {
					this.getImatge().move(vel, 0);
					return true;
				}
			} else {
				if (this.getImatge().getX() > extrems[0]) {
					this.getImatge().move(-vel, 0);
					return true;
				}
			}
			return false;
	}
		return false;
	}

	public Bala Dispara() {
		return new Bala(new GImage("estrella.png"),new GImage("estrella.png"),15,this.getDireccio(),1,this.getExtrems(),"bala");
	}


}

