public class AppPersonaje
{
	public static void main(String args[]) 
	{

		Personaje.setMundo("Nuevo Mundo");

		Personaje personajes[] = new Personaje[10];

		personajes[0] = new Personaje("The Greft", 9999999, 50); 
		personajes[1] = new Personaje("Ampeter", -101010, 0);

		int vida = personajes[0].getVida();

		//personajes[0].vida = 99999999;
		personajes[0].setVida(99999999);

		Personaje.setMundo("Mundo 2022");

		Arbol arbol1 = new Arbol(100, 20);
		personajes[0].picar(arbol1);

		System.out.println(personajes[0].getInfo());
		System.out.println(personajes[1].getInfo());

		for(int i=0;i<personajes.length;i++)
		{
			if(personajes[i]!=null)
				System.out.println("Personaje #" + (i+1) + ": " + personajes[i].getInfo());
		}
	}
}