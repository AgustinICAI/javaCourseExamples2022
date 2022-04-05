import java.awt.*;
import javax.swing.*;

public class MiJuego extends JFrame
{

	public static final String TITULO = "JSupergigante v0.9";

  	public static void main (String[] args) 
  	{
  		new MiJuego();
	}
	
	public MiJuego()
	{

		this.setTitle(TITULO);
	    this.setLayout(new FlowLayout());
	
	    Image img1 = Toolkit.getDefaultToolkit().getImage("resources/fondo.jpg");
	    Image img2 = Toolkit.getDefaultToolkit().getImage("resources/personaje.gif");
	    Image img3 = Toolkit.getDefaultToolkit().getImage("resources/personajeKO.gif");
	
	    // Carga de las imagenes
	    MediaTracker mt = new MediaTracker(this);
	    mt.addImage(img1, 1);
	    mt.addImage(img2, 2);
	    mt.addImage(img3, 3);
	    
	    try 
	    {
	    	mt.waitForAll();
	    } 
	    catch (InterruptedException ie) 
	    {
			System.out.println("Error cargando imagenes");
			System.exit(0);
	    }

    	CanvasJuego cnvJuego = new CanvasJuego (img1, img2, img3);
	    this.add(cnvJuego);
		cnvJuego.requestFocus();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	this.pack();
	   	this.setResizable(false);
	    this.setVisible(true);
	}
}
