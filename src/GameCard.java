import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GameCard extends JComponent{
	
	int positionMod = 0;
	boolean playerCard;
	
	GameCard(int number, boolean p) {
		if (p == true) {
			positionMod = (number+2)*100;
		} else {
			positionMod = (number)*100;
		}
		playerCard = p;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		if (playerCard == true) {
			g.fillRect(positionMod+10, 459, 80, 100);
			g.setColor(Color.BLUE);
			g.fillRect(positionMod+15, 464, 70, 90);
		} else {
			g.fillRect(positionMod+10, 15, 80, 100);
			g.setColor(Color.RED);
			g.fillRect(positionMod+15, 20, 70, 90);
		}
		
	}
	
	
}
