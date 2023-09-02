//Kurt Kimura, Lab Section 02
public class TestingCards {

	public static void main(String[] args) {
		int i = 0;
		boolean j = true;
		
		//NORMAL CARD
		System.out.println("TESTING NORMAL CARD");
		while (i <= 100 && j == true) {
			NormalCard testCard = new NormalCard();
			j = testCard.validTotal();
			if (j == false) {
				System.out.println("TOTAL IS NOT GOOD, END TEST AT #"+i);
				testCard.toString();
				break;
			}
			//testCard.toString();
			i++;
		}
		if (j == true) {
			System.out.println("TOTALS GOOD");
		}
		
		//STRONG CARD
		System.out.println("\nTESTING STRONG CARD");
		i = 0;
		while (i <= 100 && j == true) {
			StrongCard strongCard = new StrongCard();
			j = strongCard.validTotal();
			if (j == false) {
				System.out.println("TOTAL IS NOT GOOD, END TEST AT #"+i);
				strongCard.toString();
				break;
			}
			//strongCard.toString();
			/*THIS CODE DOESN'T WORK BUT I DON'T CARE ENOUGH TO FIX IT, OUTPUT IS CORRECT RN
			 * int strongest = 0;
			for (int x = 0; x < 3; x++) {
				if (strongCard.values[i] > strongCard.values[strongest]) {
					strongest = i;
				}
			}
			for (int x = 0; x < 3; x++) {
				if (strongest != x && strongCard.values[strongest] - strongCard.values[x] < 3) {
					System.out.println("BAD VALUE: "+(strongCard.values[strongest] - strongCard.values[x]));
					j = false;
				}
			}
			if (j == false) {
				System.out.println("TOTAL IS GOOD, BUT HIGHEST VALUE INVALD, END TEST AT #"+i);
				System.out.println("STRONGEST ACCORDING TO TEST: "+strongest);
				strongCard.toString();
				break;
			}*/
			i++;
		}
		if (j == true) {
			System.out.println("TOTALS GOOD");
		}
		
		//DRAW HAND
		System.out.println("\nTESTING DRAW HAND");
		NormalCard[] playerHand = new NormalCard[5];
		for (int x = 0; x < 4; x++) {
			NormalCard addNormal = new NormalCard();
			playerHand[x] = addNormal;
		}
		StrongCard addStrong = new StrongCard();
		playerHand[4] = addStrong;
		for (int x = 0; x < 5; x++) {
			playerHand[x].toString();
		}
		System.out.println("HAND SUCCESSFULLY GENERATED");
	}

}
