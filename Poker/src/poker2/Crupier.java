package poker2;

import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Crupier.
 */
public class Crupier {
	
	/** The Jugadors. */
	ArrayList<Jugador> Jugadors = new ArrayList<Jugador>();
	
	/**
	 * Instantiates a new crupier.
	 */
	public Crupier() {
	}

	/**
	 * Joc.
	 *
	 * @return the int
	 */
	public int Joc() {
		Baralla baralla = new Baralla();
		for (int i=0; i < Jugadors.size(); i++) {
			System.out.println("------------------||" + Jugadors.get(i).getNom() + " $$$ " + Jugadors.get(i).getCalers());
			for (int a=0; a < 5; a++) {
				Jugadors.get(i).AgafaCarta(baralla.donaCarta());
			}
		}
		Scanner lector = new Scanner(System.in);

		ArrayList<Jugador> JugadorsA = new ArrayList<Jugador>();
		int pot = 0;
		int a = 0;
		for (int i=0; i < Jugadors.size(); i++) {
			System.out.println(Jugadors.get(i).getNom() + ": Vols Apostar? (s/n)");
			String resposta = lector.nextLine();

			if (resposta.equals("s") && Jugadors.get(i).getCalers() > 10) {
				JugadorsA.add(Jugadors.get(i));
				JugadorsA.get(a).setCalers(JugadorsA.get(a).getCalers()-10);
				pot = pot + 10;
				a++;

			} else {
				System.out.println("El jugador " + Jugadors.get(i).getNom() + " no entra perque no vol o perque no pot apostar");
			}
		}


		if (JugadorsA.size() > 1) {

		//Ara que ja les tenim repartides procedim a ensenyarles i contar puntuacions.
		int guanyador=0;
		int pos = 0;
		for (int i=0; i < JugadorsA.size(); i++) {
			System.out.println("------------------||" + JugadorsA.get(i).getNom() + " ->" + ComprovaPunt(JugadorsA.get(i).EnsenyaCarta(),JugadorsA.get(i).mirarPal()));
			JugadorsA.get(i).setPuntuacio(ComprovaPunt(JugadorsA.get(i).EnsenyaCarta(),JugadorsA.get(i).mirarPal()));
			if (ComprovaPunt(JugadorsA.get(i).EnsenyaCarta(),JugadorsA.get(i).mirarPal()) > guanyador) {
				guanyador = ComprovaPunt(JugadorsA.get(i).EnsenyaCarta(),JugadorsA.get(i).mirarPal());
				pos = i;
			}
		}

		int empat = 0;
		for (int i=0; i < JugadorsA.size();i++) {
				if (JugadorsA.get(i).getPuntuacio() == guanyador) {
					empat++;
				}
		}

		if (empat == 1) {

		System.out.println("El guanyador es: " + JugadorsA.get(pos).getNom() + " ---> " + guanyador);
		JugadorsA.get(pos).setCalers(JugadorsA.get(pos).getCalers()+pot);
		} else {
			System.out.println("Empat!!");
			for (int i=0; i < JugadorsA.size(); i++) {
				JugadorsA.get(i).setCalers(JugadorsA.get(i).getCalers()+10);
			}
		}
		}

		for (int i=0; i < Jugadors.size(); i++) {
			Jugadors.get(i).RetornaCartes();
		}

		for (int i=0; i < Jugadors.size(); i++) {

			if (Jugadors.get(i).getCalers() < 10) {
				System.out.println("El jugador " + Jugadors.get(i).getNom() + " Ha sigut expulsat");
			}

			System.out.println(Jugadors.get(i).getNom() + ": Vols retirarte del joc? (s/n)");
			String resposta = lector.nextLine();


			if (resposta.equals("s")) {
				Jugadors.remove(i);
				i--;
			}
		}

		lector.close();
		return Jugadors.size();
	}

	/**
	 * Jugadorsa la taula.
	 *
	 * @param numjugadors the numjugadors
	 */
	public void JugadorsaLaTaula(int numjugadors) {
		for (int i=0; i < numjugadors; i++) {
			Jugadors.add(new Jugador("Jugador "+(i+1),100));
		}

	}
	//metode per contar les puntuacions

	/**
	 * Comprova punt.
	 *
	 * @param arr the arr
	 * @param Flush the flush
	 * @return the int
	 */
	public int ComprovaPunt(int[] arr, boolean Flush) {
		int contador =0;
		int valor = 0;
		for (int i=0; i < arr.length; i++) {
			for (int a=0; a < arr.length; a++) {
				if (arr[i] == arr[a] && i != a) {
					contador++;
					valor += arr[i];
				}
			}
		}

		if (contador == 0) {
			int escala = 0;
			for (int i=0; i < arr.length-1; i++) {
				if (arr[i] == arr[i+1]-1) {
					escala++;
					valor += arr[i];
				}
			}

			if (escala == 4 && !Flush) {//Escala
				return valor + 300;
			}

			if (escala == 4 && Flush) {//Escala + Flush
				return valor + 700;
			}

		}


		//retornar puntuacions

		if (contador == 2 && !Flush) {//parella
			return valor;
		}

		if (contador == 4 && !Flush) {//doble parella
			return valor + 100;
		}

		if (contador == 6 && !Flush) {//trio
			return valor + 200;
		}

		if (contador == 8) {//trio + parella
			return valor + 500;
		}

		if (contador == 12) {//poker
			return valor + 600;
		}

		if (Flush) {//Flush
			return 400;
		}

		return 0;
	}



}
