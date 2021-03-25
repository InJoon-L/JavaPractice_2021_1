package Ch_14;

public class TestMyResource {
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test1() {
		MyResource r = new MyResource();
		
		try {
			System.out.println(r.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			r.close();
		}
	}
	
	public static void test2() {
		try (MyResource r = new MyResource()) {
			System.out.println(r.getValue());
		} catch (OutOfResourcesException e) {
			System.out.println(e.getMessage());
		}
	}
}
