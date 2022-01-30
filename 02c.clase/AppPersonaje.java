public class AppPersonaje
{
	public static void main(String args[]) 
	{
		String s = "Hola";
		s.toUpperCase();

		int i = 3;
		int suma = i + 4;

		Personaje personaje1;
		personaje1 = new Personaje(); //Constructor de la clase

		//Más práctico ahora, este formato:
		Personaje personaje2 = new Personaje(); //Constructor de la clase

		personaje1.setVida(0);
		int vida = personaje1.getVida();

		personaje2.getVida();

		//Clase objeto = new Clase();

	}

}