package Ch_18;

import java.io.*;
import java.net.*;

public class HttpURLTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.google.com/search?q=java");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			int responseCode = con.getResponseCode();
			System.out.println("ResponseCode: " + responseCode);
			
			InputStream stream = con.getInputStream();
			
			InputStreamReader isreader = new InputStreamReader(stream);
			
			BufferedReader reader = new BufferedReader(isreader);
			String line;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {

		}
	}
}
