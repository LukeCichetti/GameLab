
public class World {

	public static Room buildWorld() {
		Room yard = new Room("This is the prison yard.");
		
		Room messhall = new Room("You are in an empty messhall.");
		Item shank = new Item("Shank", "You now have a prisoner's shank. This could be usefull.");
		Item SlopTray = new Item("SlopTray", "You now have a tray that the inmates ate on");
		Item Spoon = new Item("Spoon", "You now have a spoon. Maybe an escape tool.");
		
		Room cellblock = new Room("This is the abandoned cellblock.");
		
		Room wardensoffice = new Room("You are in the cramped and messy Warden's office.");
		Item Paperclips = new Item("Box of paper clips", "You found a box of paper clips, You remember your lock picking experience");
		
		Room exit = new Room("This is the way to freedom, but it is locked.");
		
		Room weightroom = new Room("This is the upstairs weightroom.");
		Item Dumbell = new Item ("60 pound dumbell", "You found a dumbell, might be usefull for breaking something");
		
		Room wardensbathroom = new Room("The warden's personal latrine and shower.");
		
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
		
		return yard;
	}

}
