public class Personaje
{
	//atributos
	int vida;
	int madera;

	//métodos
	int getMadera()
	{
		return madera;
	}

	int getVida()
	{
		return vida;
	}

	void setVida(int unaVida)
	{
		vida = unaVida;
	}

	void setMadera(int unaMadera)
	{
		madera = unaMadera;
	}

	void addMadera(int masMadera)
	{
		madera += masMadera;
		//madera = madera + masMadera;
	}

	void recibirDisparo(int unaVida)
	{
		vida -= unaVida;
	}

	void disparar(Personaje unPersonaje)
	{
		unPersonaje.recibirDisparo(20);	
	}
}