import java.awt.event.KeyEvent;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

public class LEDProject {

	public static void main(String[] args) {
		
		BoardController controller = BoardController.getBoardController();
		Bird flappy = new Bird(controller);
		animationLoopKeyboard(controller, flappy);

	}



private static void animationLoopKeyboard(BoardController controller, Bird bird) {
	int y = 0;
	int x = 0;
	int height = bird.getBirdHeight();
	KeyBuffer buffer = controller.getKeyBuffer();

	while (true) {
		KeyEvent event = buffer.pop(); // Eingabe aus dem buffer holen
		if (event != null) {
			// Prüfen ob Eingabe ein Tastendruck war
			if (event.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
				switch (event.getKeyCode()) {
				// Wenn nach oben gedrückt wurde mache folgendes
				case java.awt.event.KeyEvent.VK_UP:
					if (y > 0) {
						y--;
					}
					break;
				case java.awt.event.KeyEvent.VK_DOWN:
					if (y < 11 - height) {
						y++;
					}
					break;
				default:
				}
			}
		}
		// Zurücksetzen des Bilds
		controller.resetColors();
		// Zeichnen der Figur
		bird.draw(x, y);
		// Darstellung des neu gezeichneten Bilds auf dem Board
		controller.updateBoard();
	}
}

}