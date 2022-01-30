public class AppPersonaje
{
	public static void main(String args[]) 
	{
		Personaje personaje1 = new Personaje(); //Constructor de la clase
		Personaje personaje2 = new Personaje(); //Constructor de la clase

		personaje1.setUsuario("The Greft");
		personaje1.setVida(100);
		personaje1.setMaterial(50);

		personaje2.setUsuario("Ampeter");
		personaje2.setVida(90);
		personaje2.setMaterial(0);

		//personaje1.vida = 99999999;
		personaje1.setVida(99999999);

		System.out.println(personaje1.getInfo());

		System.out.println("\tUsuario: " + personaje2.getUsuario());
		System.out.println("\tVida: " + personaje2.getVida());
		System.out.println("\tMaterial: " + personaje2.getMaterial());

		System.out.println("Ejemplo del funcionamiento de las secuencias de escape");
		System.out.println("Mi directorio \"HOME\" es C:\\DAVID \n");


		/*
		if(personaje2.getVida()<=100) 
			personaje2.modificarVida(33);
		*/

		personaje2.modificarVida(33);

/*
		if(personaje2.getVida() <= 0)
			System.out.println("Personaje 2 está muerto");
*/

		//if(personaje2.isVivo() != true)
		if(!personaje2.isVivo())
			System.out.println("Personaje 2 esta muerto");
		else
			System.out.println("Personaje 2 esta vivo");

	}
}