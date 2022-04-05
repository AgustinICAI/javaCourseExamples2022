import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

public class AppVentana extends JFrame {
    private JTextArea txt;

    public static void main(String argv[]){
        new AppVentana();
    }

    public TreeSet<String> getFechas() {
        return fechas;
    }

    TreeSet<String> fechas = new TreeSet<>();

    public AppVentana(){
        super("Ventana gestionando hilos");

        txt = new JTextArea();
        JScrollPane jsp = new JScrollPane(txt);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jsp);

        txt.setFont(new Font("Sans Serif",Font.PLAIN,30));
        this.setSize(800,800);
        this.setVisible(true);
        for (int i = 0; i < 10000; i++) {
            Thread hilo = new MiHilo(this);
            hilo.start();
        }

        Thread hiloColorin = new MiHiloColorin(this);
        hiloColorin.start();


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppVentana.this.dispose();
            }
        });

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JTextArea getTxt() {
        return txt;
    }
}
