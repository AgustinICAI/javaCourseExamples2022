import java.awt.Color;

public class Cuadrado extends Figura
{ 
	private int lado;

	/** 
		Inicializa todos los atributos del objeto 
		@param lado Tamaño del cuadrado en pixels
	*/
	public Cuadrado(int x, int y, boolean relleno, Color color, int lado)
	{
		super(x, y, relleno, color);
		this.setLado(lado);
	}

	public void setLado(int lado)
	{
		if(lado>1 && lado<600)
			this.lado = lado;
		else
			this.lado = 2;
	}

	public int getLado()
	{
		return lado;
	}

	@Override
	public void pintar(java.awt.Graphics g)
	{
		if(isVisible()) {
			super.pintar(g);
			if (relleno)
				g.fillRect(x, y, lado, lado);
			else
				g.drawRect(x, y, lado, lado);
		}
	}
}