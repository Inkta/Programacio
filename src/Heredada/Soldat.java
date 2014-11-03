package Heredada;
import java.util.ArrayList;

import acm.graphics.GImage;

public abstract class Soldat {
	public static final double mida = 75;
	int vel;
	boolean direccio;
	int vida;
	GImage imatge;
	protected boolean mov = true;
	GImage imatgedreta;
	GImage imatgeesquerra;
	double[] extrems;
	String tipus;

	public Soldat(GImage a, GImage a2, int b, boolean c, int d, double[] e, String z) {
		imatgedreta = a;
		imatgedreta.setSize(mida,mida);
		imatgeesquerra = a2;
		imatgeesquerra.setSize(mida,mida);
		direccio = c;
		this.canviaImatge();
		vel = b;
		vida = d;
		extrems = e;
		tipus = z;
	}

	public Bala Dispara() {
		return null;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public double[] getExtrems() {
		return extrems;
	}

	public void setExtrems(double[] extrems) {
		this.extrems = extrems;
	}

	public void canviaImatge() {
		if (!direccio) {
			imatge = imatgedreta;
		} else {
			imatge = imatgeesquerra;
		}
	}

	public boolean Moure(){
		return false;
	}

	public int restarVida() {
		this.vida = this.vida - 1;
		return this.vida;
	}

	public void ComprovaMort(Soldat a, double b, joc pantalla){
		if (a.getImatge().getBounds().intersects(this.getImatge().getBounds())) {
			this.restarVida();
		}
	}

	public GImage getImatge() {
		return imatge;
	}

	public void setImatge(GImage imatge) {
		this.imatge = imatge;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public boolean isDireccio() {
		return direccio;
	}

	public void setDireccio(boolean direccio) {
		this.direccio = direccio;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setPosicio(double d,double e) {
		imatge.setLocation(d,e);
	}

	public double getLloc() {
		if (direccio) {
			return extrems[1];
		} else {
			return extrems[0];
		}
	}

	public void setMov(boolean mov) {
		this.mov = mov;
	}

	public boolean getDireccio() {
		return this.direccio;
	}

}
