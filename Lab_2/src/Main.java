import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {

    private static final int margin = 170;

    Timer timer;

    private double scale = 1;
    private double delta = 0.01;
    private double dx = 1;
    private double tx = margin;
    private double dy = 0;
    private double ty = margin;

    private static int maxWidth;
    private static int maxHeight;

    public Main() {

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {

        int centerX = (int)(tx);
        int centerY = (int)(ty);
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, maxWidth, maxHeight);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        g2d.setBackground(Color.WHITE);

        BasicStroke bs1 = new BasicStroke(10, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawRect(margin, margin, maxWidth - margin*2, maxHeight - margin*2);

        int ellipseWidth = (int) (scale*30);
        int ellipseHeight = (int) (scale*90);

        g2d.setColor(new Color(165,255,0));
        g2d.fillOval(centerX - ellipseWidth/2, centerY - ellipseHeight/2, ellipseWidth, ellipseHeight);

        GradientPaint gp = new GradientPaint(5, 25,
                new Color(255,255,0), 20, 2, new Color(0,0,255), true);
        g2d.setPaint(gp);
        int point2X = (int) (scale * 160);
        int point2Y = (int) (scale * 25);
        int point3X = (int) (scale * 70);
        int point3Y = (int) (scale * 95);
        g2d.fillPolygon(new int[]{centerX, centerX - point2X, centerX - point3X},
                new int[]{centerY, centerY-point2Y, centerY - point3Y}, 3);

        g2d.fillPolygon(new int[]{centerX, centerX - point2X, centerX - point3X},
                new int[]{centerY,centerY+point2Y, centerY + point3Y}, 3);

        g2d.fillPolygon(new int[]{centerX, centerX + point2X, centerX + point3X},
                new int[]{centerY, centerY-point2Y, centerY - point3Y}, 3);

        g2d.fillPolygon(new int[]{centerX, centerX + point2X, centerX + point3X},
                new int[]{centerY, centerY + point2Y, centerY + point3Y}, 3);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawLine(centerX - (int)(scale * 5), centerY - point2Y, centerX - (int) (scale * 20), centerY - (int)(scale * 115));
        g2d.drawLine(centerX + (int)(scale * 5), centerY - point2Y, centerX + (int) (scale * 20), centerY - (int)(scale * 115));

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Main());
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( scale < 0.01 ) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }


        if ( tx < margin ) {
            dx = 0;
            dy = -1;
            tx = margin;
        } else if ( tx > maxWidth - margin ) {
            dx = 0;
            dy = 1;
            tx = maxWidth - margin;
        }

        if ( ty < margin ) {
            dy = 0;
            dx = 1;
            ty = margin;
        } else if ( ty > maxHeight - margin ) {
            dy = 0;
            dx = -1;
            ty = maxHeight - margin;
        }

        scale += delta;
        tx += dx;
        ty += dy;

        repaint();
    }
}