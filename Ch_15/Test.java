package Ch_15;

import java.util.*;
import java.io.*;

public class Test {
	public static void main(String[] args) {
		Properties props = new Properties();
		try (FileReader reader = new FileReader("dict.props")) {
			props.load(reader);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		
		System.out.println(props.get("사과"));
		props.put("이름", "name");
		try (FileOutputStream out = new FileOutputStream("dict.props")) {
			props.store(out, "나의 한영사전");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
