import java.awt.*;

/** Clase de funcionalidad variada que proporciona una ayuda al alumno */
public class Util
{
	/** 
		Detiene el programa el tiempo especificado
		@param segundos número de segundos a esperar 
	*/
	public static void wait(int segundos)
	{
		try
		{
			Thread.sleep(segundos*1000);
		}
		catch(Exception e)
		{

		}
	}

	public static Color rgbToColor(int r, int g, int b) throws RGBConversionException {
		if(r < 0  || r > 256)
			throw new RGBConversionException(RGBConversionException.Color.R,r);
		else if(g < 0  || g > 256)
			throw new RGBConversionException(RGBConversionException.Color.G,g);
		else if(b < 0  || b > 256)
			throw new RGBConversionException(RGBConversionException.Color.B,b);
		else return new Color(r,g,b);
	}
	/*
	public static Color rgbToColor2(int r, int g, int b) throws RGBConversionException {
		try {
			return new Color(r, g, b);
		}catch (IllegalArgumentException e){
			throw new RGBConversionException();
		}
	}*/

}
