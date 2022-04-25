import java.awt.Color;

public class AppDibujo01
{
	public static void main( String[] args )
	{
		Figura figuras[] = new Figura[10];

		figuras[0] = new Cuadrado(500, 50, true, Color.RED, 200);		
		figuras[1] = new Circulo(100, 20, true, Color.BLUE, 200);
		figuras[2] = new Cuadrado(100, 350, false, Color.PINK, 200);
		figuras[3] = new Circulo(500, 350, true, Color.GREEN, 200);

		for(int i=0; i<figuras.length;i++)
			if(figuras[i]!=null)
				System.out.println(figuras[i].pintar());
	}
}