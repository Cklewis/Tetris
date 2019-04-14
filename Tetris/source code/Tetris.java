//Colby Lewis
/**
 * Create and control the game Tetris.
 * 
 *
 *
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Canvas;
import java.awt.Panel;
public class Tetris extends JPanel{

	private Game game;
	public Grid grid;

	/**
	 * Sets up the parts for the Tetris game, display and user control
	 */
	public Tetris() {
		game = new Game(this);
		JFrame f = new JFrame("The Tetris Game");
		f.getContentPane().add(this);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(450, 555);
		f.setVisible(true);
		EventController ec = new EventController(game);
		f.addKeyListener(ec);
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblScore = new JLabel("SCORE:");
		lblScore.setBounds(12, 13, 61, 22);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblScore);
		
	}

	/**
	 * Updates the display
	 */
	public void update() {
		repaint();
	}

	/**
	 * Paint the current state of the game
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g);
		if (game.isGameOver()) {
			g.setFont(new Font("Palatino", Font.BOLD, 40));
			g.setColor(Color.BLACK.darker());
			g.drawString("GAME OVER", 80, 300);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("Palatino",Font.PLAIN, 20));
		g.drawString("" + grid.score, 80, 30 );
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tetris frame = new Tetris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
