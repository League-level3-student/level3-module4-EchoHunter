package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
JPanel panel;
JFrame frame;
JLabel label;
	public void run() {
		panel = new JPanel();
		frame = new JFrame();
		label = new JLabel();
		panel.add(label);
		frame.add(panel);
	Utilities u = new Utilities ();
	Stack <String> hangWord = new Stack();
	String numLengthS = JOptionPane.showInputDialog("Give me a number that is 266 or less, no negatives or 0");
	int numLength = Integer.parseInt(numLengthS);
	for (int i = 0; i < numLength+1; i++) {
		hangWord.add(u.readRandomLineFromFile("dictionary.txt"));
	}
	
}
}
