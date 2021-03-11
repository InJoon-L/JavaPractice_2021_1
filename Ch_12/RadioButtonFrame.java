package Ch_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonFrame extends JFrame implements ActionListener{
	
	private JRadioButton small, medium, large;
	private JLabel text;
	private JPanel topPanel, sizePanel, resultPanel;
	
	public RadioButtonFrame() {
		this.setTitle("���� ��ư �׽�Ʈ");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPanel = new JPanel();
		sizePanel = new JPanel();
		resultPanel = new JPanel();
		JLabel label = new JLabel("� ũ���� Ŀ�Ǹ� �ֹ��Ͻðڽ��ϱ�?");
		
		topPanel.add(label);
		this.add(topPanel, BorderLayout.NORTH);
		
		small = new JRadioButton("Small Size");
		medium = new JRadioButton("Medium Size");
		large = new JRadioButton("Large Size");
//		ButtonGroup size = new ButtonGroup();
//		size.add(small);
//		size.add(medium);
//		size.add(large);
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		this.add(sizePanel, BorderLayout.CENTER);
		
		text = new JLabel("ũ�Ⱑ ���õ��� �ʾҽ��ϴ�.");
		text.setForeground(Color.red);
		resultPanel.add(text);
		this.add(resultPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == small) {
			text.setText("Small ũ�Ⱑ ���õǾ����ϴ�.");
		}else if(e.getSource() == medium) {
			text.setText("Medium ũ�Ⱑ ���õǾ����ϴ�.");			
		}else if(e.getSource() == large) {
			text.setText("Large ũ�Ⱑ ���õǾ����ϴ�.");			
		}
	}
}


