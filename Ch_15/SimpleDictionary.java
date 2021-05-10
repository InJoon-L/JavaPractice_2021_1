package Ch_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class SimpleDictionary extends JPanel implements ActionListener{
	/*
		�ܾ� �Է� ���� �� �ִ� JTextField
		�˻� ��ư
		�߰� ��ư
		�ܾ��� ������ ���� �ڷᱸ���� Map ��ü
	*/
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn = new JButton("�߰�");
	
	// Map ��ü�� �ܾ��� ���� ����Ҳ���.
	// <key, value> ������ ����. key�� �ѱ۴ܾ�, value�� �����Ǵ� ����ܾ�.
	private Map<String, String> words = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	
	public SimpleDictionary() {
		// Panel�� �⺻ ���̾ƿ��� : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		
		// searchBtn, addBtn�� Ŭ�� �̺�Ʈ�� �߻����� �� ó���� �����ʸ� ��������!
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		this.setPreferredSize(new Dimension(600, 50));
	
		// ���Ͽ� key=value ���·� ����� ��Ʈ������ �о, dict�� ��������.
		buildDictionaryFromFile();
	}
	
	
	private void buildDictionaryFromFile() {
		// Properties ������ Map�ε�
		// key, value�� Ÿ���� ���� String, String����
		// ������ ������ Map�̴�.
		Properties props = new Properties();
		
		// ���Ͽ��� �о props ��ü�� <key, value>
		// ���� ������ �� �ִ�.
		try (FileReader fReader = new FileReader(DIC_FILE_NAME)) {
			props.load(fReader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Set<Object> set = props.keySet();
		for (Object obj : set) {
			words.put((String)obj, (String)props.get(obj));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if (key.trim().length() == 0) return; // ���鸸 �Էµ� ���� ����.
		
		if (e.getSource() == searchBtn) {
			/*
				�Էµ� �ܾ ����
				�� �ܾ key ������ ������ �����Ǵ� �� ��Ʈ���� �ִ��� �˻� -> dict.get(�ܾ�);
				�� �ܾ� �����Ǵ� ���� ������ JOptionPane.showMessageDialog() �޼��带 
				ȣ���ؼ� �� �����Ǵ� ���� �����ش�.
				������ (null�̸�) JOptionPane.showMessageDialog() �޼��带 ȣ���ؼ� 
				�ܾ ã�� �� �����ϴ� ��� ������ش�.
				inputField�� �� ���ڿ��� ����.
			*/
			String value = words.get(key);
			if (value != null) { // �����Ǵ� �ܾ �ִ� ���
				JOptionPane.showMessageDialog(this, value, key, 
						JOptionPane.INFORMATION_MESSAGE);
			} else { // �����Ǵ� �ܾ ���� ���
				JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�.", key, 
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == addBtn) {
			/*
				�Էµ� �ܾ ����
				String value = JOptionPane.showInputDialog(); 
				�޼��带 ȣ���ؼ� �߰��� ���� �ܾ �Է� �޴´�.
				dict.put(�Է��ʵ忡 �Էµ� �ܾ�, inputDialog�� �Էµ� �ܾ�);
				inputField�� �� ���ڿ��� ����.
			*/
			String value = JOptionPane.showInputDialog(this,
					key + "�� �����Ǵ� ����ܾ �Է��ϼ���");
			if (value.trim().length() == 0) return;
			words.put(key, value);
			// ���Ͽ��� key=value �� ������ ����س���.
			addWordToFile(key, value);
			JOptionPane.showMessageDialog(this, "["+value+"]"+"����ܾ �߰��Ǿ����ϴ�", 
					key, JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.setText("");
	}
	
	private void addWordToFile(String key, String value) {
		try (FileWriter fWriter = 
				new FileWriter(DIC_FILE_NAME, true)) {
			fWriter.write(key + "=" + value + "\n");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SimpleDictionary dictPanel = new SimpleDictionary();
		frame.add(dictPanel);
		frame.setTitle("���� �ѿ�����");
		
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
