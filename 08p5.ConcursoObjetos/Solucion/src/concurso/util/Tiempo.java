package concurso.util;

/** Clase de funcionalidad variada que proporciona una ayuda al alumno */
public class Tiempo
{
    /**
     Detiene el programa el tiempo especificado
     @param milliseconds número de segundos a esperar
     */
    public static void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch(Exception e)
        {

        }
    }
}