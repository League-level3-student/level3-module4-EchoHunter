package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JPanel panel;
	JFrame frame;
	JLabel label;
	Stack<String> hangWord = new Stack();
	String hWHolder = "";
	StringBuilder blankHWHolder = new StringBuilder();
	int guesses = 10;
	boolean repeat = true;
	ArrayList<Character> keyAlreadyPressed = new ArrayList<Character>();

	public void run() {
		frame = new JFrame();
		while (repeat) {
			repeat = false;
			// System.out.println(hangWord.size());
			panel = new JPanel();
			label = new JLabel();
			panel.add(label);
			frame.add(panel);
			frame.pack();
			frame.addKeyListener(this);
			frame.setVisible(true);
			frame.setSize(400, 100);
			hangWord.clear();
			System.out.println(blankHWHolder);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			String placeHolder = "";

			String numLengthS = JOptionPane.showInputDialog("Give me a number that is 1-266");
			int numLength = Integer.parseInt(numLengthS);
			while (hangWord.size() < numLength) {
				placeHolder = Utilities.readRandomLineFromFile("dictionary.txt");
				if (!hangWord.contains(placeHolder)) {
					hangWord.add(placeHolder);
				}
			}
			System.out.println(hangWord.size());
			while (!repeat) {
				if ((!blankHWHolder.toString().contains("_"))&&(hangWord.size() > 0)) {
					startNewGame();
				}

				if (guesses <= 0) {
					JOptionPane.showMessageDialog(null, "you lost");
					int yn = JOptionPane.showConfirmDialog(null, "Would you like to try again?");
					if (yn == 1) {
						System.exit(0);
					} else if (yn == 0) {
						repeat = true;
						guesses = 10;
						frame.getContentPane().removeAll();
						hWHolder = "";
						hangWord.clear();
						keyAlreadyPressed.clear();
						blankHWHolder.delete(0, blankHWHolder.length());
					}

				}
				if ((!blankHWHolder.toString().contains("_")) && (guesses > 0)&&(hangWord.size()<=0)) {
					JOptionPane.showMessageDialog(null, "You won, very cool");
					int yn = JOptionPane.showConfirmDialog(null, "Would you like to try again?");
					if (yn == 1) {
						System.exit(0);
					} else if (yn == 0) {
						repeat = true;
						frame.getContentPane().removeAll();
						guesses = 10;
						hWHolder = "";
						hangWord.clear();
						keyAlreadyPressed.clear();
						blankHWHolder.delete(0, blankHWHolder.length());
					}
				}
			}
		}
	}

	void startNewGame() {
		hWHolder = hangWord.pop();
		keyAlreadyPressed.clear();
		blankHWHolder.delete(0,blankHWHolder.length());
		for (int j = 0; j < hWHolder.length(); j++) {
			blankHWHolder.append("_");
		}
		label.setText(blankHWHolder.toString() + "  Guesses left: " + guesses);
		System.out.println(hWHolder);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		guesses--;
		if (!keyAlreadyPressed.contains(e.getKeyChar())) {
			for (int i = 0; i < hWHolder.length(); i++) {
				if (hWHolder.charAt(i) == e.getKeyChar()) {
					blankHWHolder.replace(i, i + 1, String.valueOf(e.getKeyChar()));
					guesses++;
				}
			}
			keyAlreadyPressed.add(e.getKeyChar());
		}
		else {
			guesses++;
		}
		label.setText(blankHWHolder.toString() + "  Guesses left: " + guesses);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
