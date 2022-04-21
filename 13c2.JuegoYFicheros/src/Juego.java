import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Juego extends JFrame /*implements Runnable*/ {

    public static void main(String[] args) {

        new Juego();

    }
    public static int WIDTH = 960;
    public static int HEIGHT = 560;

    PanelJuego panelJuego;

    public HashSet<Integer> getTeclasPulsadas() {
        return teclasPulsadas;
    }

    HashSet<Integer> teclasPulsadas;
    public Juego(){
        super("Mi juego");
        this.teclasPulsadas = new HashSet<>();
        panelJuego = new PanelJuego(this);
        this.add(panelJuego);

        /*
        Thread threadFichero = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });*/

        Thread threadJuego = new Thread(()-> {
            Collection<Persona> personas = Juego.lecturaFichero();
            panelJuego.cargarPersonas(personas);
        } );
        threadJuego.start();


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclasPulsadas.add(e.getKeyCode());
                System.out.println(e.getKeyCode());
            }
        });
        this.requestFocus();

        //new Thread(this).start();


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panelJuego.setJuegoCorriendo(false);
                dispose();
                System.exit(0);
            }
        });
        this.setSize(Juego.WIDTH,Juego.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static Collection<Persona> lecturaFichero(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Collection<Persona> personas = new ArrayList<>();
        try {
            /*
            File f = new File("Alumnos.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr);
            */

            BufferedReader br = new BufferedReader(new FileReader(new File("Alumnos.csv")));
            /*
            String linea = br.readLine();
            while (linea != null){
                Persona p = Persona.fromCSV(linea);
                personas.add(p);
                linea = br.readLine();
            }*/
            String linea;
            while((linea = br.readLine())!=null){
                personas.add(Persona.fromCSV(linea));
            }


            System.out.println(personas);

            br.close();
        }/*
        catch (FileNotFoundException e){
            e.printStackTrace();
        } */catch (IOException e) {
            e.printStackTrace();
        }
        return personas;
    }

    /*
    @Override
    public void run() {

    }*/
}
