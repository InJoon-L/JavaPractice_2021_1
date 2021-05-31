package Ch_18;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
	public static void main(String[] args) {
		try {
			// 1. URL 객체 
			URL site = new URL("https://www.naver.com/");
			
			// 2. URL 객체로부터 저 사이트로 연결을 시도한다. openConnection();
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
