import java.awt.*;

public abstract class Sprite {
    double x;
    double y;
    double velocidad;


    public abstract void actualizarPosicion();
    public abstract void paint(Graphics g);

}
