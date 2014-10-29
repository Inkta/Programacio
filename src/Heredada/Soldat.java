package Heredada;

import acm.graphics.GImage;

public abstract class Soldat {
	int vel;
	boolean direccio;
	int vida;
	GImage imatge;
	protected boolean mov = false;
	String imatgedreta;
	String imatgeesquerra;
	double[] extrems;

	public Soldat(String a, String a2, int b, boolean c, int d, double[] e) {
		imatgedreta = a;
		imatgeesquerra = a2;
		this.canviaImatge(imatgedreta,imatgeesquerra);
		vel = b;
		direccio = c;
		vida = d;
		extrems = e;
	}

	public void canviaImatge(String a, String a2) {
		if (direccio) {
			imatge = new GImage(a);
		} else {
			imatge = new GImage(a2);
		}
	}

	public boolean Moure(){
		return false;
	}

	public boolean ComprovaMort(GImage imatge){
		return false;
	}
	public void CanviaDireccio(){}
	public void GiraImatge(){}

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
