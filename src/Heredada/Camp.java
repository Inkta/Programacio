package Heredada;

import java.util.ArrayList;

public class Camp {
	private joc pantalla;
	ArrayList<Soldat> exerc1;
	ArrayList<Soldat> exerc2;
	General General = new General(pantalla);

	public Camp(final joc pan, ArrayList<Soldat> a, ArrayList<Soldat> b) {
		exerc1 = a;
		exerc2 = b;
		pantalla = pan;
	}

	public int Fila() {
		int files2 = 5;
		if (exerc1.size() < files2) {
			files2 = exerc1.size();
		}
		if (exerc2.size() < files2) {
			files2 = exerc2.size();
		}
		return files2;
	}

	public void Formacio(ArrayList<Soldat> exerc) {

		int files = Fila();

		General.Formar(exerc, pantalla, 60, files);
	}

	public void Neteja(ArrayList<Soldat> exerc ) {
		for (int i=0; i < exerc.size(); i++) {
			pantalla.remove(exerc.get(i).getImatge());
		}
	}

	public void Guerra() {
		General.Reclutar(exerc1, pantalla);
		General.Reclutar(exerc2, pantalla);

		Formacio(exerc1);
		Formacio(exerc2);

		while (exerc1.size() != 0 && exerc2.size() != 0) {

			if (General.Acorrer(exerc1, pantalla) == exerc1.size()) {
				General.Perdre(exerc1, pantalla);
				General.GireuVos(exerc1);
				General.Reclutar(exerc1, pantalla);
				Formacio(exerc1);
			}

			if (General.Acorrer(exerc2, pantalla) == exerc2.size()) {
				General.Perdre(exerc2, pantalla);
				General.GireuVos(exerc2);
				General.Reclutar(exerc2, pantalla);
				Formacio(exerc2);
			}

			comprovaMort();

			}
		}


	public void comprovaMort() {
		int tir = (int)(Math.random()*2);
		switch (tir) {
			case 0:

				for (int i=0; i < exerc2.size(); i++) {
					for (int a=0; a < exerc1.size(); a++) {
						exerc1.get(a).ComprovaMort(exerc2.get(i), Math.random()*1, pantalla);
						if (exerc1.get(a).getVida() == 0) {
							pantalla.remove(exerc1.get(a).getImatge());
							exerc1.remove(a);
							a--;
						}
					}
				}

				break;
			case 1:

				for (int i=0; i < exerc1.size(); i++) {
					for (int a=0; a < exerc2.size(); a++) {
						exerc2.get(a).ComprovaMort(exerc1.get(i), Math.random()*1, pantalla);
						if (exerc2.get(a).getVida() == 0) {
							pantalla.remove(exerc2.get(a).getImatge());
							exerc2.remove(a);
							a--;
						}
					}
				}

				break;
		}
	}

}

