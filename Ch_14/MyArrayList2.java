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
		// 현재 용량으로 추가되는 값을 수용할 수 있으면
		if (size >= capacity) {
			// 수용할 수 없으면 arr 배열의 크기를 늘려야 한다.
			capacity = capacity + capacity/2;
			// 원래 값들을 tmp로 복사
			tmp = new Object[capacity];
			for (int i = 0; i < size; i++) {
				tmp[i] = arr[i];
			}
			// arr이 용량이 늘어난 배열을 가르키도록 한다.
			arr = tmp;
		}
	}
	
	public void add(T value) {
		if(size >= capacity) increaseCapacity();
		
		arr[size++] = value;
	}

	public void add(int idx, T value) {
		if(size >= capacity) increaseCapacity();
		
		// 맨 뒤에 있는 원소부터 오른쪽으로 한 칸씩 민다.
		for (int i = size - 1; i >= idx; i--) {
			arr[i + 1] = arr[i];
		}
		
		// idx 자리에 value를 넣는다.
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
		list2.add("홍길동");
		list2.add("굿");
		
		list2.add(1, "성공");
		
		System.out.println(list2);
		
		MyArrayList2<Student> list3 = new MyArrayList2<>();
		list3.add(new Student("홍길동", 123));
		list3.add(new Student("일지매", 124));
		list3.add(new Student("이몽룡", 125));
		
		System.out.println(list3);
	}	
}
