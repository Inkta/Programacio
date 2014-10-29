package Heredada;

import acm.graphics.GImage;

public class SoldatFort extends Soldat{
	public SoldatFort(GImage a, GImage a2, int b, boolean c, int d, double[] e) {
		super(a,a2,b,c,d,e);
		this.setVida(5);
	}

	public boolean Moure(){
		if (mov) {
			int vel = (int)(Math.random()*2);
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
