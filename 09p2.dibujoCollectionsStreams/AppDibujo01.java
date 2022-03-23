import java.awt.Color;

public class AppDibujo01
{
	public static void main( String[] args )
	{
		Dibujo dibujo = new Dibujo();
		Cuadrado c1 = new Cuadrado(500, 50, true, Color.RED, 200);		
		dibujo.pintar(c1,"Grupo Rojo");
		dibujo.pintar(new Circulo(100, 20, true, Color.BLUE, 200),"Grupo Azul");
		dibujo.pintar(new Cuadrado(100, 350, false, Color.RED, 200),"Grupo Rojo");
		dibujo.pintar(new Circulo(500, 350, true, Color.GREEN, 200),"Grupo Verde");
		dibujo.pintar(new Circulo(500, 350, true, Color.GREEN, 200),"Grupo Verde");

		dibujo.ocultar("Grupo Rojo");


	}
}