
public class PrisonGuard extends NPC {

	public PrisonGuard() {
		super("prisonguard", "A disgruntled emloyee of the prison, he remembers you!");
	}

	private int count = 1;

	@Override
	public void talk() {
		if (count == 1) {
			say("COUGH COUGH! I remeber you. You need to get a key to leave this place.");
			String[] options = { "Okay, Im on it",
					"Might want to get that cough looked at, and I dont need your help." };
			getResponse(options);
			count++;
		} else if (count == 2) {
			say("Did you find the key? I heard one of the prisoners swiped it before the Z outbreak.");
			String[] options = { "Okay, I'll look for it", "No. leave me alone" };
			getResponse(options);
			count++;
		} else if (count == 3) {
			say("Let me know what you find, I want to get out of here!");
			Game.print("The guard looks antsy.");
			count++;
		} else {
			say("I'm getting tired of these conversations. You are no help!");
			count = 1;
		}
	}

	@Override
	public void response(int option) {
		if (count == 2) {
			switch (option) {
			case 1:
				say("Let me know what you find");
				break;
			case 2:
				say("Alright then asshole! have it your way.");
				Game.print("The guard cocks his gun and walks away.");
				break;
			}
		} else if (count == 3) {
			switch (option) {
			case 1:
				say("Bring it to me if you find it.");
				break;
			case 2:
				say("Honestly why do I even ask! I'm on my own out here.");
				Game.print("The Guard runs away and doesnt come back");
				break;
			}
		} else if (count == 4) {
			switch (option) {
			case 1:
				say("Go Away!");
				break;

			}
		}
	}
}
