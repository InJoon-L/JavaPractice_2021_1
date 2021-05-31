package Ch_12;

import javax.swing.*;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class PapagoApi extends JFrame implements ActionListener{
	private JButton converBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	private final String CLIENT_ID = Config.CLIENT_ID;//애플리케이션 클라이언트 아이디값";
    private final String CLINENT_SECRET = Config.CLINENT_SECRET;//애플리케이션 클라이언트 시크릿값";
    private final String API_URI = "https://openapi.naver.com/v1/papago/n2mt";
    
	public PapagoApi() {
		this.setTitle("텍스트 변환");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		converBtn = new JButton("변환");
		cancelBtn = new JButton("취소");
		converBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(converBtn);
		btnPanel.add(cancelBtn);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 	변환 버튼이 클릭되었다면
		 		좌측 textArea의 텍스트를 읽어서 In
		 		영어로 변환하고 그 변환된 결과를 
		 		우측 textArea에 append Out
		 	취소 버튼이 클릭되었다면
		 		우측을 빈 문자열로 설정 Out
		 */
		if(e.getSource() == converBtn) {
			String result = toEnglish(textIn.getText());
			textOut.setText(result);
		} else {
			textOut.setText("");
		}
	}
	
	private String toEnglish(String korean) {
		// korean 문자열을 영어로 변환해서 반환..
		/*
		 	텍스트 => text
		 	영어 => english
		 */
		String text;
		try {
            text = URLEncoder.encode(korean, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }
		
		Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLINENT_SECRET);

        String result = post(API_URI, requestHeaders, text);

		return result;
	}
	
	private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonOb1;
        String result = null;
        
        try {
			jsonOb1 = (JSONObject) jsonParser.parse(streamReader);
			System.out.println(jsonOb1);
			JSONObject jsonOb2 = (JSONObject) jsonOb1.get("message");
			JSONObject jsonOb3 = (JSONObject) jsonOb2.get("result");
			result = jsonOb3.get("translatedText").toString();
	        
	        System.out.println("3: " + jsonOb3);
	        System.out.println("번역: " + result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return result;
    }
    
	public static void main(String[] args) {
		new PapagoApi();
	}
	

}
