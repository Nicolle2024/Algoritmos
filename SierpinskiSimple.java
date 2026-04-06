package laboratorio4;

import javax.swing.*;
import java.awt.*;

public class SierpinskiSimple extends JPanel {

    private static final long serialVersionUID = 1L;

    // PROCESO DE REPETICIÓN (Recursión)
    void draw(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int n) {
        if (n == 0) {
            // ELEMENTO BASE: Ahora dibujamos el triángulo
            g.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
        } else {
            // Lógica de subdivisión: calculamos los puntos medios de los lados
            int mx12 = (x1 + x2) / 2, my12 = (y1 + y2) / 2;
            int mx23 = (x2 + x3) / 2, my23 = (y2 + y3) / 2;
            int mx31 = (x3 + x1) / 2, my31 = (y3 + y1) / 2;

            // Repetición: Se generan 3 nuevos triángulos en las esquinas
            draw(g, x1, y1, mx12, my12, mx31, my31, n - 1);
            draw(g, mx12, my12, x2, y2, mx23, my23, n - 1);
            draw(g, mx31, my31, mx23, my23, x3, y3, n - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);

        // --- AMPLIACIÓN DINÁMICA ---
        // Usamos getHeight() y getWidth() para que el elemento base 
        // se ajuste al tamaño total de la ventana.
        int margen = 20;
        int x1 = getWidth() / 2;           // Punto Superior Central
        int y1 = margen;
        
        int x2 = margen;                   // Punto Inferior Izquierdo
        int y2 = getHeight() - margen;
        
        int x3 = getWidth() - margen;      // Punto Inferior Derecho
        int y3 = getHeight() - margen;
        
        // Reducimos n a 5 para que los triángulos base se vean más grandes/claros
        draw(g, x1, y1, x2, y2, x3, y3, 5);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Sierpinski Ampliado");
        f.add(new SierpinskiSimple());
        f.setSize(800, 800); // Ventana inicial más grande
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
