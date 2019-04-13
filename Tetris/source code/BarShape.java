import java.awt.Color;

public class BarShape extends AbstractPiece{

	public BarShape(int r, int c, Grid g) {
		grid = g;
		square = new Square[PIECE_COUNT];
		ableToMove = true;

		// Create the squares
		square[0] = new Square(g, r, c-1, Color.CYAN.brighter(), true);
		square[1] = new Square(g, r , c, Color.CYAN.brighter(), true);
		square[2] = new Square(g, r , c+1, Color.CYAN.brighter(), true);
		square[3] = new Square(g, r, c+2, Color.CYAN.brighter(), true);
		i=1;
		
	}
	public void rotate(){
		if (canMove(Direction.LEFT) && canMove(Direction.RIGHT)&&canMove(Direction.UP)&& 
				canMove(Direction.DOWN)) {
				if ((square[1].getCol()>1) && square[1].getCol()<Grid.WIDTH-2 && 
						square[1].getRow()>0 && square[1].getRow()<Grid.HEIGHT-2){
			switch (i){
			case 1:
				square[0].move(Direction.UP);
				square[0].move(Direction.RIGHT);
				square[2].move(Direction.DOWN);
				square[2].move(Direction.LEFT);
				square[3].move(Direction.LEFT);
				square[3].move(Direction.LEFT);
				square[3].move(Direction.DOWN);
				square[3].move(Direction.DOWN);
				i++;
				break;
			case 2:
				square[0].move(Direction.RIGHT);
				square[0].move(Direction.DOWN);
				square[2].move(Direction.LEFT);
				square[2].move(Direction.UP);
				square[3].move(Direction.UP);
				square[3].move(Direction.UP);
				square[3].move(Direction.LEFT);
				square[3].move(Direction.LEFT);
				i++;
				break;
				
			case 3:
				square[0].move(Direction.DOWN);
				square[0].move(Direction.LEFT);
				square[2].move(Direction.UP);
				square[2].move(Direction.RIGHT);
				square[3].move(Direction.RIGHT);
				square[3].move(Direction.RIGHT);
				square[3].move(Direction.UP);
				square[3].move(Direction.UP);
				i++;
				break;
			case 4:
				square[0].move(Direction.LEFT);
				square[0].move(Direction.UP);
				square[2].move(Direction.RIGHT);
				square[2].move(Direction.DOWN);
				square[3].move(Direction.RIGHT);
				square[3].move(Direction.RIGHT);
				square[3].move(Direction.DOWN);
				square[3].move(Direction.DOWN);
				i=1;
				break;
				default: 
					i=1; 
				break;
				}
				}
			}
	}
}
