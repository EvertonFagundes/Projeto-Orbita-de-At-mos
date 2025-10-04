package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtomoHelio extends JPanel implements ActionListener {

    private double angulo = 0; // Ângulo da órbita
    private Timer timer;

    public AtomoHelio() {
        // Atualiza a cada 20ms
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

        // Desenha o núcleo (2 prótons representados juntos)
        g2.setColor(Color.RED);
        g2.fillOval(cx - 25, cy - 25, 50, 50);

        g2.setColor(Color.WHITE);
        g2.drawString("2p+", cx - 10, cy + 5);

        // Raio da órbita
        int raio = 120;

        // Desenha a órbita
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawOval(cx - raio, cy - raio, 2 * raio, 2 * raio);

        // Elétron 1
        int ex1 = (int) (cx + raio * Math.cos(angulo));
        int ey1 = (int) (cy + raio * Math.sin(angulo));

        // Elétron 2 (defasado de 180°)
        int ex2 = (int) (cx + raio * Math.cos(angulo + Math.PI));
        int ey2 = (int) (cy + raio * Math.sin(angulo + Math.PI));

        // Desenha os elétrons
        g2.setColor(Color.BLUE);
        g2.fillOval(ex1 - 10, ey1 - 10, 20, 20);
        g2.fillOval(ex2 - 10, ey2 - 10, 20, 20);

        // Texto explicativo
        g2.setColor(Color.BLACK);
        g2.drawString("Átomo de Hélio (2 prótons, 2 elétrons)", 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angulo += 0.05; // Atualiza o ângulo
        repaint();
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Átomo de Hélio");
        AtomoHelio painel = new AtomoHelio();

        frame.add(painel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/
}
