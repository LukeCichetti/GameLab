import java.util.Scanner;
import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		runGame();
	}
	
	private static ArrayList<Item> inventory = new ArrayList<>();

public static void runGame() {
	Room currentRoom = World.buildWorld();
	Scanner input = new Scanner(System.in);
	String command;
	do {
		System.out.println(currentRoom);
		System.out.println("Where do you want to go? ");
		command = input.nextLine();
		String[] words = command.split(" ");

		switch(words[0]) {
		case "e":
		case "w":
		case "n":
		case "s":
		case "u":
		case "d":
			Room nextRoom = currentRoom.getExit(command.charAt(0));
			if(nextRoom == null)
			System.out.println("You cant go that way");
			else
				currentRoom = nextRoom;
			break;
		case "x":
			System.out.println("Thanks for walking through my game!");
			break;
		case "take":
			if (words.length > 1) {
			System.out.println("You are trying to take the"+words[1]+".");
			Item i = currentRoom.getItem(words [1]);
			if(i == null)
				System.out.println("There is nothing to take here");
			else {
				currentRoom.addItem(null, null);
				inventory.add(i);
				System.out.println("You pick up the "+i.getName()+".");
			}
				break;
		case "look":
			if (currentRoom.getItem(words[1])!=null){ 
			System.out.println(currentRoom.getItem(words[1]).getDescription());
			}
			else if(currentRoom.getItem(words[1])==null) {
				for(Item y : inventory) {
					if(y.getName().equals(words[1])) {
						System.out.println(y.getDescription());
						break;
						
					}
				}
			}
			
				System.out.println("Item is not in this room or your inventory");
			}
			break;
			
			
		case "i":
			if(inventory.size()==0) {
				System.out.println("You have nothing in your inventory");
			}else {
				System.out.println("You are carrying: ");
				for(Item item : inventory) {
					System.out.println(item.getName());
				}
			}
				break;
			}
			


		
	while(!command.equals("x"));

	input.close();

	System.out.println("\nNow we'll move east!");
	currentRoom = currentRoom.getExit('e');
	System.out.println(currentRoom);
	System.out.println("\nNow we'll move west!");
	currentRoom = currentRoom.getExit('w');
	System.out.println(currentRoom);
	}
	private static Item getInventoryItem(String itemName) {
		for(Item item : inventory) {
		if(item.getName().equalsIgnoreCase(itemName)) {
		return item;
		}
		return null;
	}
	}
	public static void takeItem(Room room){
		Item item = room.getItem();
		if(item != null) {
			inventory.add(item);
			room.setItem(null);
			System.out.println ("You have acquired the" + item.getName());
		} else{
			System.out.println("No items available here here");
	}
}

	public static void showInventory() {
		if (inventory.isEmpty()) {
			System.out.println("You are carrying nothing.");
		} else {
			System.out.println("You have ");
			for (Item item : inventory) {
				System.out.println("- " + item.getName());
			}
		}
	}
}