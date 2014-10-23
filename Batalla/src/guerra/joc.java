package guerra;

import java.util.ArrayList;

import acm.program.GraphicsProgram;

public class joc extends GraphicsProgram {


	public final void run() {
	setSize(800,600);
	pause(100);
	
	
	int finalpantalla = getWidth() - 50;
	ArrayList<Soldat> exercit1 = new ArrayList<Soldat>();
	ArrayList<Soldat> exercit2 = new ArrayList<Soldat>();
	Camp guerra = new Camp(this, exercit1, exercit2);
	General General = new General(this);
	exercit1 = General.afegirSoldats(exercit1,"alien.png", false);
	exercit2 = General.afegirSoldats(exercit2,"romano.png",true);

	guerra.Guerra();
	System.out.println("Final de la Batalla");
	}


}
