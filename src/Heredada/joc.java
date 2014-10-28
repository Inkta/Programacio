package Heredada;

import java.util.ArrayList;

import acm.program.GraphicsProgram;

public class joc extends GraphicsProgram {

	public final void run() {
	setSize(1200,800);
	pause(100);
	double finalpantalla = getWidth() - 75;
	double[] extrems = {0,finalpantalla};
	ArrayList<Soldat> exercit1 = new ArrayList<Soldat>();
	ArrayList<Soldat> exercit2 = new ArrayList<Soldat>();
	Camp guerra = new Camp(this, exercit1, exercit2);
	General General = new General(this);
	exercit1 = General.afegirSoldats(exercit1,"def-right.png", false,extrems);
	exercit2 = General.afegirSoldats(exercit2,"knight-left.png",true,extrems);

	guerra.Guerra();
	System.out.println("Final de la Batalla");

	}


}
