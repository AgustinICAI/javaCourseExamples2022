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
    BufferedImage img = null;

    int posX = 20, posY = 20;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public MyPanel(){
        this.setPreferredSize(dimension);
        try {
            img = ImageIO.read(new File("/home/agus/ICAI/2022/AppVentana/mickey.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,posX,posY,null);
    }



}
