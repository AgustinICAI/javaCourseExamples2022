import javax.swing.*;
import java.util.Calendar;

public class MiHilo extends Thread{

    private AppVentana ventana;

    public MiHilo(AppVentana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void run(){
        while (ventana.isDisplayable()) {
            ventana.getFechas().add(Calendar.getInstance().getTime().toString() + "\n");
            System.out.println(Calendar.getInstance().getTime().toString());

            /*try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

}
