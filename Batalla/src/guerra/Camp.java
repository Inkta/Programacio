package guerra;

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

	public void Guerra() {
		General.Reclutar(exerc1, pantalla);
		General.Reclutar(exerc2, pantalla);
		
		Formacio(exerc1);
		Formacio(exerc2);

		while (exerc1.size() != 0 && exerc2.size() != 0) {
			
			if (General.Acorrer(exerc1, pantalla) == exerc1.size()) {
				Formacio(exerc1);
			}
			
			if (General.Acorrer(exerc2, pantalla) == exerc2.size()) {
				Formacio(exerc2);
			}
			
			comprovaMort();
			
			}
		}
	
	public void comprovaMort() {
		int tir = (int)(Math.random()*2);
		switch (tir) {
			case 0:
				
				for (int i=0; i < exerc1.size(); i++) {
					for (int a=0; a < exerc2.size(); a++) {
						if (exerc1.get(i).ComprovaMort(exerc2.get(a))) {
							pantalla.remove(exerc2.get(a).getImatge());
							exerc2.remove(a);
							a--;
						}
					}
				}
				
				break;
			case 1:
				
				for (int i=0; i < exerc2.size(); i++) {
					for (int a=0; a < exerc1.size(); a++) {
						if (exerc2.get(i).ComprovaMort(exerc1.get(a))) {
							pantalla.remove(exerc1.get(a).getImatge());
							exerc1.remove(a);
							a--;
						}
					}
				}
				
				break;
		}
	}

}
