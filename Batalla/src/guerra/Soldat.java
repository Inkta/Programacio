package guerra;
import java.awt.Image;
import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Soldat {
	public static final double mida = 50;
	double[] extrems;
	GImage imatge;
	boolean dret;
	boolean mov = false;

	public Soldat(String a, boolean b, double[] extrems) {
		imatge = new GImage(a);
		imatge.setSize(mida,mida);
		dret = b;
		this.extrems = extrems;
	}

	public double getLloc() {
		if (dret) {
			return extrems[1];
		} else {
			return extrems[0];
		}
	}

	public void setPosicio(double d,double e) {
		imatge.setLocation(d,e);
	}

	public boolean getDireccio() {
		return dret;
	}

	public boolean mata() {
		return false;
	}

	public GImage getImatge() {
		return imatge;
	}

	public void setImatge(GImage imatge) {
		this.imatge = imatge;
	}

	public boolean isDret() {
		return dret;
	}

	public void setDret(boolean dret) {
		this.dret = dret;
	}

	public boolean Moure() {
		int vel = (int)(Math.random()*2);
		if (this.dret) {
			if (fi() && mov) {
				this.getImatge().move(vel, 0);
				return true;
			} else {
				para();
				return false;
			}
		} else {
			if (fi() && mov) {
				this.getImatge().move(-vel, 0);
				return true;
			} else {
				para();
				return false;
			}
		}
	}

	public boolean isMov() {
		return mov;
	}

	public void setMov(boolean mov) {
		this.mov = mov;
	}

	public boolean fi() {
		if (this.dret) {
			if (this.imatge.getX() > extrems[1]) {
				return false;
			}
		} else {
			if (this.imatge.getX() < extrems[0]) {
				return false;
			}
		}

		return true;
	}

	public void para() {
		mov = false;
	}

	public boolean ComprovaMort(Soldat a) {
		if (this.imatge.getBounds().intersects(a.imatge.getBounds())) {
			return true;
		}
		return false;
	}


}
