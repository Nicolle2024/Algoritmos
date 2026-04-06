import javax.swing.*;
import java.awt.*;

public class SierpinskiSimple extends JPanel {

    void draw(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int n) {
        if (n == 0) {
            g.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
        } else {
            int mx12 = (x1 + x2) / 2, my12 = (y1 + y2) / 2;
            int mx23 = (x2 + x3) / 2, my23 = (y2 + y3) / 2;
            int mx31 = (x3 + x1) / 2, my31 = (y3 + y1) / 2;

            draw(g, x1, y1, mx12, my12, mx31, my31, n - 1);
            draw(g, mx12, my12, x2, y2, mx23, my23, n - 1);
            draw(g, mx31, my31, mx23, my23, x3, y3, n - 1);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, 100, 500, 500, 500, 300, 100, 5);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new Sierpinski());
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
