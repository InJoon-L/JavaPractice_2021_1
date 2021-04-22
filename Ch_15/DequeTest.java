package Ch_15;

import java.util.*;

public class DequeTest {
	public static void main(String[] args) {
		/*
		 	Deque�� �������̽�
		 	�� ���� ������ ���� Ŭ������
		 	ArrayDeque
		 	�������̽��� �ν��Ͻ� ������ X
		*/
		Queue<Integer> queue = new ArrayDeque<>();
		/*
			Queue : a, b �޼ҵ� �ִٸ�
			ArrayDeque : a, b, c, d, e �޼ҵ� ����? O
		*/
		
		// 1. ť�� ���� �� 10�� �ְ�
		// 2. �ȿ� � ������ �� �ִ��� ����
		// 3. �ϳ��� �����غ��� <= FIFO ������ �������� Ȯ��
		
		for (int i = 0; i < 10; i++) queue.add(i + 1); // offer
		System.out.println(queue);
		// poll �޼ҵ�� �ϳ��� ����, FIFO ������ ���;� �ȴ�.
		// ť�� ���Ұ� ������ ��������
		while(/*queue.size() > 0*/ !queue.isEmpty()) {
			Integer val = queue.poll(); // ť�� ����� 1�� ���� remove
			System.out.println(val);
		}
		System.out.println("ť�� ����...");
		System.out.println(queue);
	}
}
