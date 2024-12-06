
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class Game {
	
	public static void main(String[] args) {
		roomfile();
		ui = new Interface();
		print(currentRoom);
	}
	private static Interface ui;
	
	public static HashMap<String, Room>roomMap = new HashMap<String, Room>();

	public static void saveGame(String saveload) {
		File s = new File(saveload);
		try {
			FileOutputStream fos = new FileOutputStream(s);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(roomMap);
			stream.close();
		} catch (FileNotFoundException e) {
			Game.print("File "+saveload+"not found");
		} catch (IOException e) {
			Game.print("Error saving the game");
		}
	}

	public static void loadGame(String saveload) {
		File s = new File(saveload);
		try {
			FileInputStream fos = new FileInputStream(s);
			ObjectInputStream stream = new ObjectInputStream(fos);
			currentRoom = (Room) stream.readObject();
			inventory = (ArrayList<Item>) stream.readObject();
			roomMap = (HashMap<String, Room>) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			Game.print("File " + saveload + "not found");
		} catch (IOException e) {
			Game.print("Error loading the game");
		} catch (ClassNotFoundException e) {
			Game.print("Class not found while loading the game");
		}

	}


	static HashMap<String, String> roomFile = new HashMap();

	public static void roomfile() {
		try {
			Scanner input = new Scanner(new File("TextFileRooms"));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String line2 = input.nextLine();
				input.nextLine();
				roomFile.put(line, line2);
			}
			input.close();
		} catch (FileNotFoundException e) {
			Game.print("FileNotFoundException");
		}
	}

	public static ArrayList<Item> inventory = new ArrayList<Item>();

	public static Scanner input = new Scanner(System.in);

	public static Room currentRoom = World.buildWorld();

	public static Item getItemInventory(String o) {
		for (Item t : inventory)
			if (t.toString().equals(o))
				return t;
		return null;
	}

	public static void print(Object obj) {
		ui.gameTextArea.append(obj.toString()+"\n");
	}

	

	public static void processCommand(String command) {

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
					Game.print("You are unable to go that way.");
				} else if (nextRoom.isLock()) {
					Game.print("This way is locked.");
				} else {
					currentRoom = nextRoom;
					Game.print(currentRoom);
				}
				break;
			case "x":
				Game.print("Thanks for walking through my game!");
				break;
			case "i":
				if (inventory.size() == 0) {
					Game.print("You do not have any items");
				} else {
					Game.print(inventory.toString());
				}
				break;
			case "use":
				Game.print("You are trying to use the" + words[1]);
				Item itemToUse = getItemInventory(words[1]);
				if (itemToUse != null) {
					itemToUse.use();
				} else if (currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).use();
				} else {
					Game.print("You do not have this item.");
				}
				break;
			case "open":
				Game.print("You are trying to open the" + words[1]);
				Item itemToOpen = getItemInventory(words[1]);
				if (itemToOpen != null) {
					itemToOpen.open();
				} else if (currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).open();
				} else {
					Game.print("You do not have that item");
				}
				break;
			case "take":
				Game.print("You are trying to take the" + words[1]);
				Item i = currentRoom.getItem(words[1]);
				if (i == null) {
					Game.print("There is no item to take");
				} else {
					inventory.add(i);
					currentRoom.removeItem(words[1]);
					Game.print("You are now carrying the " + i);
				}
				break;
			case "look":
				if (currentRoom.getItem(words[1]) != null) {
					Game.print(currentRoom.getItem(words[1]).getDescription());
				} else {
					for (Item y : inventory) {
						if (y.getName().equals(words[1])) {
							Game.print(y.getDescription());
							break;
						}
					}
					Game.print("The item is not in this room or your inventory");

				}
				break;
			case "talk":
				currentRoom.getNPC(words[1]).talk();
				Game.print("The item is no puppy to talk to here");
				break;
			default:
				Game.print("I don't know what that means.");
				break;
			}
		
	}
}
