import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	Cuadrado cuadrados[];
  static int CUADRADOSLENGTH = 10;
  int ultimoCuadradoInsertado;

  public Lienzo()
  {
    super();
    cuadrados = new Cuadrado[CUADRADOSLENGTH];
    ultimoCuadradoInsertado = 0;
  }
  void setCuadrados(Cuadrado [] cuadrados)
  {
    this.cuadrados = cuadrados;
    CUADRADOSLENGTH = cuadrados.length;
  }

	void addCuadrado(Cuadrado c)
	{
    if(ultimoCuadradoInsertado < cuadrados.length)
    {
      cuadrados[ultimoCuadradoInsertado] = c; 
      ultimoCuadradoInsertado = ultimoCuadradoInsertado + 1;
      this.repaint();
    }
    else
      System.err.println("NO SE PUEDEN INSERTAR MÁS CUADRADOS YA QUE LA CLASE LIENZO ESTÁ PENSADA PARA " + CUADRADOSLENGTH + "CUADRADOS");
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
