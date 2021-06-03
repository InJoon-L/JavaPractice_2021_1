package Ch_18;

import java.net.*;
import java.io.*;

public class HttpURLPostTest {
	public static void main(String[] args) {
		String site = "http://localhost:9090/todos";

		try {
			URL url = new URL(site);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			// id=scpark
			String data = "id=scpark&pw=1111";
			
			OutputStream stream = con.getOutputStream();
			
			OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
			
			PrintWriter writer = new PrintWriter(owriter);
			
			writer.println(data);
			writer.flush();
			
			InputStream istream = con.getInputStream();
			
			InputStreamReader ireader = new InputStreamReader(istream);
			
			BufferedReader reader = new BufferedReader(ireader);
		    String line;
		    
		    while((line = reader.readLine()) != null) {
		       System.out.println(line);
		    }
		    
		    System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
