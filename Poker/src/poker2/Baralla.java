/*
 *
 */
package poker2;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Baralla.
 */
public class Baralla {

	/** The cartes. */
	String[] cartes = {"Diamants","Piques","Trebols","Cors","1","2","3","4","5","6","7","8","9","10","J","Q","K"};

	/** The Baralla. */
	ArrayList<Carta> Baralla = new ArrayList<Carta>();

	/**
	 * Instantiates a new baralla.
	 */
	public Baralla() {
		for (int i=0; i < 4; i++) {
			for (int a=4; a< cartes.length; a++) {
				Baralla.add(new Carta(cartes[a], cartes[i],a-3));
			}
		}
	}


	/**
	 * Dona carta.
	 *
	 * @return the carta
	 */
	public Carta donaCarta() {
		int a = (int) (Math.random()*Baralla.size());
		Carta nova = Baralla.get(a);
		Baralla.remove(a);
		return nova;
	}
}
