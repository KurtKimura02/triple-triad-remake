//Kurt Kimura, Lab Section 02
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;

public class TripleTriad {
	
	//VARIABLES
	static String winner = "The winner is ";
	
	static int cardPicked = 0;
	static int cardPlaced = 0;
	static int cpuCards = 5;
	static int cpuPicked = 0;
	static int cpuPlaced = 0;
	static int scoreCPU = 0;
	static int scorePlayer = 0;
	
	static int ownedTL = 0;
	static int ownedTM = 0;
	static int ownedTR = 0;
	static int ownedML = 0;
	static int ownedMM = 0;
	static int ownedMR = 0;
	static int ownedBL = 0;
	static int ownedBM = 0;
	static int ownedBR = 0;
	
	static boolean cpuPlayedA = false;
	static boolean cpuPlayedB = false;
	static boolean cpuPlayedC = false;
	static boolean cpuPlayedD = false;
	static boolean cpuPlayedE = false;
	static boolean playerPlayedA = false;
	static boolean playerPlayedB = false;
	static boolean playerPlayedC = false;
	static boolean playerPlayedD = false;
	static boolean playerPlayedE = false;
	static boolean playerTurn = true;
	
	static NormalCard filledTL = null;
	static NormalCard filledTM = null;
	static NormalCard filledTR = null;
	static NormalCard filledML = null;
	static NormalCard filledMM = null;
	static NormalCard filledMR = null;
	static NormalCard filledBL = null;
	static NormalCard filledBM = null;
	static NormalCard filledBR = null;
	
	static NormalCard[] playerHand = new NormalCard[5];
	static NormalCard[] cpuHand = new NormalCard[5];
	
	//WINDOW SETTINGS
	static JFrame playWindow = new GameWindow();
	
	//CREATE BUTTONS
	static JButton cancel = new JButton("CANCEL");
	static JButton boardTL = new JButton("PLACE");
	static JButton boardTM = new JButton("PLACE");
	static JButton boardTR = new JButton("PLACE");
	static JButton boardML = new JButton("PLACE");
	static JButton boardMM = new JButton("PLACE");
	static JButton boardMR = new JButton("PLACE");
	static JButton boardBL = new JButton("PLACE");
	static JButton boardBM = new JButton("PLACE");
	static JButton boardBR = new JButton("PLACE");
	static JButton restart = new JButton("CLOSE GAME");
	
	//CREATE GRAPHICS
	//PLAYER CARDS IN HAND
	static JComponent playerCardA = new GameCard(0, true);
	static JComponent playerCardB = new GameCard(1, true);
	static JComponent playerCardC = new GameCard(2, true);
	static JComponent playerCardD = new GameCard(3, true);
	static JComponent playerCardE = new GameCard(4, true);
	//CPU CARDS IN HAND
	static JComponent cpuCardA = new GameCard(0, false);
	static JComponent cpuCardB = new GameCard(1, false);
	static JComponent cpuCardC = new GameCard(2, false);
	static JComponent cpuCardD = new GameCard(3, false);
	static JComponent cpuCardE = new GameCard(4, false);
	//PLAYER CARDS ON BOARD
	static JComponent playerCardTL = new GameBoardCard(1, true);
	static JComponent playerCardTM = new GameBoardCard(2, true);
	static JComponent playerCardTR = new GameBoardCard(3, true);
	static JComponent playerCardML = new GameBoardCard(4, true);
	static JComponent playerCardMM = new GameBoardCard(5, true);
	static JComponent playerCardMR = new GameBoardCard(6, true);
	static JComponent playerCardBL = new GameBoardCard(7, true);
	static JComponent playerCardBM = new GameBoardCard(8, true);
	static JComponent playerCardBR = new GameBoardCard(9, true);
	//CPU CARDS ON BOARD
	static JComponent cpuCardTL = new GameBoardCard(1, false);
	static JComponent cpuCardTM= new GameBoardCard(2, false);
	static JComponent cpuCardTR = new GameBoardCard(3, false);
	static JComponent cpuCardML = new GameBoardCard(4, false);
	static JComponent cpuCardMM = new GameBoardCard(5, false);
	static JComponent cpuCardMR= new GameBoardCard(6, false);
	static JComponent cpuCardBL = new GameBoardCard(7, false);
	static JComponent cpuCardBM = new GameBoardCard(8, false);
	static JComponent cpuCardBR = new GameBoardCard(9, false);
	
