import java.util.HashMap;
import java.io.Serializable;

public class Room implements Serializable {
	
	private String description;
	
	private Room north;
	
	private Room south;
	
	private Room east;
	
	private Room west;
	
	private Room up;
	
	private Room down;
	
	private boolean lock;
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Room(String d, String n) {
		description = d;
		name = n;
		lock = false;
		
	}
	public boolean isLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
	}
	public void setLocked(boolean lock) {
		this.lock = lock;
	}
	
	public Room getExit(char exit) {
		if(exit == 'e') {
			return east;
		}
		else if (exit == 'w') {
			return west;
		}
		else if (exit == 'n') {
			return north;
		}
		else if (exit == 's') {
			return south;
		}
		else if (exit == 'u') {
			return up;
		}
		else if (exit == 'd') {
			return down;
		}
		else 
			return null;
	}

	public void addExit(Room r, char d) {
		if (d == 'n') {
			north = r;
		}	
		else if (d == 's') {
			south = r;
		}
		else if (d == 'e') {
			east = r;
		}
		else if (d == 'w') {
			west = r;
		}
		else if (d == 'u') {
			up = r;
		}
		else if (d == 'd') {
			down = r;
		}
	}
	
		private HashMap<String, Item> item = new HashMap<String, Item>();
		
		private HashMap<String, NPC> NPCs = new HashMap<String, NPC>();
		
		public NPC getNPC(String n) {
			return NPCs.get(n);
		}
		public void addNPC(String x, NPC z) {
			NPCs.put(x, z);
		}

	
		public void addItem(String s, Item i) {
		item.put(s, i);
		
	}
		
		public Item getItem(String s) {
			item.get("Shank");
			item.get("Paperclips");
			item.get("Dumbell");
			return item.get(s);
			
	}		
		public void removeItem(String s) {
			item.remove(s);
		}
		public String toString() {
			return description;
		}
		
			
	}



	
