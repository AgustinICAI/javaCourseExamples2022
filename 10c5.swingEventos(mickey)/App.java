import javax.swing.*;
import java.awt.*;

public class App extends JFrame{
    public static void main(String[] argv){
        new App();
    }
    public App(){
        super();
        JTextField txtNum = new JTextField(10);
        this.add(txtNum);
        JButton btn = new JButton("submit");
        btn.addActionListener(e->{
            try {
                System.out.println(Integer.parseInt(txtNum.getText()) + 10);
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(App.this,"Numero incorrecto, vuelva a meter un numero");
                txtNum.setText("");
            }
        });

        this.add(btn, BorderLayout.EAST);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
