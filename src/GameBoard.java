//Kurt Kimura, Lab Section 02
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
public class GameBoard extends JComponent {
	public void paint(Graphics g) {
		//DRAW BOARD
		/*
		g.setColor(Color.BLACK);
		g.fillRect(195, 130, 310, 310); //OUTLINE
		g.setColor(Color.DARK_GRAY);
		g.fillRect(200, 135, 100, 100); //Top Left
		g.fillRect(200, 335, 100, 100); //Top Right
		g.fillRect(300, 235, 100, 100); //Center
		g.fillRect(400, 135, 100, 100); //Bottom Left
		g.fillRect(400, 335, 100, 100); //Bottom Right
		g.setColor(Color.GRAY);
		g.fillRect(200, 235, 100, 100); //Top Center
		g.fillRect(300, 135, 100, 100); //Middle Left
		g.fillRect(300, 335, 100, 100); //Middle Right
		g.fillRect(400, 235, 100, 100); //Bottom Center
		*/
		///*
		g.setColor(Color.BLACK);
		g.drawLine(200, 135, 200, 435); //LEFT
		g.drawLine(300, 135, 300, 435); //LEFT IN
		g.drawLine(400, 135, 400, 435); //RIGHT IN
		g.drawLine(200, 135, 500, 135); //TOP
		g.drawLine(200, 235, 500, 235); //TOP IN
		g.drawLine(200, 335, 500, 335); //BOTTOM IN
		g.drawLine(200, 435, 500, 435); //BOTTOM
		g.drawLine(500, 135, 500, 435); //RIGHT
		//*/
	}
}
