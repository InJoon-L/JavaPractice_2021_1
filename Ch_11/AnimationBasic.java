package Ch_11;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class AnimationBasic extends JFrame{
	static final int WIDTH = 600;
	static final int HEIGHT = 800;
	
	public AnimationBasic() {
		this.add(new MyPanel2());
		this.setTitle("애니메이션 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnimationBasic();
	}
}

class MyPanel2 extends JPanel implements ActionListener {
	private Timer timer;
	private BufferedImage image;
	private final int START_X = 0;
	private final int START_Y = 300;
	private int x, y;
	
	public MyPanel2() {
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(AnimationBasic.WIDTH, AnimationBasic.HEIGHT));
		this.setDoubleBuffered(true);
		
		File file = new File("image/space.jpg");
		
		try {
			image = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		x = START_X;
		y = START_Y;
	
		timer = new Timer(20, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 	이미지의 x, y좌표를 적절히 변경
		*/
		
//		if(x > AnimationBasic.WIDTH) {
//			x -= 1;
//			y += 1;
//		}else if(y > AnimationBasic.HEIGHT){
//			x += 1;
//			y -= 1;	
//		}
//		
		repaint();
	}
}