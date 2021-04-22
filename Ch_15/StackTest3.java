package Ch_15;

import java.util.*;

public class StackTest3 {
	public static void main(String[] args) {
		// ( ���� �ְ�
		// ) ������ pop �ؼ� ���ÿ��� ����
		// �־��� ���� �� ó������ ��, ������ empty�� �ȴ�.
		// ���࿡ empty�� �ƴϸ� �߸��� ���̴�.
		// ((()) => ó�� �Ŀ� ������ empty�� �ƴϰ� �ǰ�
		// ()) => pop���� �� ����Ǵ� ���Ұ� �־�� �Ǵµ�, ���� ����̰�,
		// �� ��쵵 �߸��� ���̴�.
		// 2 * ( 3 + 2 ) / ( 3 + 1 ) / 2 * 5 - 1 + 10
		
		// 1. ���� ������ �Է¹���.
		Scanner input = new Scanner(System.in); // �ܼ� �Է��� ���� Scanner ��ü ����
		System.out.println("������ �Է��ϼ���.");
		String exp = input.nextLine();
		
		// 2. �Է¹��� ������ ������ �������� ���ڿ��� ��ū���� �и�����.
		// exp ���ڿ� ������ ���� ������ �������� ���ڿ� ��ū��� �и�.
		StringTokenizer st = new StringTokenizer(exp);
		
		// 3. ��ū�� �ϳ��� ���鼭 ���� ��ȣ�̸� ���ÿ� push, �ݴ� ��ȣ�̸� ���ÿ��� pop
		Stack<String> stack = new Stack<>();
		
		while(st.hasMoreTokens()) { // ���� �� ��ū�� ���ҳ�? st.hasMoreElements()
			String token = st.nextToken();
			// token�� ���� ��ȣ�̸� stack push
			if (token.equals("(")) stack.push("(");
			// token�� �ݴ� ��ȣ�̸� stack pop()
			else if (token.equals(")")) {
				// �ٵ� stack�� ���Ұ� �ϳ��� ���ٸ� ...
				// �̰Ŵ� �ݴ� ��ȣ�� ��Ī�Ǵ� ���� ��ȣ�� ���ٴ� �ǹ��̴ϱ�...
				// �̰Ŵ� �߸��� ������... �� �̻� �ٸ� ��ū�� �� �ʿ䵵 ����...
				if (stack.isEmpty()) {
					System.out.println("�߸��� ���Դϴ�...");
					return;
				}
				stack.pop();
			}
		}
		// �帧�� ������� �Դٴ� ����
		// �Ŀ� �߸��� ���� ���ų�, ���� ��ȣ�� �� ���� ���.
		// ��� ��ū ó���� ������, �� ������ �߸��� ��ȣ�� �߰ߵ��� �ʾҴ�.
		if (stack.isEmpty() != true) { // ���� ��ȣ�� �� ���ٴ� �ǹ�.
			System.out.println("�߸��� ���Դϴ�...");
			return;
		}
		
		System.out.println("��ȿ�� ���Դϴ�...");
		
	}
}
