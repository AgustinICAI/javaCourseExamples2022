public class AppPersonaje
{
	public static void main(String args[]) 
	{

		Personaje.setMundo("Mundo 2022");

		//Personaje.VIDA_MAX = 500;   ERROR
		System.out.println(Personaje.VIDA_MAX);

		//Arrays
		Personaje personajes[] = new Personaje[10];
		personajes[0] = new Personaje("The Grefg", 90, 50);
		personajes[1] = new Personaje("Ampeter", 100, 0);

		Arbol arbol1 = new Arbol(100, 20);
		personajes[0].picar(arbol1);
		personajes[1].picar(new Arbol(60, 10));	//En este caso, me gusta más esto.

		Casa casa = new Casa(100, Casa.LADRILLO); //Picará correctamente.
		System.out.println("Info de la casa:\n" + casa.getInfo());
		personajes[0].picar(casa);

		casa.setMaterial(444);
		System.out.println("Info de la casa:\n" + casa.getInfo());

		//personajes[1].picar(new Casa(100, Casa.LADRILO));  //Ahora dará error de compilación ya que no existe ningún atributo de clase llamado así.

		for(int i=0;i<personajes.length;i++)
			if(personajes[i] != null)
				System.out.println("Personaje" + (i+1) + ": " + personajes[i].getInfo());	

/* Estructura for-each:

		for(Personaje personaje:personajes)
			if(personaje != null)
				System.out.println("Personaje: " + personaje.getInfo());	
*/
	}
}