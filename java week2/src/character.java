
public class character {
	private String name;
	private int health;
	private String catchphrase;
	
	public Character(String name, int health, String catchphrase) {
		this.name = name;
		this.health = health;
		this.catchphrase = catchphrase;
	}
	
	public void getInfo() {
		System.out.println("Name:"+this.getName());
		System.out.println("Health:"+this.getHealth());
		System.out.println("Catchphrase:"+this.getCatchphrase());
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public String getCatchphrase() {
		return catchphrase;
	}
	
}
}
