package Ch_15;

import java.util.Comparator;

// String 값을 비교하는 비교자 클래스를 정의한다.
public class MyStringComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		// o1이 크면 양수 반환, o1과 o2가 같으면 0을 반환
		// o2가 크면 음수 반환
		// 문자열 값의 비교는 Comparable 인터페이스를 구현하고 있는 String 클래스의
		// compare 메소드를 호출하면 된다.
		return -o1.compareTo(o2);
	}

}
