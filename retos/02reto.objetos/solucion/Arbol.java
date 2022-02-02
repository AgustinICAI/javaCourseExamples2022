public class Arbol
{
	//atributos
	int maderaTotal;
	int maderaPorPico;

	//métodos
	int getMaderaTotal()
	{
		return maderaTotal;
	}

	void setMaderaTotal(int unaMadera)
	{
		maderaTotal = unaMadera;
	}

	int getMaderaPorPico()
	{
		return maderaPorPico;
	}

	void setMaderaPorPico(int unaMadera)
	{
		maderaPorPico = unaMadera;
	}	

	int recibirPico()
	{
		int maderaRestada = 0;
		
		if((maderaTotal - maderaPorPico) >= 0)
		{
			maderaTotal -= maderaPorPico;
			maderaRestada = maderaPorPico;
		}
		else
		{
			maderaTotal = 0;
			maderaRestada = maderaTotal;
		}

		return maderaRestada;
	}

	boolean isVivo()
	{
		if(maderaTotal>0)
			return true;
		else
			return false;

		//return (madera>0);
	}

	String getInfo()
	{
		return "Madera: " + maderaTotal + " Madera restada por pico: " + maderaPorPico;
	}
}