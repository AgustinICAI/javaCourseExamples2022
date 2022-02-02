public class AppFornite
{
	public static void main(String args[]) 
	{
		Personaje p1 = new Personaje();
		Personaje p2 = new Personaje();

		p1.setVida(100);
		p1.setMadera(50);

		p2.setVida(100);
		p2.setMadera(20);

		p1.disparar(p2);

		if(p2.isVivo())			
			System.out.println("P2 esta vivo");

		System.out.println("Personaje 1: " + p1.getInfo());
		System.out.println("Personaje 2: " + p2.getInfo());


		Arbol arbol1 = new Arbol();
		Arbol arbol2 = new Arbol();

		arbol1.setMaderaTotal(50);
		arbol1.setMaderaPorPico(10);
		arbol2.setMaderaTotal(50);
		arbol2.setMaderaPorPico(7);

		System.out.println("Arbol 1: " + arbol1.getInfo());
		System.out.println("Arbol 2: " + arbol2.getInfo());

		p1.picar(arbol1);

		System.out.println("Personaje 1: " + p1.getInfo());
		System.out.println("Arbol 1: " + arbol1.getInfo());
	}
}