import javax.swing.JComponent;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	JComponent board = new GameBoard();
	
	GameWindow(){
		this.setTitle("Triple Triad Remake by Kurt K");
		this.setSize(716, 609);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(board);
		this.setVisible(true);
	}
	
}
