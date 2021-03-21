package Ch_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Capture extends JPanel implements ActionListener {

    JButton btn_capture;
    Image img = null;

    public Capture() {
        this.btn_capture = new JButton("영상캡쳐");
        this.btn_capture.addActionListener(this);
        this.setLayout(new BorderLayout());
        this.add(this.btn_capture, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("영상캡쳐")) {
            System.out.println("영상을 캡쳐합니다..");
            this.capture();                     
        }
    }

    private void drawImage(Image img, int x, int y) {
        Graphics g = this.getGraphics();
        g.drawImage(img, 0, 0, x, y, this);
        this.paint(g);
        this.repaint();
    }

    public void paint(Graphics g) {
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this.img.getWidth(this), this.img.getHeight(this), this);
        }
    }

    public void capture() {
        Robot robot;
        BufferedImage bufImage = null;
        try {
            robot = new Robot();
            Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            bufImage = robot.createScreenCapture(area);     
            int w = this.getWidth();
            int h = this.getHeight();

            this.img = bufImage.getScaledInstance(w, h - 20, Image.SCALE_DEFAULT);
            this.drawImage(img, w, h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFrame() {
        JFrame frame = new JFrame("Capture");
        JFrame.setDefaultLookAndFeelDecorated(true);
        Container cont = frame.getContentPane();
        cont.setLayout(new BorderLayout());
        Capture mm = new Capture();
        cont.add(mm, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String... v) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        createFrame();
    }
}

