package guerra;

import java.util.ArrayList;

public class General {
	static joc pantalla;
	private final int combatents = 30;
	public General(joc pantalla) {
		this.pantalla = pantalla;
	}

	public ArrayList<Soldat> afegirSoldats(ArrayList<Soldat> a, String imatge, boolean direccio, double[] extrems) {
		for (int i=0; i < combatents; i++) {
			a.add(new Soldat(imatge, direccio, extrems));
		}
		return a;
	}


	public void Reclutar(ArrayList<Soldat> exerc, joc pantalla) {
		for (int i=0; i < exerc.size(); i++) {
			pantalla.add(exerc.get(i).getImatge());
		}
	}

	public void Formar(ArrayList<Soldat> exerc, joc pantalla, int num, int files) {
		if (num > exerc.get(0).getLloc()) {
			num = num * 1;
		}else {
			num = num * -1;
		}

		for (int i=0; i < exerc.size(); i++) {
			int fila = (int)(Math.random()*files);
			exerc.get(i).setPosicio(exerc.get(i).getLloc(), fila*75);
			exerc.get(i).setMov(true);
			exerc.get(i).setDret(!exerc.get(i).getDireccio());
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
		}
	}

	public int Acorrer(ArrayList<Soldat> exerc, joc pantalla) {
		int extremistes = 0; //contador per controlar si arriben al extrem del camp
		for (int i=0; i < exerc.size(); i++) {
			boolean extrem = exerc.get(i).Moure();
			if (!extrem) {
				extremistes++;
			}
		}
		pantalla.pause(2);
		return extremistes;

	}

}
