
public class Key extends Item {
	
	public Key(String name3, String description3) {
		super(name3, description3);
	}
	public void use() {
		Room exit = Game.currentRoom.getExit('s');
		if(exit != null && exit.getName().equals("Exit")){
			exit.setLock(false);
			Game.print("Door has been unlocked");
		}else {
			Game.print("Door cannot be locked");
		
		
		}
		
			
	}


}
