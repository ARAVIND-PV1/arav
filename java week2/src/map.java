
public class map {
	private int maxX;
	private int maxY;
	private int currentX;
	private int currentY;
	
	public Map(int maxX, int maxY, int currentX, int currentY) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.currentX = currentX;
		this.currentY = currentY;
	}

	public void getInfo() {
		System.out.println("Player is currently at x,y: " + this.getCurrentX() + "," + this.getCurrentY());
	}
	
	public void compass(int winX, int winY) {
		double a2 = Math.pow(Math.abs(currentY - winY), 2) ;
		double b2 = Math.pow(Math.abs(currentX - winX), 2);
		double distance = Math.sqrt(a2 + b2);
		System.out.println("The player is " + distance + " distance away from the exit");
	}
	
	public void move(String direction) {
		direction = direction.toLowerCase();
		switch(direction) {
		case "N":
			if (this.getCurrentY() == this.maxY) {
				this.setCurrentY(0);
			} else {
				this.setCurrentY(this.getCurrentY()+1);
			}
			break;
		case "S":
			if (this.getCurrentY() == 0) {
				this.setCurrentY(this.maxY);
			} else {
				this.setCurrentY(this.getCurrentY()-1);
			}
			break;
		case "E":
			if (this.getCurrentX() == this.maxX) {
				this.setCurrentX(0);
			} else {
				this.setCurrentX(this.getCurrentX()+1);
			}
			break;
		case "W":
			if (this.getCurrentX() == 0) {
				this.setCurrentX(this.maxX);
			} else {
				this.setCurrentX(this.getCurrentX()-1);
			}
			break;
		default:
			System.out.println("That was not a recognised direction");
			break;
		}
	}
	
	
	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}
	
}
}
