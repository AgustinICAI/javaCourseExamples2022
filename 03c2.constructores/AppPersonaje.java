public class AppPersonaje
{
	public static void main(String args[]) 
	{
		Personaje personaje1 = new Personaje("The Greft", 9999999, 50); 
		Personaje personaje2 = new Personaje("Ampeter", -101010, 0); 

		int vida = personaje1.getVida();

		//personaje1.vida = 99999999;
		personaje1.setVida(99999999);

		System.out.println(personaje1.getInfo());

		System.out.println("\tUsuario: " + personaje2.getUsuario());
		System.out.println("\tVida: " + personaje2.getVida());
		System.out.println("\tMaterial: " + personaje2.getMaterial());

		System.out.println("Ejemplo del funcionamiento de las secuencias de escape");
		System.out.println("Mi directorio \"HOME\" es C:\\DAVID \n");

		personaje2.modificarVida(33);

		if(personaje2.isVivo())
			System.out.println("Personaje 2 esta vivo");
		else
			System.out.println("Personaje 2 esta muerto");

	}
}