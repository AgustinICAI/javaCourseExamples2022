import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnClearActionListener implements ActionListener {
    private JTextField txtVisor;

    public BtnClearActionListener(JTextField txtVisor) {
        this.txtVisor = txtVisor;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.txtVisor.setText("");
    }
}
