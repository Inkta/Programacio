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
	Camp guerra = new Camp(this, exercit1, exercit2,extrems);
	General General = new General(this);
	exercit1 = General.afegirSoldats(exercit1,"knight-right.png","knight-left.png","def-right.png","def-left.png","mage-right.png","mage-left.png","hunter-right.png","hunter-left.png",5,false,1,extrems);
	exercit2 = General.afegirSoldats(exercit2,"warrior-right.png","warrior-left.png","barb-right.png","barb-left.png","summ-right.png","summ-left.png","assassin-right.png","assassin-left.png",5,true,1,extrems);

	guerra.Guerra();
	System.out.println("Final de la Batalla");
	}


}
