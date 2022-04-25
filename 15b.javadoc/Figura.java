import java.awt.Color;

/** Clase que define el comportamiento genérico de todas las figuras */
public class Figura
{
	/** Coordenada x de la figura */
	private int x;
	/** Coordenada y de la figura */
	private int y;
	private boolean relleno;
	private Color color;

	/** 
		Inicializa todos los atributos del objeto 
		@param x Posición x de la ventana en pixels
		@param y Posición x de la ventana en pixels
		@param relleno Lo pinta transparente u opaco
		@param color Color de la figura
		
	*/
	public Figura(int x, int y, boolean relleno, Color color)
	{
		this.setX(x);
		this.setY(y);
		this.relleno = relleno;
		this.color = color;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void setX(int x)
	{
		if(x>0 && x<800)
			this.x = x;
	}

	public void setY(int y)
	{
		if(y>0 && y<600)
			this.y = y;
	}


	public void setRelleno(boolean relleno)
	{
		this.relleno = relleno;
	}

	public boolean getRelleno()
	{
		return relleno;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}	

	/** Implementación demo de pintar, a falta de implementar la parte gráfica
  @return un string de la figura */
	public String pintar()
	{
		String s = "";
		s += color + " ";
		s += " Relleno: " + relleno;
		s += " (" + x + ", " + y + ")"; 
		return s;
	}
}
