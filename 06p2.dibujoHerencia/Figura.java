import java.awt.Color;

public abstract class Figura
{
	int x;
	int y;
	boolean relleno;
	Color color;

	/** 
		Inicializa todos los atributos del objeto 
		@param x Posición x de la ventana en pixels
		@param y Posición x de la ventana en pixels
		@param relleno Lo pinta transparente u opaco
		@param color Color de la figura
		
	*/
	Figura(int x, int y, boolean relleno, Color color)
	{
		this.setX(x);
		this.setY(y);
		this.relleno = relleno;
		this.color = color;
	}

	int getX()
	{
		return x;
	}

	int getY()
	{
		return y;
	}

	void setX(int x)
	{
		if(x>0 && x<800)
			this.x = x;
	}

	void setY(int y)
	{
		if(y>0 && y<600)
			this.y = y;
	}


	void setRelleno(boolean relleno)
	{
		this.relleno = relleno;
	}

	boolean getRelleno()
	{
		return relleno;
	}

	void setColor(Color color)
	{
		this.color = color;
	}

	Color getColor()
	{
		return color;
	}	

	void pintar(java.awt.Graphics g)
	{
		g.setColor(color);
	}
}