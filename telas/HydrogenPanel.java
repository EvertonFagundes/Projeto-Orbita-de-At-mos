package telas;

import java.awt.event.ActionListener;

public class HydrogenPanel extends AtomPanel {
    public HydrogenPanel(ActionListener back) {
        super(1, 0.06, back); // 1 elétron, velocidade 0.06
    }
}