package Ch_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextArea textArea;
	
	public TextAreaDemo() {
		this.setTitle("Text Area Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField(30);
	}
	
	public static void main(String[] args) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
