import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;
import javax.swing.Timer;

public class JVentana extends JFrame
{
    JButton jbtnEnviar;
    JButton jbtnBorrar;
    MyCanvas myCanvas;



    public static void main(String argv[])
    {
        new JVentana();
    }
    public JVentana()
    {
        super("Formulario ICAI");

        JPanel pnlCenter = new JPanel();
        this.add(pnlCenter,BorderLayout.CENTER);


        myCanvas = new MyCanvas(this);
        this.add(myCanvas,BorderLayout.CENTER);


        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.myCanvas.requestFocus();//ES NECESARIO PARA QUE COJA LOS EVENTOS DE TECLAS
        this.setVisible(true);
    }



}