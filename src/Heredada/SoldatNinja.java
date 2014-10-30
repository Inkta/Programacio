package Heredada;

import java.util.ArrayList;

import acm.graphics.GImage;

public class SoldatNinja extends Soldat {
	int disparador = 0;
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


	public void ComprovaMort(Soldat a, double b, joc pantalla){
		if (a.getImatge().getBounds().intersects(this.getImatge().getBounds())) {
			this.restarVida();
		}
	}

	public void Dispara(double[] a, ArrayList<Soldat> b) {
		if (disparador < 3) {
			disparador++;
			b.add(new Estrella (new GImage(""),new GImage(""),0, true, 0,a,10,1));
		}

	}

}
