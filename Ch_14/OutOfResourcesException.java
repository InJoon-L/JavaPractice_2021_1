package Ch_14;

public class OutOfResourcesException extends Exception{
	public OutOfResourcesException() {
		System.out.println("OutOfResourceException ��ü ����");
	}
	
	public OutOfResourcesException(String msg) {
		super(msg);
		System.out.println("OutOfResourceException ��ü ����");
	}
}
