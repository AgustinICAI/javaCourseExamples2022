/*
 * David Contreras Bárcena 
 *    DSI - Comillas
 *    davidcb@upcomillas.es
 * 
 */

import java.io.*;

public class Leer
{
		/** Devuelve un String de lo introducido por teclado */
		public static String porTeclado()
		{
			String s="";
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			try 
			{
				s = b.readLine();
					
			}
			catch(IOException e) 
			{
				e.printStackTrace();
			}
			return s;
		}
} 
