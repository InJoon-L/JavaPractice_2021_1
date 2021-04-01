package Ch_14;

public class GenericTest {
	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<>();
		
		box1.setContent("동해물과 ");
		String s = box1.getContent();
		System.out.println(s);
		
		GenericBox<Integer> box2 = new GenericBox<>();
		box2.setContent(100);
		Integer i = box2.getContent();
		System.out.println(i);
		
		GenericBox<Student> box3 = new GenericBox<>();
//		box3.setContent(new Student());
		Student std = box3.getContent();
		System.out.println(std);
	}
}
