public class Casa
{
	//Atributos de clase de ayuda para asignación de valores
	public final static int LADRILLO = 20; //REFACTORING #3
	public final static int MADERA = 10; //REFACTORING #3
	public final static int OTROS = 5; //REFACTORING #3

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

	//REFACTORING #1
	String getMaterialAsTexto()
	{
		String nombreMaterial = "OTROS";

		switch(material)
		{
			case LADRILLO:
				nombreMaterial = "LADRILLO";
				break;
			case MADERA:
				nombreMaterial = "MADERA";
				break;
		}

		return nombreMaterial;
	}

	//REFACTORING #2
	void setMaterial(int material)
	{
		if(material == LADRILLO || material == MADERA)
			this.material = material;
		else
			this.material = OTROS;
	}	

	int recibirPico()
	{
		int piedraRestada = 0;
		int piedraPorPico = material; //REFACTORING #3
		
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
		return "Cantidad de Material: " + cantidadMaterial + " Material: " + this.getMaterialAsTexto(); //REFACTORING #1
	}
}