	//READY GAME TO PLAY
	public static void startup() {
		//RESET VARIABLES
		winner = "The winner is ";
		cardPicked = 0;
		cardPlaced = 0;
		playerPlayedA = false;
		playerPlayedB = false;
		playerPlayedC = false;
		playerPlayedD = false;
		playerPlayedE = false;
		cpuCards = 5;
		cpuPicked = 0;
		cpuPlaced = 0;
		cpuPlayedA = false;
		cpuPlayedB = false;
		cpuPlayedC = false;
		cpuPlayedD = false;
		cpuPlayedE = false;
		filledTL = null;
		filledTM = null;
		filledTR = null;
		filledML = null;
		filledMM = null;
		filledMR = null;
		filledBL = null;
		filledBM = null;
		filledBR = null;
		//GENERATE HAND FOR PLAYER
		for (int x = 0; x < 4; x++) {
			NormalCard addNormal = new NormalCard();
			playerHand[x] = addNormal;
		}
		StrongCard addStrong = new StrongCard();
		playerHand[4] = addStrong;
		//GENERATE HAND FOR CPU
		for (int y = 0; y < 4; y++) {
			NormalCard addNormal = new NormalCard();
			cpuHand[y] = addNormal;
		}
		StrongCard cpuStrong = new StrongCard();
		cpuHand[4] = cpuStrong;
		//SET BUTTON SIZES
		boardTL.setBounds(205, 140, 90, 90);
		boardML.setBounds(205, 240, 90, 90);
		boardBL.setBounds(205, 340, 90, 90);
		boardTM.setBounds(305, 140, 90, 90);
		boardMM.setBounds(305, 240, 90, 90);
		boardMR.setBounds(405, 240, 90, 90);
		boardTR.setBounds(405, 140, 90, 90);
		boardBM.setBounds(305, 340, 90, 90);
		boardBR.setBounds(405, 340, 90, 90);
		restart.setBounds(250, 550, 200, 80);
		//SET BUTTON VISIBILITY
		boardTL.setVisible(false);
		boardML.setVisible(false);
		boardBL.setVisible(false);
		boardTM.setVisible(false);
		boardMM.setVisible(false);
		boardMR.setVisible(false);
		boardTR.setVisible(false);
		boardBM.setVisible(false);
		boardBR.setVisible(false);
		restart.setVisible(false);
		//ADD BUTTONS TO WINDOW
		playWindow.add(cancel);
		playWindow.add(boardTL);
		playWindow.add(boardTM);
		playWindow.add(boardTR);
		playWindow.add(boardML);
		playWindow.add(boardMM);
		playWindow.add(boardMR);
		playWindow.add(boardBL);
		playWindow.add(boardBM);
		playWindow.add(boardBR);
		playWindow.add(restart);
		//ADD GRAPHICS
		playWindow.add(playerCardA);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(playerCardB);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(playerCardC);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(playerCardD);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(playerCardE);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(cpuCardA);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(cpuCardB);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(cpuCardC);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(cpuCardD);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.add(cpuCardE);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.setVisible(true);
	}
	
