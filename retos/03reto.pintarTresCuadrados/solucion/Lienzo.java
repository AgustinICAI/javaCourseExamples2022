import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	private Cuadrado cuadrado1;
	private Cuadrado cuadrado2;
	private Cuadrado cuadrado3;

	public void pintar(Cuadrado cuadrado1, Cuadrado cuadrado2, Cuadrado cuadrado3)
	{
		this.cuadrado1 = cuadrado1;
		this.cuadrado2 = cuadrado2;
		this.cuadrado3 = cuadrado3;
	}

	public void paint(Graphics g)
	{
		if(cuadrado1!=null && cuadrado2!=null && cuadrado3!=null)
		{
			g.setColor(Color.RED);
			g.drawRect(cuadrado1.getX(), cuadrado1.getY(), cuadrado1.getLado(), cuadrado1.getLado()); 
			g.drawRect(cuadrado2.getX(), cuadrado2.getY(), cuadrado2.getLado(), cuadrado2.getLado()); 
			g.drawRect(cuadrado3.getX(), cuadrado3.getY(), cuadrado3.getLado(), cuadrado3.getLado()); 
		}
	}
}