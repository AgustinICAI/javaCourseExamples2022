import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class PanelJuego extends JPanel implements Runnable {
    private Personaje character;
    private Juego juego;
    private boolean cargando = true;
    public static int FPS = 60;
    public static int ANCHURA = 960;
    public static int ALTURA = 540;


    Image imagenFondo;
    private ArrayList<Persona> personas;
    private boolean juegoCorriendo = true;
    private boolean ganado=false;
    private boolean perdido=false;

    public PanelJuego(Juego juego) {
        this.juego = juego;
        this.setPreferredSize(new Dimension(ANCHURA,ALTURA));
        try {
            imagenFondo = ImageIO.read(new File("resources/bg_space_seamless_1.png"));
            character = new Personaje();
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
        }else if(ganado){
            g.setFont(new Font("Courier",Font.BOLD,30));
            g.setColor(Color.YELLOW);
            g.drawString("HAS GANADO!!",200,200);
        }else if(perdido){
            g.setFont(new Font("Courier",Font.BOLD,30));
            g.setColor(Color.YELLOW);
            g.drawString("HAS PERDIDO LOOSER!!",200,200);
        }
        else {
            if (personas != null)
                personas.forEach(p -> p.paint(g));
            character.paint(g);
        }

        g.dispose();
        Toolkit.getDefaultToolkit().sync();
    }


    public void cargarPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
        this.cargando = false;
    }

    public void setJuegoCorriendo(boolean juegoCorriendo) {
        this.juegoCorriendo = juegoCorriendo;
    }

    @Override
    public void run() {

        double refreshRate = (double) 1000000000 / FPS;
        double nextPaint = System.nanoTime() + refreshRate;

        int countFpsPainted = 0;
        int secCounter = (int) (System.nanoTime()/1000000000);

        while(juegoCorriendo) {
            recalcularElementos();
            repaint();
            double remainingTime = nextPaint - System.nanoTime();
            if(remainingTime<0)
                remainingTime = 0;

            try {
                Thread.sleep((long) remainingTime/1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            nextPaint += refreshRate;
            countFpsPainted+=1;
            if((int) (System.nanoTime()/1000000000) != secCounter){
                System.out.println("FPS:" + countFpsPainted);
                countFpsPainted = 0;
                secCounter = (int) (System.nanoTime()/1000000000);
            }

        }

    }

    private void recalcularElementos() {
        if(personas!=null){
            personas.forEach(p-> p.actualizarPosicion());
        }
        
        character.actualizarPosicion(juego.getTeclasPulsadas());
        character.checkCollions(personas);

        if(personas!=null && personas.isEmpty())
            ganar();
        else if (personas!= null && personas.get(0).x < 95)
            perder();
    }

    private void ganar() {
        this.juegoCorriendo=false;
        this.ganado = true;
    }
    private void perder() {
        this.juegoCorriendo=false;
        this.perdido = true;
    }
}
