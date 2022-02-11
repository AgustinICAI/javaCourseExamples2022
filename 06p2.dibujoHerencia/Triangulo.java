import java.awt.*;

public class Triangulo extends Figura
{
	int lado;
	/**
		Inicializa todos los atributos del objeto
		@param lado Tamaño del cuadrado en pixels
	*/
	Triangulo(int x, int y, boolean relleno, Color color, int lado)
	{
		super(x, y, relleno, color);
		this.setLado(lado);
	}

	void setLado(int lado)
	{
		if(lado>1 && lado<600)
			this.lado = lado;
		else
			this.lado = 2;
	}

	int getLado()
	{
		return lado;
	}

	@Override
	void pintar(java.awt.Graphics g)
	{
		super.pintar(g);
		int xPoly[] = {x, x + lado, x };

		int yPoly[] = {y, y, y + lado };
		Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);

		if(relleno)
			g.fillPolygon(poly);
		else
			g.drawPolygon(poly);
	}
}