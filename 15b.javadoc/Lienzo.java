import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	Cuadrado cuadrados[]=new Cuadrado[10];

	void pintar(Cuadrado c)
	{
		for(int i=0;i<cuadrados.length;i++)
			if(cuadrados[i]==null)
			{
				cuadrados[i] = c;
				i=cuadrados.length;
			}
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.RED);			
		for(int j=0;j<cuadrados.length;j++){
			if(cuadrados[j]!=null)
				if(Cuadrado.isRELLENO())
					g.fillRect(cuadrados[j].getX(), cuadrados[j].getY(), cuadrados[j].getLado(), cuadrados[j].getLado()); 
				else
					g.drawRect(cuadrados[j].getX(), cuadrados[j].getY(), cuadrados[j].getLado(), cuadrados[j].getLado()); 
		}
	}
}