	//CARD VALUES DISPLAY
	public static void cardValues() {
		JComponent values = new JComponent() {
			public void paintComponent (Graphics g) {
				g.setColor(Color.WHITE);
				for (int i = 0; i < 5; i++) {
					boolean dontDraw = false;
					switch (i) {
					case 0:
						if (playerPlayedA == true) {
							dontDraw = true;
						}
						break;
					case 1:
						if (playerPlayedB == true) {
							dontDraw = true;
						}
						break;
					case 2:
						if (playerPlayedC == true) {
							dontDraw = true;
						}
						break;
					case 3:
						if (playerPlayedD == true) {
							dontDraw = true;
						}
						break;
					case 4:
						if (playerPlayedE == true) {
							dontDraw = true;
						}
						break;
					}
					if (dontDraw == false) {
						int j = (i+2)*100;
						g.drawString(playerHand[i].values[0]+"", j+55, 505);
						g.drawString(playerHand[i].values[1]+"", j+35, 525);
						g.drawString(playerHand[i].values[2]+"", j+75, 525);
						g.drawString(playerHand[i].values[3]+"", j+55, 545);
					}
				}
			}
		};
		playWindow.add(values);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.setComponentZOrder(values, 0);
		values.setVisible(true);
	}
	
	//CARD VALUES DISPLAY ON BOARD
	public static void boardValues() {
		JComponent valuesBoard = new JComponent() {
			public void paintComponent (Graphics g) {
				g.setColor(Color.WHITE);
				for (int i = 0; i < 9; i++) {
					switch (i) {
					case 0:
						if (filledTL == null) {
							break;
						} else {
							g.drawString(filledTL.values[0]+"", 245, 161); //45 x, 56 y
							g.drawString(filledTL.values[1]+"", 225, 181);
							g.drawString(filledTL.values[2]+"", 265, 181);
							g.drawString(filledTL.values[3]+"", 245, 201);
							break;
						}
					case 1:
						if (filledTM == null) {
							break;
						} else {
							g.drawString(filledTM.values[0]+"", 345, 161); //45 x, 56 y
							g.drawString(filledTM.values[1]+"", 325, 181);
							g.drawString(filledTM.values[2]+"", 365, 181);
							g.drawString(filledTM.values[3]+"", 345, 201);
							break;
						}
					case 2:
						if (filledTR == null) {
							break;
						} else {
							g.drawString(filledTR.values[0]+"", 445, 161); //45 x, 56 y
							g.drawString(filledTR.values[1]+"", 425, 181);
							g.drawString(filledTR.values[2]+"", 465, 181);
							g.drawString(filledTR.values[3]+"", 445, 201);
							break;
						}
					case 3:
						if (filledML == null) {
							break;
						} else {
							g.drawString(filledML.values[0]+"", 245, 261); //45 x, 56 y
							g.drawString(filledML.values[1]+"", 225, 281);
							g.drawString(filledML.values[2]+"", 265, 281);
							g.drawString(filledML.values[3]+"", 245, 301);
							break;
						}
					case 4:
						if (filledMM == null) {
							break;
						} else {
							g.drawString(filledMM.values[0]+"", 345, 261); //45 x, 56 y
							g.drawString(filledMM.values[1]+"", 325, 281);
							g.drawString(filledMM.values[2]+"", 365, 281);
							g.drawString(filledMM.values[3]+"", 345, 301);
							break;
						}
					case 5:
						if (filledMR == null) {
							break;
						} else {
							g.drawString(filledMR.values[0]+"", 445, 261); //45 x, 56 y
							g.drawString(filledMR.values[1]+"", 425, 281);
							g.drawString(filledMR.values[2]+"", 465, 281);
							g.drawString(filledMR.values[3]+"", 445, 301);
							break;
						}
					case 6:
						if (filledBL == null) {
							break;
						} else {
							g.drawString(filledBL.values[0]+"", 245, 361); //45 x, 56 y
							g.drawString(filledBL.values[1]+"", 225, 381);
							g.drawString(filledBL.values[2]+"", 265, 381);
							g.drawString(filledBL.values[3]+"", 245, 401);
							break;
						}
					case 7:
						if (filledBM == null) {
							break;
						} else {
							g.drawString(filledBM.values[0]+"", 345, 361); //45 x, 56 y
							g.drawString(filledBM.values[1]+"", 325, 381);
							g.drawString(filledBM.values[2]+"", 365, 381);
							g.drawString(filledBM.values[3]+"", 345, 401);
							break;
						}
					case 8:
						if (filledBR == null) {
							break;
						} else {
							g.drawString(filledBR.values[0]+"", 445, 361); //45 x, 56 y
							g.drawString(filledBR.values[1]+"", 425, 381);
							g.drawString(filledBR.values[2]+"", 465, 381);
							g.drawString(filledBR.values[3]+"", 445, 401);
							break;
						}
					}
				}
			}
		};
		playWindow.add(valuesBoard, 0);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		valuesBoard.setVisible(true);
	}
	
