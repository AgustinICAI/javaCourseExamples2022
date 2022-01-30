public class Personaje
{
	//Atributo de CLASE
	public static final int VIDA_MAX = 100;
	public static final int VIDA_MIN = 0;

	static String MUNDO;

	//Atributos de INSTANCIA/OBJETO
	String usuario;
	int vida;
	int material;

	Personaje(String usuario, int vida, int material)
	{
		this.usuario = usuario;
		this.setVida(vida);
		this.material = material;
	}

	Personaje(String usuario, int vida)
	{
		this(usuario, vida, VIDA_MIN);
	}

	Personaje(int material, String usuario)
	{
		this(usuario, material);
	}

	Personaje(String usuario)
	{
		this(usuario, VIDA_MAX);
	}	

	static void setMundo(String mundo)	
	{
		MUNDO = mundo;
	}

	static String getMundo()	
	{
		return MUNDO;
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
		if(vida <= VIDA_MAX && vida >= VIDA_MIN)
			this.vida = vida;
	}

	void setMaterial(int material)
	{
		this.material = material;
	}

	void modificarVida(int deltaVida)
	{
		if( (vida + deltaVida) < VIDA_MAX)
			vida += deltaVida;
		else
			vida = VIDA_MAX;
	}

	boolean isVivo()
	{
		return (vida > VIDA_MIN);
	}

	//Métodos sobrecargados
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
		return "Usuario: " + usuario + 
				"\nVida: " + vida + 
				"\nMaterial: " + material +
				"\nMundo: " + MUNDO;
	}
}