import java.awt.event.KeyEvent;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;
import java.util.concurrent.ThreadLocalRandom;

public class LEDProject {

	public static void main(String[] args) {
		
		BoardController controller = BoardController.getBoardController();
		Bird flappy = new Bird(controller);
		
		BoardController controller1 = BoardController.getBoardController();
		Pipe pipe = new Pipe(controller1);
		
		animationLoopKeyboard(controller1, flappy, pipe);
		

	}

	
	// IRGENDWO EXISTIERT BUG
	private static void animationLoopKeyboard(BoardController controller, Bird bird, Pipe pipe) {
		
		boolean a = true; 													// Abbruchbedingung
		int x = 11; 														//Pipelocation
		int y = 0;  														//Birdlocation
		int rand = ThreadLocalRandom.current().nextInt(0, 10); 				//Lochlocation
		
		KeyBuffer buffer = controller.getKeyBuffer();

		//Dauerschleife
		while (true) {
			
			//Neustart
			if(a==false) {
				KeyEvent event = buffer.pop();
				if(event != null) {
					if (event.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
						switch (event.getKeyCode()) {
						case java.awt.event.KeyEvent.VK_SPACE:
							x=11;
							y=0;
							rand = ThreadLocalRandom.current().nextInt(0, 10);
							a=true;
							break;
							default :
						}
					}
				}
			}
			
			//Spielablauf
			while (a) {
			
			
				// Eingabe aus dem buffer holen
				KeyEvent event = buffer.pop();		
			
					if (event != null) {
				
						// Prüfen ob Eingabe ein Tastendruck war
						if (event.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
					
							switch (event.getKeyCode()) {
					
							// Wenn oben
							case java.awt.event.KeyEvent.VK_UP:
								if (y > 0) {
									y--;
								}
								break;
						
								// Wenn unten
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
			
					//Boden zeichnen
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
			
					// Rest neu zeichnen
					bird.draw(0, y);
					pipe.draw(x, 0, rand);
			
					x = x-1;
			
					//Collision Test
					if (x==0) {			
						if (rand !=y) {
							a=false;
						}
					}
			
					//Reset
					if(x==-1) {
						x=11;
						rand = ThreadLocalRandom.current().nextInt(0, 10);
					}
			
					// Update zum Darstellen
					controller.updateBoard();
					controller.sleep(200);
			
			}
		}
	}
}