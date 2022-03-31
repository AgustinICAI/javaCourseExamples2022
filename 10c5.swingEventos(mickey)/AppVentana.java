import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppVentana extends JFrame {

    public static void main(String[] args) {
	    new AppVentana();
    }
    MyPanel panel;

    public MyPanel getPanel() {
        return panel;
    }

    public AppVentana(){
        Personaje personaje = new Personaje(this,400,600);
        panel = new MyPanel(personaje);
        this.add(panel/*, BorderLayout.CENTER*/);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
                    personaje.desplaza(0,100);
                }else if (keyEvent.getKeyCode() == keyEvent.VK_UP){
                    personaje.desplaza(0,-100);
                }else if (keyEvent.getKeyCode() == keyEvent.VK_LEFT){
                    personaje.desplaza(-10,0);
                }else if (keyEvent.getKeyCode() == keyEvent.VK_RIGHT){
                    personaje.desplaza(10,0);
                }

                panel.repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /*if(personaje.getX() < e.getX() &&
                   personaje.getX()+personaje.getImage().getWidth(null) > e.getX() &&
                        personaje.getY() < e.getY() &&
                        personaje.getY()+personaje.getImage().getHeight(null) > e.getY()) {
                    personaje.desplaza(0, -20);
                    panel.repaint();
                }*/
                if(personaje.getImageRectangle().contains(e.getPoint())){
                    personaje.desplaza(0, -20);
                    panel.repaint();
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                /*int dialogResult = JOptionPane.showConfirmDialog(AppVentana.this, "Would You Like to Save your Previous Note First?");
                if(dialogResult == JOptionPane.YES_OPTION){
                    AppVentana.this.dispose();
                    System.exit(0);
                }*/
            }
        });

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                personaje.caer();
                panel.repaint();
            }
        });
        timer.start();

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
