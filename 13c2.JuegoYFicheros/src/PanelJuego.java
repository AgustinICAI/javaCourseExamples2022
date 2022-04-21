import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;

public class PanelJuego extends JPanel implements Runnable {
    private Character character;
    private Juego juego;
    private boolean cargando = true;
    public static int FPS = 60;


    Image imagenFondo;
    private Collection<Persona> personas;
    private boolean juegoCorriendo = true;

    public PanelJuego(Juego juego) {
        this.juego = juego;
        try {
            imagenFondo = ImageIO.read(new File("resources/bg_space_seamless_1.png"));
            character = new Character();
        } catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        new Thread(this).start();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagenFondo,0,0,null);
        //FUNCIONALIDAD DE CARGANDO
        if(cargando){
            g.setFont(new Font("Courier",Font.BOLD,30));
            g.setColor(Color.YELLOW);
            g.drawString("CARGANDO...",200,200);
        }else {
            if (personas != null)
                personas.forEach(p -> p.paint(g));
            character.paint(g);

        }



        g.dispose();
        Toolkit.getDefaultToolkit().sync();
    }


    public void cargarPersonas(Collection<Persona> personas) {
        this.personas = personas;
        this.cargando = false;
    }

    public void setJuegoCorriendo(boolean juegoCorriendo) {
        this.juegoCorriendo = juegoCorriendo;
    }

    @Override
    public void run() {

        double refreshInterval = (double)1000000000/FPS;
        double nextRefresh = System.nanoTime() + refreshInterval;
        double countFPS = 0;
        long lastSecond = System.nanoTime()/1000000000;
        while(juegoCorriendo){
            recalcularElementos();
            repaint();
            double remainingTime = nextRefresh - System.nanoTime();
            if(remainingTime < 0)
                remainingTime = 0;
            try {
                Thread.sleep((long) 30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countFPS +=1;
            if(lastSecond!=System.nanoTime()/1000000000){
                System.out.println(Calendar.getInstance().getTime() + "-" + countFPS);
                lastSecond = System.nanoTime()/1000000000;


            }

        }

    }

    private void recalcularElementos() {
        if(personas!=null){
            personas.forEach(p-> p.actualizarPosicion());
        }

        if(juego.getTeclasPulsadas().contains(KeyEvent.VK_UP)){
            character.moveUp();
        }else if(juego.getTeclasPulsadas().contains(KeyEvent.VK_DOWN)){
            character.moveDown();
        }
        System.out.println(juego.getTeclasPulsadas());
        juego.getTeclasPulsadas().clear();


    }
}
