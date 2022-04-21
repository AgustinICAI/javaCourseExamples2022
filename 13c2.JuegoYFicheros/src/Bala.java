import java.awt.*;

public class Bala extends Sprite {

    public Bala(double y){
        x = 105;
        this.y = y + 40;
        velocidad = 80;
    }
    public void actualizarPosicion() {
        x += velocidad/PanelJuego.FPS;
    }

    static int tamxBala = 8;
    static int tamyBala = 4;
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y,tamxBala,tamyBala);
    }
    @Override
    public Rectangle getCollisionArea() {
        return new Rectangle((int)x,(int)y,tamxBala,tamyBala);
    }
}
