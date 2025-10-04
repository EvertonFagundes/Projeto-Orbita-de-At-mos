package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtomoHidrogenio extends JPanel implements ActionListener {

    private double angulo = 0; // Ângulo da órbita
    private Timer timer;

    public AtomoHidrogenio() {
        // Timer atualiza a cada 20ms (50 FPS)
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int largura = getWidth();
        int altura = getHeight();

        // Centro do painel
        int cx = largura / 2;
        int cy = altura / 2;

        // Desenha o núcleo (próton)
        g2.setColor(Color.RED);
        g2.fillOval(cx - 20, cy - 20, 40, 40);

        // Raio da órbita
        int raio = 100;

        // Posição do elétron
        int ex = (int) (cx + raio * Math.cos(angulo));
        int ey = (int) (cy + raio * Math.sin(angulo));

        // Desenha a órbita (círculo)
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawOval(cx - raio, cy - raio, 2 * raio, 2 * raio);

        // Desenha o elétron
        g2.setColor(Color.BLUE);
        g2.fillOval(ex - 10, ey - 10, 20, 20);

        // Texto
        g2.setColor(Color.BLACK);
        g2.drawString("Átomo de Hidrogênio (1 próton e 1 elétron)", 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Atualiza o ângulo para animar
        angulo += 0.05;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Átomo de Hidrogênio");
        AtomoHidrogenio painel = new AtomoHidrogenio();

        frame.add(painel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
