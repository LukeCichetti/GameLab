
public class Puppy extends NPC {

	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}

	private int count = 1;

	@Override
	public void talk() {
		if (count == 1) {
			say("Hi! I'm an adorable puppy!");
			String[] options = { "Yes you are! Who's a good boy?", "Ew, no. You're actually kinda hideous." };
			getResponse(options);
			count++;
		} else if (count == 2) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = { "Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies." };
			getResponse(options);
			count++;
		} else if (count == 3) {
			say("Yip!");
			Game.print("The puppy wags his tail happily.");
			count++;
		} else {
			say("I'm getting tired of this conversation... Let's talk later!");
			count = 1;
		}
	}

	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			if(count==1) {
				say("I am! I'm a good boy!");
			}
			break;
		case 2:
			if(count==1) {
			say("I am adorable! Why are you so mean?");
			Game.print("The puppy bites you. You deserve it.");
			break;
			}
		}
	}
	public void response2(int option) {
		switch (option) {
		case 1:
			if (count == 2) {
				say("Yes! I love fetch!");
			}
			break;
		case 2:
			if (count == 2) {
				say("No. I am a horrible person and don't like playing with puppies.");
				Game.print("The puppy runs away and doesnt come back");
				break;
			}
		}
	}
	public void response3(int option) {
		switch (option) {
		case 1:
			if (count == 3) {
				say("Yip!");
			}
			break;
		
			}
		}
	}



