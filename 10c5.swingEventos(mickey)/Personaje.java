import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Personaje {
    private AppVentana appVentana;
    int x;
    int y;
    Image image;

    public Personaje( AppVentana appVentana, int x,int y){
        this.appVentana = appVentana;
        try {
            this.image = ImageIO.read(new File("mickey.png"));
        }catch (IOException e){
            System.err.println("No hay imagen de personaje");
            System.exit(-80);
        }
        this.x = x;
        this.y = y;
    }
    public Rectangle getImageRectangle(){
        return new Rectangle(x,y,this.image.getWidth(null),this.image.getHeight(null));
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void desplaza(int x0, int y0) {
        this.setX(x+x0);
        this.setY(y+y0);
    }

    private void setX(int x) {
        if(x > this.appVentana.getPanel().getSize().getWidth() - image.getWidth(null))
            this.x = this.appVentana.getPanel().getSize().width - image.getWidth(null);
        else if(x < 0)
            this.x = 0;
        else
            this.x = x;
    }
    private void setY(int y) {
        if(y > this.appVentana.getPanel().getSize().height - image.getHeight(null))
            this.y = this.appVentana.getPanel().getSize().height - image.getHeight(null);
        else if(y < 0)
            this.y = 0;
        else
            this.y = y;
    }
    public void caer() {
        this.desplaza(0,5);
    }
}
