package Ch_18;

import java.net.*;
import java.io.*;
import com.google.gson.*;
import java.sql.*;

public class PostJson {
	public static void main(String[] args) throws Exception {
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();
		
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

		BufferedReader bufReader = new BufferedReader(reader);
		
		String line = null;
		String jsonString = "";
		while ((line = bufReader.readLine()) != null) {
//			System.out.println(line);
			jsonString += line;
		}
		
		Gson gson = new Gson();
//		String json = "[{'userId': 1, 'id': 1, 'title': 'test', 'body': 'test body'},"
//				+ "{'userId': 2, 'id': 2, 'title': 'test2', 'body': 'test body2'}]";
		Post[] posts = gson.fromJson(jsonString, Post[].class);
		/*
		 	Post post = new Post();
		 	post.setUserId(1);
		 	post.setId(1);
		 	post.setTitle("title");
		 	post.setBody("test body");
		 	return post;
		*/
		
//		System.out.println(post[1].getUserId());
//		System.out.println(post[1].getId());
//		System.out.println(post[1].getTitle());
//		System.out.println(post[1].getBody());
		
		for (Post post : posts) {
			System.out.println("UserId: " + post.getUserId());
			System.out.println("Id: " + post.getId());
			System.out.println("Title: " + post.getTitle());
			System.out.println("Body: " + post.getBody());
		}
		
		insertIntoDB(posts);
		

		
	}
	
	private static void insertIntoDB(Post[] posts) throws Exception{
		/*
			1. Class.forName(...);  JDBC 드라이버 메모리에 적재
			2. Connection con =
				DriverManger.getConnection(...); DB 서버에 연결
			3. String sql = "insert into posts(userId, id, title, body)
								values(?, ?, ?, ?)";
			   PreparedStatement pstmt = con.prepareStatement(sql);
			4. ? 자리에 들어갈 값을 설정한다.
			  pstmt.setInt(1, post.getUserId());
			  pstmt.setInt(2, post.getId());
			  pstmt.setString(3, post.getTitle());
			  pstmt.setString(4, post.getBody());
			  
			5. 서버에 실행 요청
			  pstmt.executeUpdate();
			6. con.close();
		*/
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pw = "dls980728";
		Connection con = DriverManager.getConnection(url, id, pw);
		String sql = "insert into posts(userId, id, title, body) values (?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for (Post post : posts) {
			pstmt.setInt(1, post.getUserId());
			pstmt.setInt(2, post.getId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getBody());
			pstmt.executeUpdate();
		}
		
		con.close();
	}
}
