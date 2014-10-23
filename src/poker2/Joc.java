package poker2;

// TODO: Auto-generated Javadoc
/**
 * The Class Joc.
 */
public class Joc {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Crupier Comensa = new Crupier();
		int a = 10;
		Comensa.JugadorsaLaTaula(5);

		while (a > 1) {
			System.out.println("Comença el Joc ---------------- ");
			a = Comensa.Joc();
		}

		System.out.println("El joc s'ha acabat!");
	}

}
