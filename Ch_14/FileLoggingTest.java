package Ch_14;

import java.util.logging.*;

public class FileLoggingTest {
	private static final Logger logger = Logger.getLogger(FileLoggingTest.class.getName());
	
	public static void main(String[] args) {
		Handler handler = null;
		try {
			handler = new FileHandler("logger.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.addHandler(handler);
		logger.setLevel(Level.FINE);
		logger.info("info ���� �޽���");
		logger.warning("warning ���� �޽���");
		logger.finer("finer ���� �޽���");
		logger.finest("finest ���� �޽���");
		
		handler.flush();
		handler.close();
		
	}
}
