public class AppPersonaje
{
	public static void main(String args[]) 
	{
		Personaje p1; //Definción del objeto
		p1 = new Personaje(); //Creación del objeto. Llamando al constructor de la clase.

		Personaje p2 = new Personaje(); //Definición y creación del objeto

		p1.setVida(100);
		p1.setMadera(50);

		p2.setVida(100);
		p2.setMadera(10);

		System.out.println("Vida P1:" + p1.getVida());
		System.out.println("Madera P1:" +p1.getMadera());

		System.out.println("Vida P2:" + p2.getVida());
		System.out.println("Madera P2:" + p2.getMadera());

		p1.disparar(p2);

		System.out.println("\n\nVida P2:" + p2.getVida());

		if(p1.getVida() > p2.getVida())
			System.out.println("P1 tiene mas vida que P2");


	}
}