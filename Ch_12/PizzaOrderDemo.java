package Ch_12;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaOrderDemo extends JFrame implements ActionListener{
	private int sum, temp1, temp2, temp3;
	
	private JButton orderBtn, cancelBtn;
	private JPanel orderPanel;
	private JTextField priceField;
	
	JPanel welcomePanel = new WelcomePanel();
	JPanel typePanel = new TypePanel();
	JPanel toppinPanel = new ToppingPanel();
	JPanel sizePanel = new SizePanel();
	
	public PizzaOrderDemo() {
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("���� �ֹ�");
		
		orderBtn = new JButton("�ֹ�");
		cancelBtn = new JButton("���");
		
		orderBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		priceField = new JTextField();
		priceField.setEditable(false);
		priceField.setColumns(6);
		
		orderPanel = new JPanel();
		orderPanel.add(orderBtn);
		orderPanel.add(cancelBtn);
		orderPanel.add(priceField);
		
		this.add(welcomePanel, BorderLayout.NORTH);
		this.add(orderPanel, BorderLayout.SOUTH);
		this.add(sizePanel, BorderLayout.EAST);
		this.add(typePanel, BorderLayout.WEST);
		this.add(toppinPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderBtn) {
			sum = temp1 + temp2 + temp3;
			priceField.setText(String.valueOf(sum));
			System.out.println("temp1:" + temp1 + ", temp2:" + temp2 +
						", temp3:" + temp3);
		} else if(e.getSource() == cancelBtn) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			priceField.setText(String.valueOf(sum));
		}
	}
	
	class WelcomePanel extends JPanel{
		private JLabel message;
		
		public WelcomePanel() {
			message = new JLabel("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ActionListener{
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup btnGroup;
		
		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			combo = new JRadioButton("�޺�", true);
			potato = new JRadioButton("��������");
			bulgogi = new JRadioButton("�Ұ��");
			
			combo.addActionListener(this);
			potato.addActionListener(this);
			bulgogi.addActionListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(combo);
			btnGroup.add(potato);
			btnGroup.add(bulgogi);
			
			this.setBorder(BorderFactory.createTitledBorder("����"));
			
			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == combo) {
				temp1 = 5000;
			} else if(e.getSource() == potato) {
				temp1 = 6000;
			} else if(e.getSource() == bulgogi) {
				temp1 = 7000;
			}
		}
	}
	
	class ToppingPanel extends JPanel implements ActionListener {
		private JRadioButton pepper, cheese, peperoni, bacon;
		private ButtonGroup btnGroup;
		
		public ToppingPanel() {
			this.setLayout(new GridLayout(4, 1));
			
			pepper = new JRadioButton("�Ǹ�", true);
			cheese = new JRadioButton("ġ��");
			peperoni = new JRadioButton("����δ�");
			bacon = new JRadioButton("������");
			
			pepper.addActionListener(this);
			cheese.addActionListener(this);
			peperoni.addActionListener(this);
			bacon.addActionListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(pepper);
			btnGroup.add(cheese);
			btnGroup.add(peperoni);
			btnGroup.add(bacon);
			
			this.setBorder(BorderFactory.createTitledBorder("�߰�����"));
			
			this.add(pepper);
			this.add(cheese);
			this.add(peperoni);
			this.add(bacon);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == pepper) {
				temp2 = 5000;
			} else if(e.getSource() == cheese) {
				temp2 = 6000;
			} else if(e.getSource() == peperoni) {
				temp2 = 7000;
			} else if(e.getSource() == bacon) {
				temp2 = 8000;
			}
		}
	}
	
	class SizePanel extends JPanel implements ActionListener {
		private JRadioButton small, medium, large;
		private ButtonGroup btnGroup;
		
		public SizePanel() {
			this.setLayout(new GridLayout(3, 1));
			
			small = new JRadioButton("Small");
			medium = new JRadioButton("Medium");
			large = new JRadioButton("Large");
			
			small.addActionListener(this);
			medium.addActionListener(this);
			large.addActionListener(this);
			
			btnGroup = new ButtonGroup();
			btnGroup.add(small);
			btnGroup.add(medium);
			btnGroup.add(large);
			
			this.setBorder(BorderFactory.createTitledBorder("ũ��"));
			
			this.add(small);
			this.add(medium);
			this.add(large);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == small) {
				temp3 = 5000;
			} else if(e.getSource() == medium) {
				temp3 = 6000;
			} else if(e.getSource() == large) {
				temp3 = 7000;
			}
		}
	}
	
	public static void main(String[] args) {
		new PizzaOrderDemo();
	}
}