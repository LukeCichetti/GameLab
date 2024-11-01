
public class Combination extends Item {
	
	public Combination(String name2, String description2) {
		super(name2, description2);
	}
	public void use() {
		Game.print("You can't open that");
	}
}
