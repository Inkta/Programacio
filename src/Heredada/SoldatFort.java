package Heredada;

import acm.graphics.GImage;

public class SoldatFort extends Soldat{
	public SoldatFort(GImage a, GImage a2, int b, boolean c, int d, double[] e, String z) {
		super(a,a2,b,c,d,e,z);
		this.setVida(5);
	}

	public boolean Moure(){
		if (mov) {
			int vel = (int)(Math.random()*6);
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
}
