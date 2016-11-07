
public class GuiCell {

	int x;
	int y;
	int value;
	int owner; // 1 for AI, 0 for wala, -1 for player
	int legitCell; // pwede kasi na pader sya or <---> (non existent)

	public GuiCell(int x, int y, int value, int owner, int legitCell) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		this.owner = owner;
		this.legitCell = legitCell;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getLegitCell() {
		return legitCell;
	}

	public void setLegitCell(int legitCell) {
		this.legitCell = legitCell;
	}

}
