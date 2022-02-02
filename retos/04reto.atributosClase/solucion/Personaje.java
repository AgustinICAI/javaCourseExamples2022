public class Personaje
{
	//Constante para evitar el hardcodeo
	public final static int VIDA_MAX = 100;
	public final static int VIDA_MIN = 0;
	public final static int MATERIAL_DEFAULT = 0;
	
	//Lógica de los objetos: valores comunes a todos los objetos
	static String MUNDO;

	//Lógica de los objetos: valores específicos de los objetos
	String usuario;
	int vida;
	int material;

	//Constructores
	Personaje(String usuario, int vida, int material)
	{
		this.usuario = usuario;
		this.setVida(vida);
		this.setMaterial(material);
	}

	Personaje(String usuario, int material)
	{
		this(usuario, VIDA_MAX, material);
	}	

	Personaje(int material, String usuario)
	{
		this(usuario, material); 
	}		

	Personaje(String usuario)
	{
		this(usuario, VIDA_MAX, MATERIAL_DEFAULT);
	}	

	static void setMundo(String mundo)
	{
		MUNDO = mundo;
	}


	//Métodos
	String getUsuario()
	{
		return usuario;
	}

	int getMaterial()
	{
		return material;
	}

	int getVida()
	{
		return vida;
	}

	void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	void setVida(int vida)
	{
		if(vida >= VIDA_MIN && vida <= VIDA_MAX)
			this.vida = vida;
		else
			this.vida = VIDA_MAX;
	}

	void setMaterial(int material)
	{
		this.material = material;
	}

	void addmaterial(int masMaterial)
	{
		material += masMaterial;
	}

	void recibirDisparo(int unaVida)
	{
		vida -= unaVida;
	}

	void disparar(Personaje personaje)
	{
		personaje.recibirDisparo(20);	
	}

	boolean isVivo()
	{
		return (vida > VIDA_MIN);
	}


	void addVida(int deltaVida)
	{
		if ((vida + deltaVida) <= VIDA_MAX)
			vida += deltaVida;
		else
			vida = VIDA_MAX;
	}

	void picar(Arbol arbol)
	{
		material += arbol.recibirPico();
	}

	void picar(Casa casa)
	{
		material += casa.recibirPico();
	}	

	String getInfo()
	{
		return "\n\tUsuario: " + usuario + "\n\tVida: " + vida +
			   "\n\tMaterial: " + material + "\n\tMundo: " + MUNDO;
	}


}