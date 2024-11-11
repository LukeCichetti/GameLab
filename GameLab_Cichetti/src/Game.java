
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static ArrayList<Item> inventory = new ArrayList<Item>();

	public static Room currentRoom = World.buildWorld();

	public static Item getItemInventory(String o) {
		for (Item t : inventory)
			if (t.toString().equals(o))
				return t;
		return null;
	}

	public static void print(Object obj) {
		System.out.println(obj.toString());
	}

	public static void main(String[] args) {
		runGame();
	}
	

	public static void runGame() {
		Scanner input = new Scanner(System.in);

		String command;
		do {
			System.out.println(currentRoom);
			System.out.println("Where would you like to go?");
			command = input.nextLine();
			String[] words = command.split(" ");

			switch (words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if (nextRoom == null) {
					System.out.println("You are unable to go that way.");
				}
					else if (nextRoom.isLock()) {
					System.out.println("This way is locked.");
				} else {
					currentRoom = nextRoom;
				}
				break;
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			case "i":
				if (inventory.size() == 0) {
					System.out.println("You do not have any items");
				} else {
					System.out.println(inventory.toString());
				}
				break;
			case "use":
				System.out.println("You are trying to use the" + words[1]);
				Item itemToUse = getItemInventory(words[1]);
				if (itemToUse != null) {
					itemToUse.use();
				} else if (currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).use();
				} else {
					System.out.println("You do not have this item.");
				}
				break;
			case "open":
				System.out.println("You are trying to open the" + words[1]);
				Item itemToOpen = getItemInventory(words[1]);
				if (itemToOpen != null) {
					itemToOpen.open();
				} else if (currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).open();
				} else {
					System.out.println("You do not have that item");
				}
				break;
			case "take":
				System.out.println("You are trying to take the" + words[1]);
				Item i = currentRoom.getItem(words[1]);
				if (i == null) {
					System.out.println("There is no item to take");
				} else {
					inventory.add(i);
					currentRoom.removeItem(words[1]);
					System.out.println("You are now carrying the " + i);
				}
				break;
			case "look":
				if (currentRoom.getItem(words[1]) != null) {
					System.out.println(currentRoom.getItem(words[1]).getDescription());
				} else {
					for (Item y : inventory) {
						if (y.getName().equals(words[1])) {
							System.out.println(y.getDescription());
							break;
						}
					}
					System.out.println("The item is not in this room or your inventory");

				}
				break;
			default:
				System.out.println("I don't know what that means.");
				break;
			}
		} while (!command.equals("x"));

		input.close();
	}
}
