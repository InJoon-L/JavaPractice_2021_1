package Ch_15;

import java.util.*;

public class StackTest2 {
	public static void main(String[] args) {
		String str = "apple, banana, carrot, pineapple, grape, mango, "
				+ "strawberry, watermelon, orange, coconut, kiwi, lemon, tomato, "
				+ "cherry, blueberry, peach, cramberry, raspberry";
		
		// ���鹮�ڸ� �������� �ϳ��� ©�� �ּ���
		/*
			�����ڸ� �Է����� �ְ�, �� ������(delimiter)�� ���еǴ� 
			���ڿ����� �ϳ���, �ϳ��� �̾� �� �� �ְ� ���ִ�
			java.util ��Ű���� Ŭ������ ���� �ϸ�
			StringTokenizer
		*/
		StringTokenizer st = new StringTokenizer(str, ", ");
		System.out.println("token ��: " + st.countTokens()); 
		
		// ��ū�� �� ��� ���� ���1
		// ��ū�� ����ŭ for �� ����
		
		// ��ū�� �� ��� ���� ���2
		// ���� ������ �� ��ū�� �����ִ��� �����
		// ������ nextToken() �޼ҵ带 ȣ���ؼ� �ϳ��� �޾Ƽ� ����ϱ�
		// �ַ� 2��° ����� ���� ���
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("[" + token + "]");
		}
	}
}