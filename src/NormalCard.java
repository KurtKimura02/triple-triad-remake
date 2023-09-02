//Kurt Kimura, Lab Section 02
public class NormalCard {
	final int totalValue = 9;
	Integer values[] = new Integer[4];
	
	public NormalCard() {
		int remaining = totalValue;
		int max = 7;
		for (int i = 0; i < 4; i++) {
			if (remaining < 7) {
				max = remaining;
			}
			int adding = (int) (Math.random() * (max - 1) + 1);
			if (i == 3 && remaining == 0) {
				int strongest = 0;
				values[3] = 0;
				for (int j = 0; j < 3; j++) {
					if (values[j] < values[j+1]) {
						strongest = j+1;
					}
				}
				values[strongest] -= 1;
				values[3] = 1;
			} else if (i == 3) {
				values[i] = remaining;
				remaining -= adding;
			} else {
				values[i] = adding;
				remaining -= adding;
			}
		}
	}
	
	public String toString() {
		for (int i = 0; i < 4; i++) {
			System.out.print(String.valueOf(values[i])+" ");
		}
		System.out.println();
		return null;
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