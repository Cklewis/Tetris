import java.awt.Color;

public class JShape extends AbstractPiece{

		public JShape(int r, int c, Grid g) {
			grid = g;
			square = new Square[PIECE_COUNT];
			ableToMove = true;

			// Create the squares
			square[0] = new Square(g, r - 1, c, Color.BLUE.darker(), true);
			square[1] = new Square(g, r, c, Color.BLUE.darker(), true);
			square[2] = new Square(g, r+1, c, Color.BLUE.darker(), true);
			square[3] = new Square(g, r +1, c -1, Color.BLUE.darker(), true);
			i=1;
		}
		public void rotate(){
			if (canMove(Direction.LEFT) & canMove(Direction.RIGHT)){
			switch (i){
			case 1:
				square[0].move(Direction.RIGHT);
				square[0].move(Direction.DOWN);
				square[2].move(Direction.LEFT);
				square[2].move(Direction.UP);
				square[3].move(Direction.UP);
				square[3].move(Direction.UP);
				i++;
				break;
			case 2: 
				square[0].move(Direction.DOWN);
				square[0].move(Direction.LEFT);
				square[2].move(Direction.UP);
				square[2].move(Direction.RIGHT);
				square[3].move(Direction.RIGHT);
				square[3].move(Direction.RIGHT);
				i++;
				break;
			case 3:
				square[0].move(Direction.LEFT);
				square[0].move(Direction.UP);
				square[2].move(Direction.RIGHT);
				square[2].move(Direction.DOWN);
				square[3].move(Direction.DOWN);
				square[3].move(Direction.DOWN);
				i++;
				break;
			case 4:
				square[0].move(Direction.UP);
				square[0].move(Direction.RIGHT);
				square[2].move(Direction.DOWN);
				square[2].move(Direction.LEFT);
				square[3].move(Direction.LEFT);
				square[3].move(Direction.LEFT);
				i=1;
				break;
				default: 
					i=1; 
				break;
				}
			}
		
		}

}
