package game;

import java.util.Random;

public class Dice {
	private static final int SIDES = 6;
    private static final double NORMAL_PROBABILITY = 0.16;
    private static final double SPECIAL_PROBABILITY = 0.20;
    
    private Random random;
    
	public Dice() {
		this.random = new Random();
	}
	
	public int roll(int turn) {
		double probability = random.nextDouble();
		if (probability < SPECIAL_PROBABILITY) {
			return turn;
		} else {
			int thisTurn = random.nextInt(SIDES - 1) + 1;
			if (thisTurn >= turn) thisTurn++;
			return thisTurn;
		}
	}
	
}
