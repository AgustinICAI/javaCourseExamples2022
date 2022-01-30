public class Personaje
{
	//Atributos
	int vida;
	int material;

	//Métodos

	int getVida()
	{
		return vida;
	}

	int getMaterial()
	{
		return material;
	}

	void setVida(int otraVida)
	{
		vida = otraVida;
	}

	void setMaterial(int otroMaterial)
	{
		material = otroMaterial;
	}

	void modificarVida(int deltaVida)
	{
		vida += deltaVida;
		//vida = vida + deltaVida;
	}
}