public class AppPersonaje
{
	public static void main(String args[]) 
	{

		//Personaje.VIDA_MAX = 200; //ERRROR
		System.out.println("Vida MAX: " + Personaje.VIDA_MAX);

		Personaje.setMundo("Nuevo Mundo");

		Personaje personajes[] = new Personaje[10];

		personajes[0] = new Personaje("The Greft", 100, 50); 
		personajes[1] = new Personaje("Ampeter", 90, 0);

		Personaje p = personajes[0];
		p.getVida();


		Arbol arbol1 = new Arbol(100, 20);
		personajes[0].picar(arbol1);

		//Casa casa1 = new Casa(100, "LADRILO");
		Casa casa1 = new Casa(100, Casa.LADRILLO);
		Casa casa2 = new Casa(100, 999999);
		personajes[0].picar(casa1);

		for(int i=0;i<personajes.length;i++)
			if(personajes[i] != null)
				System.out.println("Personaje #" + (i+1) + ": " + personajes[i].getInfo());


		System.out.println(casa1.getInfo());
		System.out.println(casa2.getInfo());

/*
		int index = 0;
		//index += 1;
		//index++;
		for(Personaje personaje:personajes)
			if(personaje != null)
				System.out.println("Personaje #" + (++index) + ": " + personaje.getInfo());
*/
	}
}