package Ch_15;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test2() {
		/*
			ģ���� ��ȭ��ȣ�� �����ϴ� map ��ü �����Ҳ���
			<�̸�, ��ȭ��ȣ> "ȫ�浿", "010-1234-5678"
		*/
		String[] names = {"ȫ�浿", "������", "������", "�̸���"};
		String[] phones = {"010-1234-5678", "010-2234-5578", "010-1235-7678", "010-2244-8778"};
		Map<String, String> phoneBook = new HashMap<>();
		for (int i = 0; i < names.length; i++) {
			phoneBook.put(names[i], phones[i]);
		}
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("ģ�� �̸�: ");
			String name = input.nextLine();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name + "�� ��ȭ��ȣ�� " + phone + "�Դϴ�.");
		}
	}
	
	public static void test1() {
		/*
			Map ��ü, HashMap ��ü�� ��������.
			���� <key, value>�� ������ �����ϰ�
			key���� ���� ���� �����Ѵ�.
			Map�̶�� ���� generic �������̽��̰�
			�̱� ������ HashMap, TreeMap, LinkedHashMap Ŭ��������
			���׸� Ŭ������� ���̴�.
			�� �ǹ̴�
			�� ��ü���� ������ �� Ÿ���� ��������� �Ѵ�.
		*/
		
		// ArrayList<Integer> list = new ArrayList<>();
		// ArrayList<String> list2 = new ArrayList<>();
		// ArrayList<Student> list3 = new ArrayList<>();
		
		// Map�� <�й�, �л���ü> �̷��� ������ ����.
		Map<String, Student> map = new HashMap<>();
		map.put("2000101", new Student(2000101, "ȫ�浿"));
		map.put("2000102", new Student(2000102, "������"));
		map.put("2000103", new Student(2000103, "�̸���"));
		map.put("2000104", new Student(2000104, "������"));
		map.put("2000105", new Student(2000105, "����"));
		
//		Student value = map.get("2000103");
//		System.out.println(value.getName());
//		
//		map.put("2000103", new Student(2000103, "�̻��"));
//		value = map.get("2000103");
//		System.out.println(value.getName());
		
		/*
			map�̶�� �ڷᱸ���� �� �ִ� ��� ���ҵ��� �� ���� �� �ִ� �����
			1. map���� �ϰ� ���� ������ ��� Ű������ ��û�ϰ� 
			�� ������ �� ���Ҹ� ������ map���� ���� ��û�ϴ� ���
			2. map���� <key, value> ������ ����� ��Ʈ�� ������ ��û�ؼ�
			�� ������ ���Ҹ� �ϳ��� �д� ���.
		*/
		Set<String> keyset = map.keySet();
		// Set�� ���Ҹ� �ϳ��� �����ϴ� ����� ������?
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		
		// map���� ��Ʈ���� ���� <key, value>�� ������ ������ ��ü.
		// ��ü�� ���� �� ��ü�� �����ϴ� Ŭ������ �ִٴ� �ǹ�.
		Set<Map.Entry<String, Student>> entry = map.entrySet();
		Iterator<Map.Entry<String, Student>> iter2 = entry.iterator();
		while(iter2.hasNext()) {
			Map.Entry<String, Student> entryObj = iter2.next();
			String key = entryObj.getKey();
			Student val = entryObj.getValue();
			System.out.println("key: " + key + ", value: " + val);
		}
		
		for (Map.Entry<String, Student> s : map.entrySet()) {
			System.out.println(s);
		}
	}
}

class Student {
	private int hakbun;
	private String name;
	
	@Override
	public String toString() {
		return "[�й�: " + getHakbun() + ", �̸�: " + getName() + "]";
	}
	
	public Student(int hakbun, String name) {
		super();
		this.hakbun = hakbun;
		this.name = name;
	}
	
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}