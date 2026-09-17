import javax.swing.*;
import java.awt.*;

public class Grapher extends JPanel {

    // ===================================================================
    //   >>> THIS IS THE ONLY LINE YOU PLAY WITH <<<
    //
    //   Given x, return y. This is your equation. Right now: y = x * x
    //   (a parabola).  Change it and re-run to see a different shape!
    //
    //   Try these one at a time:
    //       return x * x;              // a U-shaped parabola
    //       return x * x * x;          // an S-shaped curve
    //       return 2 * x + 1;          // a straight line
    //       return Math.sin(x);        // a wave
    //       return Math.sin(x) * x;    // a wave that grows
    //       return 5 / x;              // a curve that flies off near 0
    //       return Math.abs(x);        // a V shape
    // ===================================================================
    double f(double x) {
        return x * x * 2/3;
    }


    // ============ plumbing below — ignore this for now ============

    static final double VIEW = 10;   // we show x and y from -10 to +10

    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();

        // background
        g.setColor(new Color(20, 22, 30));
        g.fillRect(0, 0, w, h);

        // grid lines
        g.setColor(new Color(45, 48, 60));
        for (int i = -(int) VIEW; i <= VIEW; i++) {
            int sx = toScreenX(i, w), sy = toScreenY(i, h);
            g.drawLine(sx, 0, sx, h);   // vertical grid line
            g.drawLine(0, sy, w, sy);   // horizontal grid line
        }

        // the x and y axes (brighter)
        g.setColor(new Color(120, 125, 140));
        g.drawLine(0, toScreenY(0, h), w, toScreenY(0, h));   // x-axis
        g.drawLine(toScreenX(0, w), 0, toScreenX(0, w), h);   // y-axis

        // THE CURVE: walk across every screen pixel, ask f(x) for its y, connect dots
        g.setColor(new Color(80, 220, 255));
        g.setStroke(new BasicStroke(2.5f));
        int prevSx = -1, prevSy = -1;
        for (int px = 0; px < w; px++) {
            double x = fromScreenX(px, w);
            double y = f(x);
            int sx = px;
            int sy = toScreenY(y, h);
            if (prevSx >= 0 && sy > -5000 && sy < 5000)   // skip crazy jumps
                g.drawLine(prevSx, prevSy, sx, sy);
            prevSx = sx; prevSy = sy;
        }

        g.setColor(Color.WHITE);
        g.drawString("y = (your equation in f)   —   view from -10 to +10", 12, 20);
    }

    // convert between math coordinates and screen pixels
    int toScreenX(double x, int w) { return (int) ((x + VIEW) / (2 * VIEW) * w); }
    int toScreenY(double y, int h) { return (int) (h - (y + VIEW) / (2 * VIEW) * h); }
    double fromScreenX(int px, int w) { return px / (double) w * (2 * VIEW) - VIEW; }

    public static void main(String[] args) {
        JFrame f = new JFrame("Math Grapher");
        Grapher panel = new Grapher();
        panel.setPreferredSize(new Dimension(700, 700));
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
