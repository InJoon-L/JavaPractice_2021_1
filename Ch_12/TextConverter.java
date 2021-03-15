package Ch_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//���߿� papago api �߰�����
public class TextConverter extends JFrame implements ActionListener{
	private JButton converBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	
	public TextConverter() {
		this.setTitle("�ؽ�Ʈ ��ȯ");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		converBtn = new JButton("��ȯ");
		cancelBtn = new JButton("���");
		converBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(converBtn);
		btnPanel.add(cancelBtn);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 	��ȯ ��ư�� Ŭ���Ǿ��ٸ�
		 		���� textArea�� �ؽ�Ʈ�� �о In
		 		����� ��ȯ�ϰ� �� ��ȯ�� ����� 
		 		���� textArea�� append Out
		 	��� ��ư�� Ŭ���Ǿ��ٸ�
		 		������ �� ���ڿ��� ���� Out
		 */
		if(e.getSource() == converBtn) {
			String str = textIn.getText();
			String result = toEnglish(str);
			textOut.setText(result);
		} else {
			textOut.setText("");
		}
	}
	
	private String toEnglish(String korean) {
		// korean ���ڿ��� ����� ��ȯ�ؼ� ��ȯ..
		/*
		 	�ؽ�Ʈ => text
		 	���� => english
		 */
		
		String result = null;
		result = korean.replace("�ؽ�Ʈ", "text");
		result = result.replace("����", "english");
		
		return result;
	}
	
	public static void main(String[] args) {
		new TextConverter();
	}

}
