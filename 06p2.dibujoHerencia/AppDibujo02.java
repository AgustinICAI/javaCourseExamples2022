public class AppDibujo02
{
	public static void main( String[] args )
	{
		Dibujo dibujo = new Dibujo();

		for(int i=0;i<10;i++)
		{
			dibujo.pintar(new Triangulo(i*30, i*30, false, java.awt.Color.BLUE, 200));
			Util.wait(1);
		}
	}
}