# Retos de Programación Orientada a Objetos

 ## Reto 3. Comportamiento de StringBuilder a Persona

**Objetivo**: Recientemente hemos visto como se puede trabajar con StringBuilder de la siguiente forma:
```java
StringBuilder sb = new StringBuilder();
sb.append("A");
sb.append("B");
sb.append("C");
```
Y también hemos visto que permite otras formas equivalente, muy cómodas y muy utilizadas en la actualidad:
```java
StringBuilder sb = new StringBuilder();
sb.append("A")
  .append("B")
  .append("C");
```
Haced los cambios pertinentes a la clase Persona para que permita asignar valores mediante sus setters de la misma forma que puede hacer StringBuilder.

Sería pasar de este formato actual y convencional:

```java
Persona persona = new Persona();
persona.setNombre("Luis");
persona.setEdad(22);
persona.setDireccion("Calle del Pez, 17");
```

Al siguiente:

```java
Persona persona = new Persona();
persona.setNombre("Luis")
       .setEdad(22)
       .setDireccion("Calle del Pez, 17");
```

**Tipo de trabajo**: Colaborativo en grupos de 4 alumnos.

**Duración**: 5 minutos


```Java
public class Persona
{
    private String nombre;
    private int edad;
    private String direccion;

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }    

    @Override
    public String toString()
    {
        return nombre + " (" + edad + ") en " + direccion;
    }
}
```


```Java
Persona persona = new Persona();
persona.setNombre("Luis");
persona.setEdad(22);
persona.setDireccion("Calle del Pez, 17");

System.out.println(persona);
```

    Luis (22) en Calle del Pez, 17



```Java

```
