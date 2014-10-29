package Heredada;

import acm.graphics.GImage;

public class SoldatNinja extends Soldat {
	boolean invisible = true;
	public SoldatNinja(GImage a, GImage a2, int b, boolean c, int d, double[] e) {
		super (a,a2,b,c,d,e);
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
			return true;
	}
		return true;
	}
}
