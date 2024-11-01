
public class Safe extends Item {

	public Safe (String name, String description) {
		super(name, description);
	}

	public void open() {
		for (Item d : Game.inventory) {
			if (d.toString().equals("combination")) {
				Game.print("You use the combination and open the safe to a diamond, and take it");
				Item diamond = new Item("Diamond", "This is a beautiful diamond");
				Game.inventory.add(diamond);

			}
			else {
				Game.print("The safe is locked and you can't figure out the combination");
			}
		}
	}
}

