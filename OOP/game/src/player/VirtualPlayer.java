package player;
public class VirtualPlayer extends Player {
	private static int index = 1;
	
	public VirtualPlayer() {
		super("Virtual Player " + (index++));
		this.setVirtual(true);
	}
	
	public void expressDefeat() {
        System.out.println("Virtual player " + this.getName() + " loses.");
    }
	
}
