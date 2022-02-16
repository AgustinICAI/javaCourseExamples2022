public class App
{
	static String nombre = "Luis";
	static String apellidos = "Lopez";
	static int edad = 22;

	public static void main(String[] args) 
	{
		long inicioNano = System.nanoTime();
		
		System.out.println(App.concatenarOperadorMas());
		System.out.println(App.concatenarStringBuilder());
		System.out.println(App.concatenarStringFormat());

		long finNano = System.nanoTime();   
		long nanoTiempo = finNano - inicioNano;	

		System.out.printf("Tiempo de ejecucion de las tres concatenaciones: %.2f msec.", (float) (nanoTiempo/(10^6.)));
	}

	static String concatenarOperadorMas()
	{
		String s = "Nombre ";
		s += nombre;
		s += " Apellidos ";
		s += apellidos;
		s += " Edad ";
		s += edad;
		return s;
	}

	static String concatenarStringBuilder()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre ");
		sb.append(nombre);
		sb.append(" Apellidos ");
		sb.append(apellidos);
		sb.append(" Edad ");
		sb.append(edad);
		return sb.toString();
	}	

	static String concatenarStringFormat()
	{
		String s = String.format("Nombre %s Apellidos %s Edad %d", nombre, apellidos, edad);
		return s;
	}		
}
