import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Personaje extends Sprite{
    private Image image;
    private ArrayList<Bala> balas;

    public Personaje(){
        try {
            image = ImageIO.read(new File("resources/character.png"));
            x = 30;
            y = Juego.HEIGHT/2;
            velocidad = 100;
            balas = new ArrayList<>();
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
        balas.forEach(b -> b.paint(g));
    }

    @Override
    public Rectangle getCollisionArea() {
        return new Rectangle((int) x, (int) y, image.getWidth(null), image.getHeight(null));
    }

    public void moveUp() {
        y-= velocidad/PanelJuego.FPS;
        if (y < 0)
            y = 0;

    }
    public void moveDown() {
        y+= velocidad/PanelJuego.FPS;
        //Controlo que no se salga el personaje
        if (y > PanelJuego.ALTURA - image.getHeight(null))
            y = PanelJuego.ALTURA - image.getHeight(null);
    }

    long lastShot = 0;
    static int minMillisTimeShots = 300;

    public void shut() {
        if(System.nanoTime() - lastShot > minMillisTimeShots*1000000) {
            balas.add(new Bala(y));
            lastShot = System.nanoTime();
        }
    }

    public void actualizarPosicion(HashSet<Integer> teclasPulsadas) {
        if(teclasPulsadas.contains(KeyEvent.VK_UP))
            this.moveUp();
        if(teclasPulsadas.contains(KeyEvent.VK_DOWN))
            this.moveDown();
        if(teclasPulsadas.contains(KeyEvent.VK_SPACE))
            this.shut();

        balas.forEach(b -> b.actualizarPosicion());
    }

    public void checkCollions(Collection<Persona> personas) {
        if(personas!=null) {

            HashMap<Bala,ArrayList<Persona>> impactos = new HashMap<>();
            balas.forEach(b -> {
                personas.forEach(p->{
                    if (p.getCollisionArea().intersects(b.getCollisionArea())){
                        if(!impactos.containsKey(b))
                            impactos.put(b,new ArrayList<Persona>());
                        impactos.get(b).add(p);
                    }
                });
            });
            //Si una bala da a varias personas sólo borro la primera
            impactos.forEach((b,a)-> {
                balas.remove(b);
                personas.remove(a.get(0));
            });

        }
    }
}
