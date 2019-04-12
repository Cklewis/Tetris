import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractPiece implements Piece {
	protected boolean ableToMove; // can this piece move

	protected Square[] square; // the squares that make up this piece

	// Made up of PIECE_COUNT squares
	protected Grid grid; // the board this piece is on
	
	// number of squares in one Tetris game piece
	static final int PIECE_COUNT = 4;
	
	public static int i=1;
	
	/**
	 * Returns the (row,col) grid coordinates occupied by this Piece
	 * 
	 * @return an Array of (row,col) Points
	 */
	/**
	 * Draws the piece on the given Graphics context
	 */
	
	public void draw(Graphics g) {
		for (int i = 0; i < PIECE_COUNT; i++) {
			square[i].draw(g);
		}
	}

	/**
	 * Moves the piece if possible Freeze the piece if it cannot move down
	 * anymore
	 * 
	 * @param direction
	 *            the direction to move
	 */
	public void move(Direction direction) {
		if (canMove(direction)) {
			for (int i = 0; i < PIECE_COUNT; i++)
				square[i].move(direction);
		}
		// if we couldn't move, see if because we're at the bottom
		else if (direction == Direction.DOWN) {
			ableToMove = false;
		}
	}
	

	/**
	 * Returns the (row,col) grid coordinates occupied by this Piece
	 * 
	 * @return an Array of (row,col) Points
	 */
	//get row and col locations
	public Point[] getLocations() {
		Point[] points = new Point[PIECE_COUNT];
		for (int i = 0; i < PIECE_COUNT; i++) {
			points[i] = new Point(square[i].getRow(), square[i].getCol());
		}
		return points;
	}

	/**
	 * Return the color of this piece
	 */
	public Color getColor() {
		// all squares of this piece have the same color
		return square[0].getColor();
	}

	/**
	 * Returns if this piece can move in the given direction
	 * 
	 */
	public boolean canMove(Direction direction) {
		if (!ableToMove)
			return false;

		// Each square must be able to move in that direction
		boolean answer = true;
		for (int i = 0; i < PIECE_COUNT; i++) {
			answer = answer && square[i].canMove(direction);
		}

		return answer;
	}

	/**
	* Rotate the Piece
	*/

	public void rotate(){ 
		
	}
	
	
}