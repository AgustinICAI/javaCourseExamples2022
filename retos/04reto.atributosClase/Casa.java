public class Casa
{
	//Atributos de clase de ayuda para asignación de valores
	public final static int LADRILLO = 0;
	public final static int MADERA = 1;
	public final static int OTROS = 2;

	//Atributos
	int cantidadMaterial;
	int material;

	Casa(int cantidadMaterial, int material)
	{
		this.cantidadMaterial = cantidadMaterial;
		this.material = material;
	}

	//métodos
	int getCantidadMaterial()
	{
		return cantidadMaterial;
	}

	void setCantidadMaterial(int cantidadMaterial)
	{
		this.cantidadMaterial = cantidadMaterial;
	}

	int getMaterial()
	{
		return material;
	}

	void setMaterial(int material)
	{
		this.material = material;
	}	

	int recibirPico()
	{
		int piedraRestada = 0;
		int piedraPorPico = 0;
		
		switch(material)
		{
			case LADRILLO:
				piedraPorPico = 20;
				break;
			case MADERA:
				piedraPorPico = 10;
				break;
			case OTROS:
			default:
				piedraPorPico = 5;
		}
		
		if((cantidadMaterial - piedraPorPico) >= 0)
		{
			cantidadMaterial -= piedraPorPico;
			piedraRestada = piedraPorPico;
		}
		else
		{
			cantidadMaterial = 0;
			piedraRestada = cantidadMaterial;
		}

		return piedraRestada;
	}

	boolean isVivo()
	{
		return (cantidadMaterial > 0);
	}

	String getInfo()
	{
		return "Cantidad de Material: " + cantidadMaterial + " Material: " + material;
	}
}