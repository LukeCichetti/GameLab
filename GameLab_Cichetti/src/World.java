
public class World {

	public static Room buildWorld() {
		Room yard = new Room("This is the prison yard.", "Prison Yard");

		Room messhall = new Room("You are in an empty messhall.", "Messhall");
		Item shank = new Item("Shank", "You now have a prisoner's shank. This could be usefull.");
		Item SlopTray = new Item("SlopTray", "You now have a tray that the inmates ate on");
		Item Spoon = new Item("Spoon", "You now have a spoon. Maybe an escape tool.");

		Room cellblock = new Room("This is the abandoned cellblock.", "cellblock");
		Item key = new Item("Key", "You got a key. Is this the key to freedom?");
		
		Room cell = new Room("Inside where the prisoners served their sentence", "Cell");

		Room wardensoffice = new Room("You are in the cramped and messy Warden's office.","Warden's Office");
		Item Paperclips = new Item("Box of paper clips",
				"You found a box of paper clips, You remember your lock picking experience");
		Safe safe = new Safe("safe", "It's an impressive safe!");

		Room exit = new Room("This is the way to freedom, but it is locked.", "Exit");

		Room weightroom = new Room("This is the upstairs weightroom.", "Weightroom");
		Item Dumbell = new Item("60 pound dumbell", "You found a dumbell, might be usefull for breaking something");

		Room wardensbathroom = new Room("The warden's personal latrine and shower.", "Warden's Bathroom");
		Combination combination = new Combination("Combination", "This is a combination for something");

		yard.addExit(messhall, 'e');

		messhall.addExit(yard, 'w');

		yard.addExit(cellblock, 'w');

		cellblock.addExit(yard, 'e');

		yard.addExit(wardensoffice, 'n');

		wardensoffice.addExit(yard, 's');

		yard.addExit(exit, 's');

		yard.addExit(weightroom, 'u');

		wardensoffice.addExit(yard, 'd');

		wardensoffice.addExit(wardensbathroom, 'w');

		messhall.addItem(shank.getName(), shank);

		messhall.addItem(SlopTray.getName(), SlopTray);

		messhall.addItem(Spoon.getName(), Spoon);

		wardensoffice.addItem(Paperclips.getName(), Paperclips);

		wardensoffice.addItem(safe.getName(), safe);

		weightroom.addItem(Dumbell.getName(), Dumbell);

		wardensbathroom.addItem(combination.getName(), combination);
		
		cell.addItem(key.getName(), key);

		return yard;
	}

}
