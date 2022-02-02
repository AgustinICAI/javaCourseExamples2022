public class AppPersonaje
{
	public static void main(String args[]) 
	{
		Personaje p1; //Definción del objeto
		p1 = new Personaje(); //Creación del objeto. Llamando al constructor de la clase.

		Personaje p2 = new Personaje(); //Definición y creación del objeto

		p1.setVida(12); //Mensajes que se lanzan sobre el objeto
		p1.disparar(p2);

		/*
		RETO 1
		Inicializa los atributos de los objetos y comprueba el valor de los mismos
		después de hacer variaciones con los métodos de su interfaz 
		*/


		/* 
		Ejemplo de la mismas operaciones, 
		pero con otro tipo de objeto:String 
		*/
		String s;
		s = "Hola";
		String s2 = "Hola";
		s2.toUpperCase();
	}
}