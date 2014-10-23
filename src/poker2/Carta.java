package poker2;

// TODO: Auto-generated Javadoc
/**
 * The Class Carta.
 */
public class Carta {
	
	/** The nom. */
	String nom;
	
	/** The valor. */
	int valor;
	
	/** The pal. */
	String pal;
	
	/**
	 * Gets the pal.
	 *
	 * @return the pal
	 */
	public String getPal() {
		return pal;
	}
	
	/**
	 * Sets the pal.
	 *
	 * @param pal the new pal
	 */
	public void setPal(String pal) {
		this.pal = pal;
	}
	
	/**
	 * Instantiates a new carta.
	 *
	 * @param a the a
	 * @param c the c
	 * @param b the b
	 */
	public Carta(String a,String c, int b) {
		nom = a;
		pal = c;
		valor = b;
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
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
}
