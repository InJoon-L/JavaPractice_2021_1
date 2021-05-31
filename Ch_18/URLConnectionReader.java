package Ch_18;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
	public static void main(String[] args) {
		try {
			// 1. URL ��ü 
			URL site = new URL("https://www.naver.com/");
			
			// 2. URL ��ü�κ��� �� ����Ʈ�� ������ �õ��Ѵ�. openConnection();
			URLConnection con = site.openConnection();
			
			InputStream stream = con.getInputStream();
			
			InputStreamReader isreader = new InputStreamReader(stream);
			
			BufferedReader reader = new BufferedReader(isreader);
			String line;
		
			while ((line = reader.readLine()) != null) {
					System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}