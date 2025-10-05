package telas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AtomPanel extends JPanel {
    private int nElectrons;
    private double[] angles;
    private double speed; // radianos por tick
    private Timer timer;
    private JButton btnBack;

    public AtomPanel(int nElectrons, double speed, ActionListener backListener) {
        this.nElectrons = Math.max(1, nElectrons);
        this.speed = speed;
        angles = new double[this.nElectrons];
        for (int i = 0; i < this.nElectrons; i++) angles[i] = 2 * Math.PI * i / this.nElectrons;
        setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnBack = new JButton("Voltar");
        btnBack.addActionListener(backListener);
        top.add(btnBack);
        add(top, BorderLayout.NORTH);

        timer = new Timer(20, e -> {
            for (int i = 0; i < angles.length; i++) angles[i] += speed;
            repaint();
        });
        // NÃO start aqui; MainFrame controlará quando mostrar a tela
    }

    public void startAnimation() { if (!timer.isRunning()) timer.start(); }
    public void stopAnimation()  { if (timer.isRunning()) timer.stop();  }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();
        int cx = w / 2, cy = h / 2;
        int orbitR = Math.min(w, h) / 4;

        // núcleo
        g2.setColor(new Color(200,100,0));
        g2.fillOval(cx - 20, cy - 20, 40, 40);

        // órbita
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(cx - orbitR, cy - orbitR, 2 * orbitR, 2 * orbitR);

        // elétrons
        for (int i = 0; i < nElectrons; i++) {
            double a = angles[i];
            int ex = cx + (int) (orbitR * Math.cos(a));
            int ey = cy + (int) (orbitR * Math.sin(a));
            g2.setColor(Color.BLUE);
            g2.fillOval(ex - 8, ey - 8, 16, 16);
        }

        g2.dispose();
    }
}