	//BOARD BUTTON SHOW
	public static void addBoard() {
		cancel.setVisible(true);
		if (filledTL == null) {
			boardTL.setVisible(true);
		}
		if (filledML == null) {
			boardML.setVisible(true);
		}
		if (filledBL == null) {
			boardBL.setVisible(true);
		}
		if (filledTM == null) {
			boardTM.setVisible(true);
		}
		if (filledMM == null) {
			boardMM.setVisible(true);
		}
		if (filledMR == null) {
			boardMR.setVisible(true);
		}
		if (filledTR == null) {
			boardTR.setVisible(true);
		}
		if (filledBM == null) {
			boardBM.setVisible(true);	
		}
		if (filledBR == null) {
			boardBR.setVisible(true);
		}
		
	}
	
	//BOARD BUTTON DISAPPEAR
	public static void removeBoard() {
		cardPicked = 0;
		cancel.setVisible(false);
		boardTL.setVisible(false);
		boardML.setVisible(false);
		boardBL.setVisible(false);
		boardTM.setVisible(false);
		boardMM.setVisible(false);
		boardMR.setVisible(false);
		boardTR.setVisible(false);
		boardBM.setVisible(false);
		boardBR.setVisible(false);
	}
	
	//PLACE CARD ON BOARD
	public static void placeCard() {
		//CHECK WHICH CARD WAS PLAYED AND REMOVE FROM HAND
		switch (cardPicked) {
		case 0:
			playWindow.remove(playerCardA);
			playerPlayedA = true;
			break;
		case 1:
			playWindow.remove(playerCardB);
			playerPlayedB = true;
			break;
		case 2:
			playWindow.remove(playerCardC);
			playerPlayedC = true;
			break;
		case 3:
			playWindow.remove(playerCardD);
			playerPlayedD = true;
			break;
		case 4:
			playWindow.remove(playerCardE);
			playerPlayedE = true;
			break;
		}
		//PLACE CARD ON BOARD
		switch (cardPlaced) {
		case 1:
			playWindow.add(playerCardTL);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledTL = playerHand[cardPicked];
			break;
		case 2:
			playWindow.add(playerCardTM);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledTM = playerHand[cardPicked];
			break;
		case 3:
			playWindow.add(playerCardTR);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledTR = playerHand[cardPicked];
			break;
		case 4:
			playWindow.add(playerCardML);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledML = playerHand[cardPicked];
			break;
		case 5:
			playWindow.add(playerCardMM);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledMM = playerHand[cardPicked];
			break;
		case 6:
			playWindow.add(playerCardMR);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledMR = playerHand[cardPicked];
			break;
		case 7:
			playWindow.add(playerCardBL);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledBL = playerHand[cardPicked];
			break;
		case 8:
			playWindow.add(playerCardBM);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledBM = playerHand[cardPicked];
			break;
		case 9:
			playWindow.add(playerCardBR);
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			filledBR = playerHand[cardPicked];
			break;
		}
		boardValues();
		flipCard(cardPlaced, playerHand[cardPicked], true);
		cardPlaced = 0; //RESET CARD LOCATION SELECTION
		scorePlayer++; //INCREASE PLAYER'S SCORE BY 1
	}
	
