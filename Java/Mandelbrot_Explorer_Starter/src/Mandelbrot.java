import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends JPanel {

    // How many times we repeat z = z*z + c before giving up and calling it "inside".
    static final int MAX_ITER = 200;

    // The window we're looking at in the math plane. Click to zoom in!
    double centerX = -0.5, centerY = 0.0, scale = 3.0;

    // ====================================================================
    //  >>> YOUR MISSION <<<
    //  Given a point c = (cx, cy) on the math plane, return how many steps
    //  it takes for z = z*z + c to "escape" (fly outside a circle of radius 2).
    //  Return MAX_ITER if it never escapes (that point is INSIDE the set).
    //
    //  The math, step by step:
    //    - z is a complex number with a real part (zx) and imaginary part (zy).
    //    - Start:  zx = 0,  zy = 0
    //    - Each step, compute z*z + c. For complex numbers:
    //          new zx = zx*zx - zy*zy + cx
    //          new zy = 2*zx*zy        + cy
    //      (CAREFUL: compute the new zx and zy using a temp, so you don't
    //       overwrite zx before you've used it to compute zy!)
    //    - "Escaped" means the distance from origin > 2, i.e. zx*zx + zy*zy > 4.
    //    - Count how many steps until it escapes (max MAX_ITER).
    // ====================================================================
    static int escapeCount(double cx, double cy) {
        // TODO: write the loop described above and return the step count.
        return 0;   // <-- replace this. Right now everything is the same color.
    }


    // ============ scaffolding below — you don't need to edit this ============

    BufferedImage img;

    void render() {
        int w = getWidth(), h = getHeight();
        if (w == 0 || h == 0) return;
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int py = 0; py < h; py++) {
            for (int px = 0; px < w; px++) {
                // map this pixel to a point on the math plane
                double cx = centerX + (px - w / 2.0) * scale / w;
                double cy = centerY + (py - h / 2.0) * scale / w;

                int n = escapeCount(cx, cy);
                img.setRGB(px, py, color(n));
            }
        }
        repaint();
    }

    // turn an escape count into a color: black if inside, rainbow if it escaped
    int color(int n) {
        if (n >= MAX_ITER) return 0x000000;            // inside the set -> black
        float hue = (n % 64) / 64.0f;                  // cycle through the rainbow
        return Color.HSBtoRGB(hue, 0.85f, 1.0f);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) g.drawImage(img, 0, 0, null);
        g.setColor(Color.WHITE);
        g.drawString("Click = zoom in   |   Right-click = zoom out", 10, 20);
    }

    Mandelbrot() {
        setPreferredSize(new Dimension(800, 800));
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int w = getWidth(), h = getHeight();
                // recenter on where you clicked
                centerX += (e.getX() - w / 2.0) * scale / w;
                centerY += (e.getY() - h / 2.0) * scale / w;
                if (SwingUtilities.isRightMouseButton(e)) scale *= 2.0;  // zoom out
                else                                      scale *= 0.5;  // zoom in
                render();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Mandelbrot — click to zoom");
            Mandelbrot m = new Mandelbrot();
            f.add(m);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            m.render();
        });
    }
}
