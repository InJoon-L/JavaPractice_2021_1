package Ch_15;

import java.util.*;

public class CollectionsAPITest {
	private String name;
	
	public CollectionsAPITest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		String[] sample = {"i", "walk", "the", "line"};
		List<String> list = Arrays.asList(sample);
		// Collections�� sort �޼���� List Ÿ����
		// ���ڷ� ������.
		System.out.println("������...");
		System.out.println(list);
		
//		Collections.sort(list); // �⺻ �������� ����
		// ������ Ÿ�� Ŭ������ ���� ������ �� ������
		// Comparable �������̽��� �����ؼ� ���� ����� ������ �� �ִ�.
		// ������ Ÿ�� Ŭ������ ���� ������ �� ������ (���� ���, String, Integer...)
		// Comparator Ŭ������ �����ؼ� ���� ����� �˷���� �Ѵ�.
		// �Ǵ� ������ Ÿ�� Ŭ������ ������ �� ������, �� Ŭ������ �������� �ʰ�
		// ���� ����� �����ϰ��� �� ���� comparator Ŭ������ ������ �ش�.
		Collections.sort(list, new MyStringComparator());
		System.out.println("�������� ������...");
		System.out.println(list);
	}
	
	public static int add(int n1, int n2) {
		return n1 + n2;
	}
}
