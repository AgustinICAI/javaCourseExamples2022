import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    Dimension dimension = new Dimension(1200,1000);

    Personaje personaje;

    public MyPanel(Personaje personaje){
        this.setPreferredSize(dimension);
        this.personaje = personaje;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(personaje.getImage(),personaje.getX(),personaje.getY(),null);
        g.drawRect(personaje.getX(),personaje.getY(),personaje.getImage().getWidth(null),personaje.getImage().getHeight(null));
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

}
