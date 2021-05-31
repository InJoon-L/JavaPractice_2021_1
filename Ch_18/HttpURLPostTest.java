package Ch_18;

import java.net.*;
import java.io.*;

public class HttpURLPostTest {
	public static void main(String[] args) {
		String site = "http://localhost:8080/test";

		try {
			URL url = new URL(site);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			// id=scpark
			
			OutputStream stream = con.getOutputStream();
			
			OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
			
			PrintWriter writer = new PrintWriter(owriter);
			
			writer.println("id=scpark&pw=1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
