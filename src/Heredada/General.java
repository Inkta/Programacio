package Heredada;

import java.util.ArrayList;

import acm.graphics.GImage;

public class General {
	static joc pantalla;
	private final int ninjas = 2;
	private final int Forts = 3;
	private final int mags = 1;
	private final int Normals = 15;
	public General(joc pantalla) {
		this.pantalla = pantalla;
	}

	public ArrayList<Soldat> afegirSoldats(ArrayList<Soldat> a, String imatge,String imatge2,String imatgeF,String imatge2F,String imatgeM,String imatge2M,String imatgeN,String imatge2N,int c, boolean direccio, int d, double[] extrems) {

		for (int i=0; i < ninjas; i++) {
			a.add(new SoldatNinja(new GImage(imatgeN),new GImage(imatge2N),c, direccio,d,extrems, "Ninja"));
		}

		for (int i=0; i < Normals; i++) {
			a.add(new SoldatNormal(new GImage(imatge),new GImage(imatge2),c, direccio,d,extrems, "Normal"));
		}

		for (int i=0; i < Forts; i++) {
			a.add(new SoldatFort(new GImage(imatgeF),new GImage(imatge2F),c, direccio,d,extrems, "Fort"));
		}

		for (int i=0; i < mags; i++) {
			a.add(new SoldatMag(new GImage(imatgeM),new GImage(imatge2M),c, direccio,d,extrems, "Mag"));
		}


		return a;
	}


	public void Reclutar(ArrayList<Soldat> exerc, joc pantalla) {
		for (int i=0; i < exerc.size(); i++) {
			pantalla.add(exerc.get(i).getImatge());
		}
	}

	public void Perdre(ArrayList<Soldat> exerc, joc pantalla) {
		for (int i=0; i < exerc.size(); i++) {
			pantalla.remove(exerc.get(i).getImatge());
		}
	}

	public void GireuVos(ArrayList<Soldat> exerc) {
		for (int i=0; i < exerc.size(); i++) {
			exerc.get(i).canviaImatge();
		}
	}

	public void Formar(ArrayList<Soldat> exerc, joc pantalla, int num, int files) {
		if (num > exerc.get(0).getLloc()) {
			num = num * 1;
		} else {
			num = num * -1;
		}

		for (int i=0; i < exerc.size(); i++) {
			int fila = (int)(Math.random()*files);
			exerc.get(i).setPosicio(exerc.get(i).getLloc(), fila*76);
			exerc.get(i).setMov(true);
			exerc.get(i).setDireccio(!exerc.get(i).getDireccio());
		}

		pantalla.pause(100);

		for (int i=0; i < exerc.size(); i++) {
			double despl = 0;
			for (int a=0; a < exerc.size(); a++) {
				if (exerc.get(i).getImatge().getBounds().intersects(exerc.get(a).getImatge().getBounds()) && i != a) {
					despl = despl + num;
				}
			}
			exerc.get(i).setPosicio(exerc.get(i).getImatge().getX()+despl, exerc.get(i).getImatge().getY());
			pantalla.pause(5);
		}

	}


	public int Acorrer(ArrayList<Soldat> exerc, joc pantalla) {
		int extremistes = 0; //contador per controlar si arriben al extrem del camp
		for (int i=0; i < exerc.size(); i++) {
			boolean extrem = exerc.get(i).Moure();
			if (exerc.get(i).getTipus().equals("Ninja") && Math.random() > 0.99) {
				exerc.add(exerc.get(i).Dispara());
				exerc.get(exerc.size()-1).getImatge().setLocation(exerc.get(i).getImatge().getX(),exerc.get(i).getImatge().getY()+25);
				pantalla.add(exerc.get(exerc.size()-1).getImatge());
			}

			if (!extrem) {
				extremistes++;
			}
		}
		

		pantalla.pause(20);
		return extremistes;

	}

}
