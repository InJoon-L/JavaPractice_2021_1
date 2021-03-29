package Ch_12;

import javax.swing.*;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

//���߿� papago api �߰�����
public class PapagoApi extends JFrame implements ActionListener{
	private JButton converBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	private final String CLIENT_ID = Config.CLIENT_ID;//���ø����̼� Ŭ���̾�Ʈ ���̵�";
    private final String CLINENT_SECRET = Config.CLINENT_SECRET;//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
    private final String API_URI = "https://openapi.naver.com/v1/papago/n2mt";
    
	public PapagoApi() {
		this.setTitle("�ؽ�Ʈ ��ȯ");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		converBtn = new JButton("��ȯ");
		cancelBtn = new JButton("���");
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
		 	��ȯ ��ư�� Ŭ���Ǿ��ٸ�
		 		���� textArea�� �ؽ�Ʈ�� �о In
		 		����� ��ȯ�ϰ� �� ��ȯ�� ����� 
		 		���� textArea�� append Out
		 	��� ��ư�� Ŭ���Ǿ��ٸ�
		 		������ �� ���ڿ��� ���� Out
		 */
		if(e.getSource() == converBtn) {
			String result = toEnglish(textIn.getText());
			textOut.setText(result);
		} else {
			textOut.setText("");
		}
	}
	
	private String toEnglish(String korean) {
		// korean ���ڿ��� ����� ��ȯ�ؼ� ��ȯ..
		/*
		 	�ؽ�Ʈ => text
		 	���� => english
		 */
		String text;
		try {
            text = URLEncoder.encode(korean, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("���ڵ� ����", e);
        }
		
		Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLINENT_SECRET);

        String result = post(API_URI, requestHeaders, text);

		return result;
	}
	
	private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; //�������: �ѱ��� (ko) -> �������: ���� (en)
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
            if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ����
                return readBody(con.getInputStream());
            } else {  // ���� ����
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ��û�� ���� ����", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonOb1;
        String result = null;
        
        try {
			jsonOb1 = (JSONObject) jsonParser.parse(streamReader);
			JSONObject jsonOb2 = (JSONObject) jsonOb1.get("message");
			JSONObject jsonOb3 = (JSONObject) jsonOb2.get("result");
			result = jsonOb3.get("translatedText").toString();
	        
	        System.out.println("3: " + jsonOb3);
	        System.out.println("����: " + result);
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