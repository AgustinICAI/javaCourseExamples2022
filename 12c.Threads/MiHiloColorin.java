import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

public class MiHiloColorin extends Thread{

    private AppVentana ventana;

    public MiHiloColorin(AppVentana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void run(){
        while (ventana.isDisplayable()) {
            Random r = new Random();
            ventana.getTxt().setBackground(new Color(r.nextInt(255),
                    r.nextInt(255),r.nextInt(255)));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
