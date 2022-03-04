package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
 JFrame frame = new JFrame();
 JPanel panel = new JPanel();
 JLabel label = new JLabel();
 Stack <Character> c = new Stack();
 StringBuilder labelText = new StringBuilder();
void run() {
	panel.add(label);
	frame.add(panel);
	frame.addKeyListener(this);
	frame.setVisible(true);
	frame.pack();
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println(e.getKeyChar());
	if (e.getKeyChar() == '^') {
		labelText.append(c.pop());
		label.setText(labelText.toString());
	}
	
	else if (e.getKeyChar() == '\b'){
		if (labelText.length() > 0) {
		c.add(labelText.charAt(labelText.length()-1));
		labelText.deleteCharAt(labelText.length()-1);
		label.setText(labelText.toString());
			}
		}
	else {
		label.setText(labelText.toString() + e.getKeyChar());
		labelText = new StringBuilder(label.getText());
		}
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


}

