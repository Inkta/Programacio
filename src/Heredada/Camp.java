package Heredada;

import java.util.ArrayList;

public class Camp {
	private joc pantalla;
	ArrayList<Soldat> exerc1;
	ArrayList<Soldat> exerc2;
	General General = new General(pantalla);
	double[] extrems;
	public Camp(final joc pan, ArrayList<Soldat> a, ArrayList<Soldat> b,double[] f) {
		exerc1 = a;
		exerc2 = b;
		pantalla = pan;
		extrems = f;
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

		General.Formar(exerc, pantalla, 76, files);
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

			if (General.Acorrer(exerc1, pantalla) == exerc1.size() && !exerc1.get(0).getTipus().equals("Mag")) {
				General.Perdre(exerc1, pantalla);
				General.GireuVos(exerc1);
				General.Reclutar(exerc1, pantalla);
				Formacio(exerc1);
			}

			if (General.Acorrer(exerc2, pantalla) == exerc2.size() && !exerc2.get(0).getTipus().equals("Mag")) {
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
				for (int i=exerc2.size()-1; i >= 0; i--) {
					for (int a=exerc1.size()-1 ; a >= 0; a--) {
						double num = Math.random();
						exerc1.get(a).ComprovaMort(exerc2.get(i), num, pantalla);
						
						if (exerc2.get(i).tipus.equals("bala") && exerc2.get(i).getVida() == 0) {
							pantalla.remove(exerc2.get(i).getImatge());
							exerc2.remove(i);
						}
						
						if (exerc1.get(a).getVida() <= 0) {
							pantalla.remove(exerc1.get(a).getImatge());
							exerc1.remove(a);
						}
					}
				}
				
				break;
			case 1:
				for (int i=exerc1.size()-1 ; i >= 0; i--) {
					for (int a=exerc2.size()-1; a >= 0; a--) {
						double num = Math.random();
						exerc2.get(a).ComprovaMort(exerc1.get(i), num, pantalla);
						
						if (exerc1.get(i).tipus.equals("bala") && exerc1.get(i).getVida() == 0) {
							pantalla.remove(exerc1.get(i).getImatge());
							exerc1.remove(i);
						}
						
						if (exerc2.get(a).getVida() <= 0) {
							pantalla.remove(exerc2.get(a).getImatge());
							exerc2.remove(a);
						}
					}
				}

				break;
		}
	}

}

