package Heredada;

import acm.graphics.GImage;

public class Estrella extends Soldat{
	int moviment;
	int durabilitat;
	GImage bola = new GImage("estrella.png");
	public int getMoviment() {
		return moviment;
	}

	public void setMoviment(int moviment) {
		this.moviment = moviment;
	}

	public int getDurabilitat() {
		return durabilitat;
	}

	public void setDurabilitat(int durabilitat) {
		this.durabilitat = durabilitat;
	}

	public GImage getImatge() {
		return bola;
	}

	public void setImatge(GImage imatge) {
		this.bola = imatge;
	}

	public Estrella(GImage a, GImage a2, int b, boolean c, int d, double[] e, int mov, int dur) {
		super (a,a2,b,c,d,e);
		moviment = mov;
		durabilitat = dur;
		imatge.setSize(50,50);
	}

	public boolean Moure(Soldat a) {
		if (durabilitat > 0) {
			System.out.println("Hola");
			this.getImatge().move(moviment, 0);
			this.Mata(a);
			return false;
		}
		return false;

	}

	public void trencar() {
		this.durabilitat = this.durabilitat - 1;
	}

	public void Mata(Soldat a) {
		System.out.println("Hola");
		if (this.getImatge().getBounds().intersects(a.getImatge().getBounds())) {
			a.restarVida();
			this.trencar();
		}
	}
}
