package Ch_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class FuctionBasic extends JPanel implements ActionListener{
	
	JTextField a, b, c;
	double A, B, C;
	
	public FuctionBasic() {
		JButton button = new JButton("DRAW");
		a = new JTextField("1.0", 10);
		b = new JTextField("5.0", 10);
		c = new JTextField("6.0", 10);
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(button);
		button.addActionListener(this);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FuctionBasic();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawLine(0, 200, 400, 200);
		g2d.drawLine(200, 0, 200, 400);
		g2d.setPaint(Color.red);
		for (int i = -20; i < 20; i++) {
			int x = i;
			int y = (int)(A * x * x + B * x + C);
			Shape s = new Ellipse2D.Float(200 + x - 2, 200 - (y + 2), 4, 4);
//			g2d.fillOval(200 + x - 2, 200 - (y - 2), 4, 4);
			g2d.fill(s);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		A = Double.parseDouble(a.getText());
		B = Double.parseDouble(b.getText());
		C = Double.parseDouble(c.getText());
		
		repaint();
	}
	
}
