public class Personaje
{
	//Atributos
	String usuario;
	int vida;
	int material;

	Personaje(String usuario, int vida, int material)
	{
		this.usuario = usuario;
		this.setVida(vida);
		this.material = material;
	}


	Personaje(String usuario, int material)
	{
		this.usuario = usuario;
		vida = 100;
		this.material = material;
	}	

	//Métodos

	String getUsuario()
	{
		return usuario;
	}

	int getVida()
	{
		return vida;
	}

	int getMaterial()
	{
		return material;
	}

	void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	void setVida(int vida)
	{
		if(vida <= 100 && vida >= 0)
			this.vida = vida;
	}

	void setMaterial(int material)
	{
		this.material = material;
	}

	void modificarVida(int deltaVida)
	{
		if( (vida + deltaVida) < 100)
			vida += deltaVida;
		else
			vida = 100;
	}

	boolean isVivo()
	{
		if(vida > 0)
			return true;
		else
			return false;

		//return (vida > 0);

	}

	String getInfo()
	{
		return "Usuario: " + usuario + 
				"\nVida: " + vida + 
				"\nMaterial: " + material;
	}
}