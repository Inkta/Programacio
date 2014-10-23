package poker2;

import java.util.ArrayList;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Jugador.
 */
public class Jugador {
	
	/** The nom. */
	String nom;
	
	/** The puntuacio. */
	int puntuacio;
	
	/** The calers. */
	int calers;
	
	/** The ma. */
	ArrayList<Carta> ma = new ArrayList<Carta>();
	
	
	/**
	 * Instantiates a new jugador.
	 *
	 * @param a the a
	 * @param b the b
	 */
	public Jugador(String a, int b) {
		nom = a;
		calers = b;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the calers.
	 *
	 * @return the calers
	 */
	public int getCalers() {
		return calers;
	}
	
	/**
	 * Gets the puntuacio.
	 *
	 * @return the puntuacio
	 */
	public int getPuntuacio() {
		return puntuacio;
	}
	
	/**
	 * Sets the puntuacio.
	 *
	 * @param puntuacio the new puntuacio
	 */
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	/**
	 * Sets the calers.
	 *
	 * @param calers the new calers
	 */
	public void setCalers(int calers) {
		this.calers = calers;
	}
	
	/**
	 * Agafa carta.
	 *
	 * @param a the a
	 * @return the array list
	 */
	public ArrayList<Carta> AgafaCarta(Carta a) {
		System.out.println(a.getNom() + " de " + a.getPal());
		ma.add(a);
		return ma;
	}
	
	
	/**
	 * Retorna cartes.
	 */
	public void RetornaCartes() {
		ma.clear();
	}
	
	/**
	 * Mirar pal.
	 *
	 * @return true, if successful
	 */
	public boolean mirarPal() {
		int flush = 0;
		
		for (int i=0; i < ma.size()-1; i++) {
			if (ma.get(i).getPal().equals(ma.get(i+1).getPal())) {
				flush++;
			} else {
			}
		}
		
		if (flush == 4) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Ensenya carta.
	 *
	 * @return the int[]
	 */
	public int[] EnsenyaCarta() {
		int[] valors = new int[ma.size()];
		
		for (int i=0; i < valors.length; i++) {
			valors[i] = ma.get(i).getValor();
		}
		
		Arrays.sort(valors);
		return valors;
	}
	
	
}
