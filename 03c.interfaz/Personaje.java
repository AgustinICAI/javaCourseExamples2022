public class Personaje
{
	//Atributos
	String usuario;
	int vida;
	int material;

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

	void setUsuario(String unUsario)
	{
		usuario = unUsario;
	}

	void setVida(int otraVida)
	{
		if(otraVida <= 100)
			vida = otraVida;
	}

	void setMaterial(int otroMaterial)
	{
		material = otroMaterial;
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