package Ch_14;

import java.util.*;

public class AssertionTest {
	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.println("��¥�� �Է��Ͻÿ�:");
//		int date = input.nextInt();
//		
//		assert date >= 1 && date <= 31 : "�߸��� ��¥: " + date;
//		
//		System.out.printf("�Էµ� ��¥�� %d �Դϴ�.\n", date);
	
		int[] nums = {0, 3, 4, 6};
		System.out.println(sumArray(nums));
	}
	
	public static int sumArray(int[] nums) {
		assert nums != null : "array is null!";
		assert nums.length > 0 : "No element in array";
		assert nums[0] > 1 : "The first element must be larger than 1";
		int total = 0;
		
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		return total;
	}
}
