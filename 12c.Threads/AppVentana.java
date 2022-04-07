import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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
        ArrayList<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            hilos.add(new MiHilo(this,i));
        }
        hilos.forEach(h -> h.start());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(AppVentana.this.isDisplayable()){
                    try {
                        Random r = new Random();
                        txt.setBackground(new Color(r.nextInt(255),
                                r.nextInt(255),r.nextInt(255)));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        /*
        new Thread( () -> {
            while(AppVentana.this.isDisplayable()){
                    try {
                        Random r = new Random();
                        txt.setBackground(new Color(r.nextInt(255),
                                r.nextInt(255),r.nextInt(255)));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();
         */

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }
        });

        new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("HOla");
            }
        });
        new Timer(300, actionEvent -> System.out.println("Adios") );

        JButton btn = new JButton();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        btn.addActionListener(actionEvent -> System.out.println("He pulsado el botón"));

        HashMap<String,String> hm = new HashMap<>();

        for (Map.Entry<String,String> m : hm.entrySet() ){
            System.out.println(m.getKey() + "-" + m.getValue());
        }


        hm.forEach( (k,v) -> System.out.println(k + "-" + v) );


        //Thread hiloColorin = new MiHiloColorin(this);
        //hiloColorin.start();


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppVentana.this.dispose();
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JTextArea getTxt() {
        return txt;
    }

    synchronized public void append(String cad){
        this.txt.append(cad);
    }


}
