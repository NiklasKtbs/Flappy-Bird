import ledControl.BoardController;

public class Pipe {
	
	private final int[] grün = new int[] {0,127,0};
	
	private BoardController controller;
	
	private int [][][] pipe = new int [][][] {
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
		{grün,},
	};
	
	public Pipe (BoardController controller) {
		this.controller = controller;
	}
	
	private int x=0;
	private int y=0;
	
	
	public void draw (int x, int y) {
		for (int i=0;i<pipe.length;i++) {
			for (int j=0; j<pipe[i].length;j++) {
				if (pipe[i][j]!=null) {
					controller.setColor(x+j,y+i,pipe[i][j]);
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
	
	public int getPipeWidth() {
		return pipe[0].length;
	}
	
	public int getPipeHeight() {
		return pipe.length;
	}

}
