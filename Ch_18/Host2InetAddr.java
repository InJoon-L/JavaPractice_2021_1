package Ch_18;

import java.net.*;

public class Host2InetAddr {
	public static void main(String[] args) {
		String hostName = "www.naver.com";
		
		try {
			InetAddress address = InetAddress.getByName(hostName);
			System.out.println("IP аж╪р: " + address.getHostAddress());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
