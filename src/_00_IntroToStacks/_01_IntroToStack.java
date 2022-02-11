package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
Stack<Double> d = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
Random r = new Random();
for (int i = 0; i <= 100; i++) {
	d.push((double) r.nextInt(100));
}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
String input = JOptionPane.showInputDialog("Pick 2 numbers between 0 and 100, inclusive");
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
String regEx = "[a-zA-Z,\\s]";
StringBuilder finalInput = new StringBuilder(input.replaceAll(regEx, ""));
finalInput.insert(0, '[');
finalInput.insert(2, '-');
finalInput.append(']');
Double s;
for (int i = 0; i < d.size(); i++) {
	s = d.pop();
	
}

        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}