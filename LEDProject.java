import java.awt.event.KeyEvent;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

public class LEDProject {

	public static void main(String[] args) {
		
		BoardController controller = BoardController.getBoardController();
		Bird flappy = new Bird(controller);
		//animationLoopKeyboard(controller, flappy);
		
		BoardController controller1 = BoardController.getBoardController();
		Pipe pipe = new Pipe(controller1);
		
		animationLoopKeyboard(controller, flappy, pipe);
		

	}

	private static void animationLoopKeyboard(BoardController controller, Bird bird, Pipe pipe) {
		
		int y = 0;
		int x = 0;
		int b = 11;
		KeyBuffer buffer = controller.getKeyBuffer();

		//Dauerschleife
		while (true) {
			
			// Eingabe aus dem buffer holen
			KeyEvent event = buffer.pop();
			
			if (event != null) {
				
				// Prüfen ob Eingabe ein Tastendruck war
				if (event.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
					
					switch (event.getKeyCode()) {
					
					// Wenn nach oben gedrückt
					case java.awt.event.KeyEvent.VK_UP:
						if (y > 0) {
							y--;
						}
						break;
						
					// Wenn nach unten gedrückt
					case java.awt.event.KeyEvent.VK_DOWN:
						if (y < 10) {
							y++;
						}
						break;
						
					default:
					}
				}
			}
			
			// Bild löschen
			controller.resetColors();
			
			// Neu zeichnen
			bird.draw(x, y);
			pipe.draw(b, 0);
			
			b = b-1;
			if(b==-1) {
				b=11;
			}
			
			final int[] gelb = new int[] {127,127,0};
			controller.addColor(0, 11, gelb);
			controller.addColor(1, 11, gelb);
			controller.addColor(2, 11, gelb);
			controller.addColor(3, 11, gelb);
			controller.addColor(4, 11, gelb);
			controller.addColor(5, 11, gelb);
			controller.addColor(6, 11, gelb);
			controller.addColor(7, 11, gelb);
			controller.addColor(8, 11, gelb);
			controller.addColor(9, 11, gelb);
			controller.addColor(10, 11, gelb);
			controller.addColor(11, 11, gelb);
			
			// Update zum Darstellen
			controller.updateBoard();
			controller.sleep(150);
		}
	}
}