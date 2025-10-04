package telas;
import java.awt.event.ActionListener;

public class HeliumPanel extends AtomPanel {
    public HeliumPanel(ActionListener back) {
        super(2, 0.04, back); // 2 elétrons, mesmas órbitas em fase espantada
    }
}