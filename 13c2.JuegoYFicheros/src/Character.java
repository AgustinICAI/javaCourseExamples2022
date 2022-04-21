import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Character extends Sprite{
    private Image image;

    public Character(){
        try {
            image = ImageIO.read(new File("resources/character.png"));
            x = 30;
            y = Juego.HEIGHT/2;
            velocidad = 50;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void actualizarPosicion() {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,(int)x,(int)y,null);
    }

    public void moveUp() {
        y-= velocidad/10;
    }
    public void moveDown() {
        y+= velocidad/10;
    }
}
