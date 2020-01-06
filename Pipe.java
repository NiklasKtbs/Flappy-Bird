import ledControl.BoardController;

public class Pipe {
	
	private final int[] gr�n = new int[] {0,127,0};
	
	private BoardController controller;
	
	public Pipe (BoardController controller) {
		this.controller = controller;
	}
	
	public void draw (int x, int y, int z) {
		for (int i=0; i<z; i++) {
			controller.setColor(x,i,gr�n);
			for (int j=z+1; j<11; j++) {
				controller.setColor(x,j,gr�n);
			}
		}
	}
	
}