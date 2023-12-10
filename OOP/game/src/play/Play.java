package play;
import java.util.ArrayList;
import java.util.List;

import player.Player;
import player.VirtualPlayer;
import refegee.Refegee;

public class Play {
	public static void main(String[] args) {
		List<Player> players = new ArrayList<>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));
		players.add(new Player("Player 3"));
		players.add(new VirtualPlayer());
		
	    Refegee refegee = new Refegee(players);
	    refegee.startGame();
	}
}
