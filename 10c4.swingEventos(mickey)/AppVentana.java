import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppVentana extends JFrame {

    public static void main(String[] args) {
	    new AppVentana();
    }

    public AppVentana(){
        MyPanel panel = new MyPanel();
        this.add(panel/*, BorderLayout.CENTER*/);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
                    panel.setPosY(panel.getPosY()+10);
                }else if (keyEvent.getKeyCode() == keyEvent.VK_UP){
                    panel.setPosY(panel.getPosY()-10);
                }else if (keyEvent.getKeyCode() == keyEvent.VK_LEFT){
                    panel.setPosX(panel.getPosX()-10);
                }else if (keyEvent.getKeyCode() == keyEvent.VK_RIGHT){
                    panel.setPosX(panel.getPosX()+10);
                }

                panel.repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                panel.setPosY(panel.getPosY()-20);
                panel.repaint();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int dialogResult = JOptionPane.showConfirmDialog(AppVentana.this, "Would You Like to Save your Previous Note First?");
                if(dialogResult == JOptionPane.YES_OPTION){
                    AppVentana.this.dispose();
                    System.exit(0);
                }
            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel.setPosY(panel.getPosY()+5);
                panel.repaint();
            }
        });
        timer.start();

        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

}
