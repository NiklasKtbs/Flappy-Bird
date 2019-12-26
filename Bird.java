import ledControl.BoardController;

public class Bird {

	private final int[] orange = new int[] {127,60,0};
	
	private BoardController controller;
	
	private int [][][] vogel = new int [][][] {
		{orange,},
	};
	
	public Bird (BoardController controller) {
		this.controller = controller;
	}
	
	private int x=0;
	private int y=0;
	
	
	public void draw (int x, int y) {
		for (int i=0;i<vogel.length;i++) {
			for (int j=0; j<vogel[i].length;j++) {
				if (vogel[i][j]!=null) {
					controller.setColor(x+j,y+i,vogel[i][j]);
				}
			}
		}
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
	
	public int getBirdWidth() {
		return vogel[0].length;
	}
	
	public int getBirdHeight() {
		return vogel.length;
	}

}
