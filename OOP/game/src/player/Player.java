package player;

public class Player {
	private static int TURN_PLAY = 1;
	private boolean isVirtual;
	private String name;
	private int turn;
	private int score;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.isVirtual = false;
		setTurn();
	}
	
	public void displayInfo() {
		System.out.println("Player: " + name + ", Score: " + score + "\n");
	}

	public String getName() {
		return name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setTurn() {
		if (TURN_PLAY <= 4) {
			this.turn = TURN_PLAY;
			TURN_PLAY++;
		}
	}
	
	public boolean isVirtual() {
		return isVirtual;
	}

	public void setVirtual(boolean isVirtual) {
		this.isVirtual = isVirtual;
	}

	public int getTurn() {
		return turn;
	}
	
	
}