	//CHECK FOR FLIPS
	public static void flipCard(int location, NormalCard compare, boolean playerTurn) {
		switch (location) {
		case 1: //Top Left
			if (filledTM != null && filledTL != null) { //CHECK RIGHT
				if (filledTL.values[2] > filledTM.values[1]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTM);
						playWindow.add(playerCardTM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTM);
						playWindow.add(cpuCardTM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledML != null && filledTL != null) { //CHECK BELOW
				if (filledTL.values[3] > filledML.values[0]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardML);
						playWindow.add(playerCardML, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedML == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardML);
						playWindow.add(cpuCardML, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedML == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 2: //Top Middle
			if (filledTM != null && filledTR != null) { //CHECK RIGHT
				if (filledTM.values[2] > filledTR.values[1]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTR);
						playWindow.add(playerCardTR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTR == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTR);
						playWindow.add(cpuCardTR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTR == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledTM != null && filledMM != null) { //CHECK BELOW
				if (filledTM.values[3] > filledMM.values[0]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMM);
						playWindow.add(playerCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMM);
						playWindow.add(cpuCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledTM != null && filledTL != null) { //CHECK LEFT
				if (filledTM.values[1] > filledTL.values[2]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTL);
						playWindow.add(playerCardTL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTL);
						playWindow.add(cpuCardTL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 3: //Top Right
			if (filledTR != null && filledMR != null) { //CHECK BELOW
				if (filledTR.values[3] > filledMR.values[0]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMR);
						playWindow.add(playerCardMR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMR == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMR);
						playWindow.add(cpuCardMR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMR == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledTR != null && filledTM != null) { //CHECK LEFT
				if (filledTR.values[1] > filledTM.values[2]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTM);
						playWindow.add(playerCardTM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTM);
						playWindow.add(cpuCardTM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 4: //Middle Left
			if (filledML != null && filledMM != null) { //CHECK RIGHT
				if (filledML.values[2] > filledMM.values[1]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMM);
						playWindow.add(playerCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMM);
						playWindow.add(cpuCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledML != null && filledBL != null) { //CHECK BELOW
				if (filledML.values[3] > filledBL.values[0]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBL);
						playWindow.add(playerCardBL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBL == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardBL);
						playWindow.add(cpuCardBL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBL == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledML != null && filledTL != null) { //CHECK TOP
				if (filledML.values[0] > filledTL.values[3]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTL);
						playWindow.add(playerCardTL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTL);
						playWindow.add(cpuCardTL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTL == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 5: //Center
			if (filledMM != null && filledMR != null) { //CHECK RIGHT
				if (filledMM.values[2] > filledMR.values[1]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMR);
						playWindow.add(playerCardMR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMR == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMR);
						playWindow.add(cpuCardMR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMR == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledMM != null && filledBM != null) { //CHECK BELOW
				if (filledMM.values[3] > filledBM.values[0]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBM);
						playWindow.add(playerCardBM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBM == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardBM);
						playWindow.add(cpuCardBM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBM == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledMM != null && filledML != null) { //CHECK LEFT
				if (filledMM.values[1] > filledML.values[2]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardML);
						playWindow.add(playerCardML, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedML == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardML);
						playWindow.add(cpuCardML, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedML == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledMM != null && filledTM != null) { //CHECK TOP
				if (filledMM.values[0] > filledTM.values[3]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTM);
						playWindow.add(playerCardTM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTM == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTM);
						playWindow.add(cpuCardTM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTM == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 6: //Middle Right
			if (filledMR != null && filledBR != null) { //CHECK BELOW
				if (filledMR.values[3] > filledBR.values[0]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBR);
						playWindow.add(playerCardBR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBR == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardBR);
						playWindow.add(cpuCardBR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBR == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledMR != null && filledMM != null) { //CHECK LEFT
				if (filledMR.values[1] > filledMM.values[2]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMM);
						playWindow.add(playerCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMM);
						playWindow.add(cpuCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledMR != null && filledTR != null) { //CHECK TOP
				if (filledMR.values[0] > filledTR.values[3]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardTR);
						playWindow.add(playerCardTR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTR == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardTR);
						playWindow.add(cpuCardTR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedTR == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 7: //Bottom Left
			if (filledBL != null && filledBM != null) { //CHECK RIGHT
				if (filledBL.values[2] > filledBM.values[1]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBM);
						playWindow.add(playerCardBM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBM == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardBM);
						playWindow.add(cpuCardBM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBM == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledBL != null && filledML != null) { //CHECK TOP
				if (filledBL.values[0] > filledML.values[3]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardML);
						playWindow.add(playerCardML, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedML == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardML);
						playWindow.add(cpuCardML, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedML == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			break;
		case 8: //Bottom Middle
			if (filledBM != null && filledBR != null) { //CHECK RIGHT
				if (filledBM.values[2] > filledBR.values[1]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBR);
						playWindow.add(playerCardBR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBR == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardBR);
						playWindow.add(cpuCardBR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBR == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledBM != null && filledBL != null) { //CHECK LEFT
				if (filledBM.values[1] > filledBL.values[2]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBL);
						playWindow.add(playerCardBL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBL == 2) {
							scorePlayer++;
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardBL);
						playWindow.add(cpuCardBL, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBL == 1) {
							scoreCPU++;
							scorePlayer--;
						}
					}
				}
			}
			if (filledBM != null && filledMM != null) { //CHECK TOP
				if (filledBM.values[0] > filledMM.values[3]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMM);
						playWindow.add(playerCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 2) {
						scorePlayer++;
						scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMM);
						playWindow.add(cpuCardMM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMM == 1) {
						scoreCPU++;
						scorePlayer--;
						}
					}
				}
			}
			break;
		case 9: //Bottom Right
			if (filledBR != null && filledBM != null) { //CHECK LEFT
				if (filledBR.values[1] > filledBM.values[2]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardBM);
						playWindow.add(playerCardBM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						scorePlayer++; 
						scoreCPU--;
					} else {
						playWindow.remove(playerCardBM);
						playWindow.add(cpuCardBM, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedBM == 2) {
							scoreCPU++;
							scorePlayer--;
						}
						
					}
				}
			}
			if (filledBR != null && filledMR != null) { //CHECK TOP
				if (filledBR.values[0] > filledMR.values[3]) {
					if (playerTurn == true) {
						playWindow.remove(cpuCardMR);
						playWindow.add(playerCardMR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMR == 2) {

							scorePlayer++; 
							scoreCPU--;
						}
					} else {
						playWindow.remove(playerCardMR);
						playWindow.add(cpuCardMR, 1);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						if (ownedMR == 1) {
						scoreCPU++;
						scorePlayer--;
						}
					}
				}
			}
			break;
		}
	}
	
	
	//END PLAYER TURN
	public static void endPlayer() {
		placeCard();
		cardPicked = 0;
		removeBoard();
		playerTurn = false;
    	cpuTurn();
    	cardValues();
	}
		//CPU TURN
	public static void cpuTurn() {
		//CHECK IF ALL SLOTS ARE FILLED
		if (filledTL != null && filledTM != null && filledTR != null && filledML != null && filledMM != null && filledMR != null && filledBL != null && filledBM != null && filledBR != null) {
			endGame();
		} else {
			//RANDOMIZE CARD CHOICE AND BOARD LOCATION
			cpuPicked = (int) (Math.random() * (5));
			cpuPlaced = (int) (Math.random() * (10 - 1) + 1);
			int i = cpuPicked+1; //TO DETERMINE WHICH CARD IS CHOSEN WITHOUT RESETTING IT AFTER
			while (i != 0) {
				switch (i) {
				case 1:
					if (cpuPlayedA == false) {
						cpuPlayedA = true;
						playWindow.remove(cpuCardA);
						i = 0;
						break;
					} else {
						i++;
						break;
					}
				case 2:
					if (cpuPlayedB == false) {
						cpuPlayedB = true;
						playWindow.remove(cpuCardB);
						i = 0;
						break;
					} else {
						i++;
						break;
					}
				case 3:
					if (cpuPlayedC == false) {
						cpuPlayedC = true;
						playWindow.remove(cpuCardC);
						i = 0;
						break;
					} else {
						i++;
						break;
					}
				case 4:
					if (cpuPlayedD == false) {
						cpuPlayedD = true;
						playWindow.remove(cpuCardD);
						i = 0;
						break;
					} else {
						i++;
						break;
					}
				case 5:
					if (cpuPlayedE == false) {
						cpuPlayedE = true;
						playWindow.remove(cpuCardE);
						i = 0;
						break;
					} else {
						i = 1;
						break;
					}
				}
			}
			playWindow.getContentPane().validate();
			playWindow.getContentPane().repaint();
			//PLACE CARD ON BOARD
			while (cpuPlaced != 0) {
				switch (cpuPlaced) {
				case 1:
					if (filledTL == null) {
						playWindow.add(cpuCardTL);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledTL = cpuHand[cpuPicked];
						playWindow.remove(boardTL);
						ownedTL = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 2:
					if (filledTM == null) {
						playWindow.add(cpuCardTM);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledTM = cpuHand[cpuPicked];
						playWindow.remove(boardTM);
						ownedTM = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 3:
					if (filledTR == null) {
						playWindow.add(cpuCardTR);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledTR = cpuHand[cpuPicked];
						playWindow.remove(boardTR);
						ownedTR = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 4:
					if (filledML == null) {
						playWindow.add(cpuCardML);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledML = cpuHand[cpuPicked];
						playWindow.remove(boardML);
						ownedML = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 5:
					if (filledMM == null) {
						playWindow.add(cpuCardMM);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledMM = cpuHand[cpuPicked];
						playWindow.remove(boardMM);
						ownedMM = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 6:
					if (filledMR == null) {
						playWindow.add(cpuCardMR);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledMR = cpuHand[cpuPicked];
						playWindow.remove(boardMR);
						ownedMR = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 7:
					if (filledBL == null) {
						playWindow.add(cpuCardBL);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledBL = cpuHand[cpuPicked];
						playWindow.remove(boardBL);
						ownedBL = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 8:
					if (filledBM == null) {
						playWindow.add(cpuCardBM);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledBM = cpuHand[cpuPicked];
						playWindow.remove(boardBM);
						ownedBM = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced++;
						break;
					}
				case 9:
					if (filledBR == null) {
						playWindow.add(cpuCardBR);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledBR = cpuHand[cpuPicked];
						playWindow.remove(boardBR);
						ownedBR = 2;
						cpuPlaced = 0;
						break;
					} else {
						cpuPlaced = 1;
						break;
					}
				case 10:
					if (filledBR == null) {
						playWindow.add(cpuCardBR);
						playWindow.getContentPane().validate();
						playWindow.getContentPane().repaint();
						filledBR = cpuHand[cpuPicked];
						playWindow.remove(boardBR);
						cpuPlaced = 0;
						ownedBR = 2;
						break;
					} else {
						cpuPlaced = 1;
						break;
					}
				}
				
			}
		}
		boardValues();
		flipCard(cpuPicked, cpuHand[cpuPicked], false);
		cpuPicked = 0;	//RESET CPU CHOICE
		scoreCPU++; //INCREASE CPU SCORE BY 1
		playerTurn = true; //PLAYER'S TURN
	}
	//END GAME
	public static void endGame() {
		if (scorePlayer > scoreCPU) {
			winner += "the Player!";
		} else {
			winner += "the CPU!";
		}
		winner += " PLAYER: "+scorePlayer+" CPU: "+scoreCPU;
		JComponent winnerText = new JComponent() {
			public void paintComponent (Graphics g) {
				g.setColor(Color.BLACK);
				g.drawString(winner, 250, 490);
			}
		};
		playWindow.add(winnerText);
		playWindow.getContentPane().validate();
		playWindow.getContentPane().repaint();
		playWindow.setComponentZOrder(winnerText, 0);
		winnerText.setVisible(true);
		restart.setBounds(250, 475, 200, 80);
		restart.setVisible(true);
	}

	public static void main(String[] args) {
		startup();
		cardValues();
		//ACTION LISTENERS
		//CARDS
		playWindow.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				Rectangle cardA = new Rectangle(220, 489, 80, 100);
				Rectangle cardB = new Rectangle(320, 489, 80, 100);
				Rectangle cardC = new Rectangle(420, 489, 80, 100);
				Rectangle cardD = new Rectangle(520, 489, 80, 100);
				Rectangle cardE = new Rectangle(620, 489, 80, 100);
				if (cardA.contains(e.getPoint())) {
					addBoard();
					cardValues();
					cancel.setVisible(false);
					cancel.setBounds(210, 439, 80, 20);
					cancel.setVisible(true);
					cardPicked = 0;
				} else if (cardB.contains(e.getPoint())) {
					addBoard();
					cardValues();
					cancel.setVisible(false);
					cancel.setBounds(310, 439, 80, 20);
					cancel.setVisible(true);
					cardPicked = 1;
				} else if (cardC.contains(e.getPoint())) {
					addBoard();
					cardValues();
					cancel.setVisible(false);
					cancel.setBounds(410, 439, 80, 20);
					cancel.setVisible(true);
					cardPicked = 2;
				} else if (cardD.contains(e.getPoint())) {
					addBoard();
					cardValues();
					cancel.setVisible(false);
					cancel.setBounds(510, 439, 80, 20);
					cancel.setVisible(true);
					cardPicked = 3;
				} else if (cardE.contains(e.getPoint())) {
					addBoard();
					cardValues();
					cancel.setVisible(false);
					cancel.setBounds(610, 439, 80, 20);
					cancel.setVisible(true);
					cardPicked = 4;
				}
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		//CANCEL BUTTON
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeBoard();
				cardValues();
				cancel.setBounds(0, 0, 0, 0);
			}
		});
		//BOARD TOP LEFT
		boardTL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardTL);
            	cardPlaced = 1;
            	ownedTL = 1;
            	filledTL = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD TOP MIDDLE
		boardTM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardTM);
            	cardPlaced = 2;
            	ownedTM = 1;
            	filledTM = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD TOP RIGHT
		boardTR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardTR);
            	cardPlaced = 3;
            	ownedTR = 1;
            	filledTR = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD MID LEFT
		boardML.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardML);
            	cardPlaced = 4;
            	ownedML = 1;
            	filledML = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD CENTER
		boardMM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardMM);
            	cardPlaced = 5;
            	ownedMM = 1;
            	filledMM = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD MID RIGHT
		boardMR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardMR);
            	cardPlaced = 6;
            	ownedMR = 1;
            	filledMR = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD BOTTOM LEFT
		boardBL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardBL);
            	cardPlaced = 7;
            	ownedBL = 1;
            	filledBL = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD BOTTOM MIDDLE
		boardBM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardBM);
            	cardPlaced = 8;
            	ownedBM = 1;
            	filledBM = playerHand[cardPicked];
            	endPlayer();
            }
		});
		//BOARD BOTTOM RIGHT
		boardBR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	playWindow.remove(boardBR);
            	cardPlaced = 9;
            	ownedBR = 1;
            	filledBR = playerHand[cardPicked];
            	endPlayer();
            }
		});
	    //RESTART GAME
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playWindow.dispose();
			}
		});
	}

}
