package Ch_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;

public class BookListViewer extends JFrame implements ActionListener {
	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_SERVER_URL = "jdbc:mysql://localhost:3306/java";
	private static final String DB_USER = "root";
	private static final String DB_USER_PW = "dls980728";
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection con = null;
	
	public BookListViewer() throws Exception {
		/*
		 	DB에서 책 레코드들을 가져오자.
		 	1. JDBC 드라이버 적재
		 	2. DB 연결
		 	3. PreparedStatement 객체 생성
		 	4. SQL문 실행.
		*/
		
		Class.forName(JDBC_DRIVER);
		
		con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW);
		String sql = "select * from books order by book_id desc";
		pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		// select 문을 실행할 때는 executeQuery() 메서드를 사용하고
		// 그 외, insert, delete, update 문을 실행할 때는
		// executeUpdate() 메서드를 사용한다.
		
		rs = pstmt.executeQuery();
		
		// 이 JFrame 객체(this)의 Layout을 GridLayout으로 설정(0, 2)
		this.setLayout(new GridLayout(0, 2));

		// 컴포넌트들을 생성
		// 생성된 컴포넌트들을 JFrame 객체(this)에 추가한다.
		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField(10);
		this.add(idField);

		this.add(new JLabel("Title", JLabel.CENTER));
		titleField = new JTextField(10);
		this.add(titleField);
		
		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField(10);
		this.add(publisherField);
		
		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField(10);
		this.add(yearField);
		
		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField(10);
		this.add(priceField);
		
		// 버튼 컴포넌트들의 액션리스너를 이 객체(this)로 설정한다.
		previousBtn = new JButton("Previous");
		previousBtn.addActionListener(this);
		this.add(previousBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(this);
		this.add(insertBtn);
		
		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(this);
		this.add(finishBtn);
		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setSize(350, 200);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		// BookListViewer 클래스의 인스턴스 생성
		new BookListViewer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == previousBtn) {
				System.out.println("previousBtn clicked...");
				// 결과집합의 커서를 이전으로 이동하고 
				rs.previous();
				// 그 커서가 가리키는 결과 레코드의 칼럼값을 뽑아 와서
				// 적절한 JTextField 값으로 설정.
				setCurrentBookInfo2TextField();
			} else if (e.getSource() == nextBtn) {
				System.out.println("nextBtn clicked...");
				// 결과집합의 커서를 다음으로 이동하고 
				rs.next();
				// 그 커서가 가리키는 결과 레코드의 칼럼값을 뽑아 와서
				// 적절한 JTextField 값으로 설정.
				setCurrentBookInfo2TextField();
				
			} else if (e.getSource() == insertBtn) {
				System.out.println("insertBtn clicked...");
			} else if (e.getSource() == finishBtn) {
				System.out.println("finishBtn clicked...");
				System.out.println("프로그램을 종료합니다...");
				con.close();
				System.exit(0); // 프로세스를 종료시킨다.
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void setCurrentBookInfo2TextField() throws Exception {
		// book_id, title, publisher, year, price
		int bookId = rs.getInt("book_id");
		String title = rs.getString("title");
		String publisher = rs.getString("publisher");
		Date year = rs.getDate("year");
		int price = rs.getInt("price");
		
		idField.setText(String.valueOf(bookId));
		titleField.setText(title);
		publisherField.setText(publisher);
		yearField.setText(year.toString());
		priceField.setText(String.valueOf(price));
	}
	
}
