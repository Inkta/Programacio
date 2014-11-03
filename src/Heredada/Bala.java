package Heredada;

import acm.graphics.GImage;

public class Bala extends Soldat{
	static final int velocitat = 10;

	public Bala(GImage a, GImage a2, int b, boolean c, int d, double[] e, String z) {
		super (a,a2,b,c,d,e,z);
		this.getImatge().setSize(25,25);
	}

	public boolean Moure(){
			if (direccio) {
					this.getImatge().move(this.vel, 0);
			} else {
					this.getImatge().move(-this.vel, 0);
			}
			return true;
	}


	public void ComprovaMort(Soldat a, double b, joc pantalla){
		if (this.getImatge().getBounds().intersects(a.getImatge().getBounds())) {
			a.restarVida();
			this.restarVida();
		}

		if (this.getImatge().getX() < this.extrems[0] || this.getImatge().getX() > this.extrems[1]) {
			this.restarVida();
		}
	}


}
