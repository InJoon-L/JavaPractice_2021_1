package Ch_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonFrame extends JFrame implements ActionListener{
	
	private JRadioButton small, medium, large;
	private JLabel text;
	private JPanel topPanel, sizePanel, resultPanel;
	
	public RadioButtonFrame() {
		this.setTitle("라디오 버튼 테스트");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPanel = new JPanel();
		sizePanel = new JPanel();
		resultPanel = new JPanel();
		JLabel label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		
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
		
		text = new JLabel("크기가 선택되지 않았습니다.");
		text.setForeground(Color.red);
		resultPanel.add(text);
		this.add(resultPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == small) {
			text.setText("Small 크기가 선택되었습니다.");
		}else if(e.getSource() == medium) {
			text.setText("Medium 크기가 선택되었습니다.");			
		}else if(e.getSource() == large) {
			text.setText("Large 크기가 선택되었습니다.");			
		}
	}
}


