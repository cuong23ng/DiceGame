package refegee;
import java.util.List;
import java.util.Scanner;

import game.Dice;
import player.Player;
import player.VirtualPlayer;

public class Refegee {
	private List<Player> players;
	private Dice dice;
	
	public Refegee(List<Player> players) {
		this.players = players;
		this.dice = new Dice();
	}
	
	public void startGame() {
		
		System.out.println("Choose player: ");
		System.out.println("--------------------------------");
		System.out.println("1. Player 1");
		System.out.println("2. Player 2");
		System.out.println("3. Player 3");
		System.out.println("3. Player 4");
		System.out.println("--------------------------------");
		
		int r = 1;
		while (true) {
			boolean mark[] = new boolean[4];
			mark[0] = mark[1] = mark[2] = mark[3] = false;
			System.out.println("***ROUND " + (r++) + "***");
			
			int i = 0;
			while (i < 4) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please choose a number: 1-2-3-4: ");
				int cmd = scanner.nextInt();
				
				if (mark[cmd - 1] == false) {
					mark[cmd - 1] = true;
					if(players.get(cmd - 1).isVirtual() == false) {
						System.out.println("Roll the dice?: Y/N");
						char choice = scanner.next().charAt(0);
						if (choice == 'Y') {
							playerTurn(players.get(cmd - 1));
							i++;
						} else {
							System.out.println("It's " + players.get(cmd - 1).getName() + "'s turn.");
							System.out.println(players.get(cmd - 1).getName() + " rolled: " + 0);
							players.get(cmd - 1).displayInfo();
							i++;
							continue;
						}
						
					} else {
						playerTurn(players.get(cmd - 1));
						i++;
					}
				}
				
				if (isGameFinished(players.get(cmd - 1))) {
                    announceWinner(players.get(cmd - 1));
                    return;
                }
			}
		}
	}
	
	private void playerTurn(Player player) {
		System.out.println("It's " + player.getName() + "'s turn.");
		int rollResult = dice.roll(player.getTurn());
		System.out.println(player.getName() + " rolled: " + rollResult);
		player.setScore((player.getScore() + rollResult) < 22 ? (player.getScore() + rollResult) : 0);
		player.displayInfo();
	}
	
	private boolean isGameFinished(Player player) {
		if (player.getScore() == 21) {
			return true;
		}
		return false;
	}
	
	private void announceWinner(Player player) {
		System.out.println(player.getName() + " wins");
		for (Player loser : this.players) {
			if (loser.equals(player)) continue;
			
			if (loser instanceof VirtualPlayer && ((VirtualPlayer) loser).isVirtual()) {
	            ((VirtualPlayer) loser).expressDefeat();
	        }
		}
	}
	
}
