public class Persona
{
    private String nombre;
    private int edad;
    private String direccion;

    public Persona setNombre(String nombre)
    {
        this.nombre = nombre;
        return this;
    }

    public Persona setEdad(int edad)
    {
        this.edad = edad;
        return this;
    }

    public Persona setDireccion(String direccion)
    {
        this.direccion = direccion;
        return this;
    }

    @Override
    public String toString()
    {
        return nombre + " (" + edad + ") en " + direccion;
    }
}