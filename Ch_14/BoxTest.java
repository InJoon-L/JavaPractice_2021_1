package Ch_14;

public class BoxTest {
	
	public static void main(String[] args) {
//		Box box = new Box();
//		box.setContent("���ع��� ��λ���");
//		String cont = box.getContent();
//		
//		System.out.println(cont);
//		Box2 box2 = new Box2();
//		box2.setContent(100);
//		Integer cont2 = box2.getContent();
//		System.out.println(cont2);
		
//		Box3 box3 = new Box3();
//		Student std = new Student();
//		std.setName("ȫ�浿");
//		std.setDept("����");
//		std.setGrade(100);
//		box3.setContent(std);
//		System.out.println(box3.getContent());
		
		Box4 box4 = new Box4();
//		box4.setContent(new Student());
//		box4.setContent(100);
		box4.setContent("������ �⵵��");
		
		process(box4);
	}
	
	public static void process(Box4 box) {
		Object obj = box.getContent();
		if(obj instanceof Student) {
			Student std = (Student)obj;
		
			String s = std.getName();
			int n = std.getGrade();
			//DB���̺� ����...
		} else if (obj instanceof String) {
			// ���ڿ�
		} else if(obj instanceof Integer) {
			// ����
		}
	}
}
