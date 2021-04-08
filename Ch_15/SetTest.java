package Ch_15;

import java.io.*;
import java.util.*;

public class SetTest {
	
	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		File file = new File("./image/wordbook.txt");
//		if (file.exists()) {
//			System.out.println(file.getAbsolutePath() + ": ������");
//		} else {
//			System.out.println(file.getAbsolutePath() + ": �������� ����");
//		}
		// ���� ������ ����.
		// ���Ͽ� �а� ������ stream ��ü�� �̿��ؾ� �Ѵ�.
		// ���� ��� Input Stream
		// �� ���� Output Stream
		// Stream�� �⺻������ Byte Stream
		// �׷��� ���ڴ����� �а� �� ���� ���� ��Ʈ���� �̿��ϴ� ���� ��
		// ���ڴ����� �Է� ��Ʈ���� Reader ��ü�� ǥ���ȴ�
		// ���ڴ����� ��� ��Ʈ���� Writer ��ü�� ǥ���ȴ�
		// FileReader�� �� ���ھ� ���� �� ���
		Set<String> set = new HashSet<>();
		int cnt = 0;
		BufferedReader bReader = null;
		try {
			FileReader fileReader = new FileReader(file);
			// ���� ������ �б� ���ؼ� BufferedReader�� �̿�
			bReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bReader.readLine()) != null) {
				System.out.println(line);
				set.add(line);
				cnt++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bReader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("�ܾ� ��(�ߺ�����): " + cnt);
		System.out.println("�ܾ� ��(�ߺ�������): " + set.size());
	}
}
