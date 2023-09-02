import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GameBoardCard extends JComponent{
	
	int positionMod = 0;
	boolean playerCard;
	
	GameBoardCard(int number, boolean p) {
		positionMod = number;
		playerCard = p;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		if (playerCard == true) {
			switch (positionMod) {
			case 1:
				g.fillRect(208, 136, 80, 100); //Top Left
				g.setColor(Color.BLUE);
				g.fillRect(213, 141, 70, 90); //Top Left
				break;
			case 2:
				g.fillRect(308, 136, 80, 100); //Top Middle
				g.setColor(Color.BLUE);
				g.fillRect(313, 141, 70, 90); //Top Middle
				break;
			case 3:
				g.fillRect(408, 136, 80, 100); //Bottom Left
				g.setColor(Color.BLUE);
				g.fillRect(413, 141, 70, 90); //Bottom Left
				break;
			case 4:
				g.fillRect(208, 236, 80, 100); //Middle Left
				g.setColor(Color.BLUE);
				g.fillRect(213, 241, 70, 90); //Middle Left
				break;
			case 5:
				g.fillRect(308, 236, 80, 100); //Center
				g.setColor(Color.BLUE);
				g.fillRect(313, 241, 70, 90); //Center
				break;
			case 6:
				g.fillRect(408, 236, 80, 100); //Middle Right
				g.setColor(Color.BLUE);
				g.fillRect(413, 241, 70, 90); //Middle Right
				break;
			case 7:
				g.fillRect(208, 336, 80, 100); //Top Right
				g.setColor(Color.BLUE);
				g.fillRect(213, 341, 70, 90); //Top Right
				break;
			case 8:
				g.fillRect(308, 336, 80, 100); //Bottom Middle
				g.setColor(Color.BLUE);
				g.fillRect(313, 341, 70, 90); //Bottom Middle
				break;
			case 9:
				g.fillRect(408, 336, 80, 100); //Bottom Right
				g.setColor(Color.BLUE);
				g.fillRect(413, 341, 70, 90); //Bottom Right
				break;
			}
		} else {
			switch (positionMod) {
			case 1:
				g.fillRect(208, 136, 80, 100); //Top Left
				g.setColor(Color.RED);
				g.fillRect(213, 141, 70, 90); //Top Left
				break;
			case 2:
				g.fillRect(308, 136, 80, 100); //Top Middle
				g.setColor(Color.RED);
				g.fillRect(313, 141, 70, 90); //Top Middle
				break;
			case 3:
				g.fillRect(408, 136, 80, 100); //Bottom Left
				g.setColor(Color.RED);
				g.fillRect(413, 141, 70, 90); //Bottom Left
				break;
			case 4:
				g.fillRect(208, 236, 80, 100); //Middle Left
				g.setColor(Color.RED);
				g.fillRect(213, 241, 70, 90); //Middle Left
				break;
			case 5:
				g.fillRect(308, 236, 80, 100); //Center
				g.setColor(Color.RED);
				g.fillRect(313, 241, 70, 90); //Center
				break;
			case 6:
				g.fillRect(408, 236, 80, 100); //Middle Right
				g.setColor(Color.RED);
				g.fillRect(413, 241, 70, 90); //Middle Right
				break;
			case 7:
			g.fillRect(208, 336, 80, 100); //Top Right
				g.setColor(Color.RED);
				g.fillRect(213, 341, 70, 90); //Top Right
				break;
			case 8:
				g.fillRect(308, 336, 80, 100); //Bottom Middle
				g.setColor(Color.RED);
				g.fillRect(313, 341, 70, 90); //Bottom Middle
				break;
			case 9:
				g.fillRect(408, 336, 80, 100); //Bottom Right
				g.setColor(Color.RED);
				g.fillRect(413, 341, 70, 90); //Bottom Right
				break;
			}
		}
	}
}
