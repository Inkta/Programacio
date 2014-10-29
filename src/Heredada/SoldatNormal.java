package Heredada;
import java.awt.Image;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class SoldatNormal extends Soldat{
	public SoldatNormal(String a, String a2, int b, boolean c, int d, double[] e) {
		super (a,a2,b,c,d,e);
	}

	public boolean Moure(){
		if (!mov) {
			if (direccio) {
				this.getImatge().move(5, 0);
				return true;
			} else {
				this.getImatge().move(-5, 0);
				return true;
			}
		} else {
			return false;
		}
	}

	public void GiraImatge(){

	}

}
