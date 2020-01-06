import ledControl.BoardController;

public class Pipe {
	
	private final int[] grün = new int[] {0,127,0};
	
	private BoardController controller;
	
	public Pipe (BoardController controller) {
		this.controller = controller;
	}
	
	public void draw (int x, int y, int z) {
		for (int i=0; i<z; i++) {
			controller.setColor(x,i,grün);
			for (int j=z+1; j<11; j++) {
				controller.setColor(x,j,grün);
			}
		}
	}
	
}