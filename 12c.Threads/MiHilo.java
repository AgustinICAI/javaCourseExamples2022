import javax.swing.*;
import java.util.Calendar;

public class MiHilo extends Thread{

    private int idHilo;
    private AppVentana ventana;

    public MiHilo(AppVentana ventana, int idHilo) {
        this.ventana = ventana;
        this.idHilo = idHilo;
    }

    @Override
    public void run(){
        //int inicio = (int) (System.nanoTime()/1000000000);
        for(int i = 0 ; i<100; i++) {
            //long tiempoEntreMedias = System.nanoTime() / 1000000000 - inicio;


            //CALENDAR.GETINSTANCE es Thread Safe
            //https://www.daniweb.com/programming/software-development/threads/280289/is-calender-getinstance-method-is-thread-safe#post1206617

            //ventana.getFechas().add(Calendar.getInstance().getTime().toString() + "\n");
            ventana.append("Hilo " + idHilo + " mostrando " + i + "\n");
            //System.out.println(Calendar.getInstance().getTime().toString());

            /*try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }

}
