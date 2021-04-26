package Ch_14;

import java.util.*;

public class MyArrayList2<T> {
	private Object[] arr;
	private Object[] tmp;
	private int capacity = 10;
	private int size = 0;
	
	public MyArrayList2() {
		arr = new Object[capacity];
	}
	
	private void increaseCapacity() {
		// ���� �뷮���� �߰��Ǵ� ���� ������ �� ������
		if (size >= capacity) {
			// ������ �� ������ arr �迭�� ũ�⸦ �÷��� �Ѵ�.
			capacity = capacity + capacity/2;
			// ���� ������ tmp�� ����
			tmp = new Object[capacity];
			for (int i = 0; i < size; i++) {
				tmp[i] = arr[i];
			}
			// arr�� �뷮�� �þ �迭�� ����Ű���� �Ѵ�.
			arr = tmp;
		}
	}
	
	public void add(T value) {
		if(size >= capacity) increaseCapacity();
		
		arr[size++] = value;
	}

	public void add(int idx, T value) {
		if(size >= capacity) increaseCapacity();
		
		// �� �ڿ� �ִ� ���Һ��� ���������� �� ĭ�� �δ�.
		for (int i = size - 1; i >= idx; i--) {
			arr[i + 1] = arr[i];
		}
		
		// idx �ڸ��� value�� �ִ´�.
		arr[idx] = value;
		size++;
	}
	
	public void remove() {
		if (size > 0) size--;
	}

	public void remove(int idx) {
		if(idx < size) {
			for(int i = idx; i < size - 1; i++) {
				arr[i] = arr[i + 1];
			}
			
			if (size > 0) size--;
		}
	}
	
	public T get(int idx) {
		return (T)arr[idx];
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < size; i++) {
			if(i == 0) result += arr[i];
			else result += "," + arr[i];
		}
		result += "]";
		return result;
	}
	
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>(); 
		MyArrayList2<Integer> list = new MyArrayList2<>();
		System.out.println(list);
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		System.out.println(list);
		
		list.add(3, 100);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
//		list.add(3, 100);
//		System.out.println(list);
//		
//		list.remove(3);
//		list.remove(Integer.valueOf(100));
//		System.out.println(list);
		MyArrayList2<String> list2 = new MyArrayList2<>();
		list2.add("ȫ�浿");
		list2.add("��");
		
		list2.add(1, "����");
		
		System.out.println(list2);
		
		MyArrayList2<Student> list3 = new MyArrayList2<>();
		list3.add(new Student("ȫ�浿", 123));
		list3.add(new Student("������", 124));
		list3.add(new Student("�̸���", 125));
		
		System.out.println(list3);
	}	
}
