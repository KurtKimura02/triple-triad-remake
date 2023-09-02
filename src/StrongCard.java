//Kurt Kimura, Lab Section 02
public class StrongCard extends NormalCard {
	final int totalValue = 12;
	int strongest = 0;
	int weakest = 0;
	
	public StrongCard() {
		super();
		for (int i = 0; i < 3; i++) {
			if (super.values[i] > super.values[strongest]) {
				strongest = i;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (super.values[i] < super.values[weakest]) {
				weakest = i;
			}
		}
		super.values[strongest] += 3;
		for (int i = 0; i < 4; i++) {
			if (i != strongest && i != weakest) {
				super.values[i] += super.values[weakest];
				break;
			}
		}
		super.values[weakest] -= super.values[weakest];
	}
	
	public boolean validTotal() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += values[i];
		}
		if (sum != totalValue) {
			return false;
		} else {
			return true;
		}
	}
}
