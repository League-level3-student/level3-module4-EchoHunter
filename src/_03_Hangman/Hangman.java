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
Stack <String> hangWord = new Stack();
String hWHolder = "";
StringBuilder blankHWHolder = new StringBuilder();	
int guesses = 10;
ArrayList <Character> keyAlreadyPressed = new ArrayList<Character>();
public void run() {
		panel = new JPanel();
		frame = new JFrame();
		label = new JLabel();
		panel.add(label);
		frame.add(panel);
		frame.pack();
		frame.addKeyListener(this);
		frame.setVisible(true);
	String placeHolder = "";
	
	String numLengthS = JOptionPane.showInputDialog("Give me a number that is 1-266");
	int numLength = Integer.parseInt(numLengthS);
	while (hangWord.size() < numLength) {
		placeHolder = Utilities.readRandomLineFromFile("dictionary.txt");
		if (!hangWord.contains(placeHolder)) {
			hangWord.add(placeHolder);
		}
	}
	while ((guesses > 0)||(hangWord.size() >0)) {
		if (!blankHWHolder.toString().contains("_")) {
			startNewGame();
		}
	}
	if (guesses <= 0) {
		JOptionPane.showMessageDialog(null, "you lost");
	}
	if(hangWord.size()<=0) {
	JOptionPane.showMessageDialog(null, "You won, very cool");
	}
	}
	void startNewGame() {
	hWHolder = hangWord.pop();
	for (int j = 0; j < hWHolder.length(); j++) {
		blankHWHolder.append("_");
	}
	label.setText(blankHWHolder.toString() + "  Guesses left: " + guesses);
	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		guesses--;
		for (int i = 0; i < hWHolder.length(); i++) {
			if ((hWHolder.charAt(i) == e.getKeyChar())&&(!keyAlreadyPressed.contains(e.getKeyChar()))) {
				blankHWHolder.replace(i, i+1, String.valueOf(e.getKeyChar()));
				guesses++;
			}
			label.setText(blankHWHolder.toString()+ "  Guesses left: " + guesses);
		}
		keyAlreadyPressed.add(e.getKeyChar());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
