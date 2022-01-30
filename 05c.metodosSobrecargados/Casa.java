public class Casa
{

	public static final int LADRILLO = 0;
	public static final int MADERA = 1;
	public static final int OTROS = 2;

	//atributos
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
		int materialRestado = 0;
		int materialPorPico = 0;
		
		switch(material)
		{
			case LADRILLO:
				materialPorPico = 20;
				break;
			case MADERA:
				materialPorPico = 10;
				break;
			default:
				materialPorPico = 5;
		}
		
		if((cantidadMaterial - materialPorPico) >= 0)
		{
			cantidadMaterial -= materialPorPico;
			materialRestado = materialPorPico;
		}
		else
		{
			cantidadMaterial = 0;
			materialRestado = cantidadMaterial;
		}

		return materialRestado;
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