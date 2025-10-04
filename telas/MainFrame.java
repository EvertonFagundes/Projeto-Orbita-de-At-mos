package telas;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public static final String CARD_MENU = "menu";
    public static final String CARD_H = "hydrogen";
    public static final String CARD_HE = "helium";

    private CardLayout cardLayout = new CardLayout();
    private JPanel cards = new JPanel(cardLayout);
    private HydrogenPanel hydrogenPanel;
    private HeliumPanel heliumPanel;

    public MainFrame() {
        setTitle("Simulador de Átomos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        MenuPanel menu = new MenuPanel();
        menu.addHydrogenListener(e -> showCard(CARD_H));
        menu.addHeliumListener(e -> showCard(CARD_HE));
        cards.add(menu, CARD_MENU);

        // 2) Painéis dos átomos
        hydrogenPanel = new HydrogenPanel(e -> showCard(CARD_MENU));
        heliumPanel   = new HeliumPanel(e -> showCard(CARD_MENU));
        cards.add(hydrogenPanel, CARD_H);
        cards.add(heliumPanel, CARD_HE);

        add(cards);
        showCard(CARD_MENU);
    }

    public void showCard(String name) {
        cardLayout.show(cards, name);
        // controlar animações
        if (CARD_H.equals(name)) {
            hydrogenPanel.startAnimation();
            heliumPanel.stopAnimation();
        } else if (CARD_HE.equals(name)) {
            heliumPanel.startAnimation();
            hydrogenPanel.stopAnimation();
        } else { // menu
            hydrogenPanel.stopAnimation();
            heliumPanel.stopAnimation();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
