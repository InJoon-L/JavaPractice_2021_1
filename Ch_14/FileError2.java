package Ch_14;

import java.io.*;

public class FileError2 {

	public static void main(String[] args) {
		writeList();
	}
	
	private static void writeList() {
		PrintWriter out = null;
		// AutoCloseable �������̽��� �����ؾ� �Ѵ�.
		// �� ��ü�� try with resources ���� ���� �� �ִ�.
		try (FileWriter fw = new FileWriter("out.txt");) {
			out = new PrintWriter(fw);
			out.println("Hello? I love you.");
			System.out.println("�۾�����...");
//			out.close();
		} catch (IOException e) {
			System.out.println("catch:" + e.getMessage());
		}
	}
}
