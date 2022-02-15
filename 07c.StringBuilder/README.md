# StringBuilder

Clase Persona con ejemplo de concatenación de atributos


```Java
public class Persona
{
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getNombre()
    {
        return nombre;
    }

    @Override
    public String toString()
    {
        //Funcionalidad básica de concatenación no optimizada
        //return nombre + "(" + edad + ")"; 
        
        //Concatenación optimizada mediante StringBuilder
        StringBuilder sb = new StringBuilder();
        
        //Opción 1: 
        sb.append(nombre);
        sb.append("(");
        sb.append(edad);
        sb.append(")");
        
        //Opción 2: 
        //sb.append(nombre).append("(").append(edad).append(")");
        
        //Opción 3 (estético): 
        /* 
        sb.append(nombre)
          .append("(")
          .append(edad)
          .append(")");
        */
        
        //Opción 4 con clase de apoyo que ayude a la concatención: 
        //String stringConcatenado = Util.concat(nombre, "(", String.valueOf(edad), ")");
        
        return sb.toString();
    }
}
```


```Java
Persona p1 = new Persona("Luis", 22);
```

El resultado es el mismo que obteníamos antes, pero de una forma optimizada


```Java
p1.toString()
```




    Luis(22)



### Ejemplo de automatización de la concatenación

A petición de un alumno, se ha creado este ejemplo. Se trata de una clase de apoyo para simplificar la concatenación mediante el uso de argumentos variables: Varargs


```Java
public class Util
{
    public static String concat(String ... args)
    {
        StringBuilder sb = new StringBuilder();
        for(String s:args)
            sb.append(s);
        
        return sb.toString();
    }
}
```


```Java
Util.concat("Luis", " (", String.valueOf(23), ")");
```




    Luis (23)




```Java

```
