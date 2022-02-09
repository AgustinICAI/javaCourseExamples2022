# Clase Object

https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html

## Object es la superclase de todas las clases Java

Todas las clases Java hacen un extends de forma implícita de la clase Object, aunque nosotros no se lo indiquemos. Por lo tanto, sería equivalente programar la clase Persona así...


```Java
class Persona
{

}
```

...que de esta forma....


```Java
class Persona extends Object
{

}
```

Aunque claramente, nadie utiliza esta segunda forma.

Cuando creamos una instancia de Persona...


```Java
Persona p = new Persona();
```

...la respuesta a la pregunta de instanceof será...


```Java
p instanceof Object;
```




    true




```Java
p instanceof Persona;
```




    true



Como se decía, NO se explicita la herencia y se omite siempre.


```Java
class Persona
{       
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) 
    {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getInfo()
    {
        return "Nombre: " + nombre + "\nEdad: " + edad;
    }
}
```


```Java
Persona p = new Persona("Luis", 22);
p instanceof Object;
```




    true




```Java
p instanceof Persona;
```




    true



Nótese cómo se puede tener información más concreta sobre la clase a la cual pertenece un objeto haciendo reflection o instrospection, aunque todavía no nos aporte mucho... Más tarde entenderemos esta información.


```Java
Class clase = p.getClass();
clase.getName()
```




    REPL.$JShell$12B$Persona



### ¿Qué ventajas me proporciona que Object sea la superclase de todos los objetos Java?

Que nuestras clases hereden de Object significará que heredarán todos los métodos del interfaz de Object.
https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html

Aunque no entendamos el significado de los métodos que posee Object, vemos cómo se pueden invocar desde cualquier objeto.


```Java
p.hashCode()
```




    1874186120




```Java
p.getClass()
```




    class REPL.$JShell$12B$Persona




```Java
p.toString()
```




    REPL.$JShell$12B$Persona@6fb5cf88



### ¿Para que nos sirve esta implementación genérica?

La ventaja es que Object nos proporciona el interfaz genérico que cada objeto deberá redefinir (@Override) para tener su comportamiento específico, por lo que todos los objetos sabrán responder a estos métodos.

## Método _public String toString()_

El método toString() declarado en la clase Object indica la capacidad que tiene cualquier objeto de convertirse a String.

Hasta ahora utilizábamos en método getInfo() para obtener toda la información del objeto en forma de String


```Java
Persona p1 = new Persona("Alejandro", 36);
p1.getInfo();
```




    Nombre: Alejandro
    Edad: 36



Si llamamos al método toString() de la clase Persona, al no estar redefinido, tomará la implementación genérica que hereda de la clase Object. Ojo que en la salida por consola, no se muestra el prefijo *REPL.$JShell$20V$* que se muestra en Jupyter


```Java
p1.toString();
```




    REPL.$JShell$12B$Persona@21cfcfe8



Justo la salida que acabamos de ver es la implementación genérica que tiene Object. Lo único que se puede decir desde ese interfaz tan general a todos los objetos es la siguiente. El método hashCode(), que se verá en temas futuros, representa la conversión a un número entero de un objeto.


```Java
p1.getClass().getName() + '@' + Integer.toHexString(p1.hashCode())
```




    REPL.$JShell$12B$Persona@21cfcfe8



El interfaz de la clase Object mediante el método toString() indica que cualquier objeto de Java tendrá la capacidad de convertirse a String mediante dicho método. Todos los objetos responderán a este método y solo aquellos que lo redefinan, lo harán con sentido. Por este motivo, renombraremos nuestro método de andar por casa getInfo() por el método toString(), para entrar en el club de los objetos Java que sabemos responder con sentido al método toString().


```Java
class Persona
{ 

    String nombre;
    int edad;
    
     Persona(String nombre, int edad) 
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString()
    {
        return "\nNombre: " + nombre + "\n"
        +"Edad: " + edad;
    }
}
```


```Java
Persona p2 = new Persona("Luis", 22);
p2.toString();
```




    
    Nombre: Luis
    Edad: 22



Dado que el método _toString()_ es el encargado de convertir cualquier objeto a una cadena de caracteres, es el utilizado por muchos objetos Java para ser invocado pro defecto. Por ejemplo, en el caso de mostrar información por consola.


```Java
System.out.println(p2.toString())
```

    
    Nombre: Luis
    Edad: 22


Se podría sustituir por:


```Java
System.out.println(p2)
```

    
    Nombre: Luis
    Edad: 22


## Método *public boolean equals(Object o)*

El método equals(Object) declarado en la clase Object permite comparar objetos entre sí según la estrategia que defina cada clase particular en su redefinición.

A partir de este momento se utilizará el *operador ==* para comparar tipos primitivos de datos y el método equals() para comparar objetos.

### Operador ==

Siempre se utilizará el == con los tipos de datos...


```Java
int i1 = 34;
int i2 = 34;
i1==i2
```




    true



...ya que compara el valor de cada variable. 

Cuando comparamos objetos con el operador ==, compara si los objetos apuntan a la misma dirección de memoria, no su contenido.


```Java
Persona p1 = new Persona("Manuel",22);
Persona p2 = new Persona("Manuel",22); 
```

Por este motivo, la siguiente comparación devuelve false.


```Java
p1==p2
```




    false



Si realizamos la siguiente asignación...


```Java
p1 = p2;
```

...p1 y p2 apuntarán al mismo objeto en memoria, por lo que el operador *==* devolverá _true_.


```Java
p1==p2
```




    true



### Redefinición del método equals

Hacemos un override del método equals perteneciente a la clase Object.
Ahora haremos la comparación de objetos con el método equals, con la llamada a: p1.equals(p2);
La comparación se realizará a partir de un atributo del objeto, por ejemplo el NIF, ya que este es único.
En la definición del método equals, llamaremos al método equals de la clase String(), el cual ya está definido y funciona correctamente.


```Java
class Persona
{ 
    private String nif;
    private String nombre;
    private int edad;
    
    public Persona(String nif, String nombre, int edad) 
    {
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getNif()
    {
        return nif;
    }
    
    public int getEdad()
    {
        return edad;
    }    
    
    @Override
    public String toString()
    {
        return "NIF: " + nif + "\nNombre: " + nombre + "\nEdad: " + edad;
    }
    
    @Override
    public boolean equals(Object obj) //Upcasting, el objeto que recibe lo vemos como un Objeto
    {
        if(obj instanceof Persona) //Si la instancia del objeto es una Persona...
        {
            Persona p = (Persona) obj; //Hacemos un downcasting (explícito) y bajamos el inyerfaz
            if (edad == p.getEdad() && nif.equals(p.getNif())) //Llama al equals de String, que funciona correctamente
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
```


```Java
Persona p1 = new Persona("11111","Manuel",22);
Persona p2 = new Persona("11111","Manuel",22);
```


```Java
System.out.println("Con el método equals: " + p1.equals(p2));
```

    Con el método equals: true


## Generalización con el interfaz de Object


```Java
Object objetos[] = new Object[3];
```


```Java
objetos[0] = p1;
objetos[1] = "Hola";
objetos[2] = p2;
```




    NIF: 11111
    Nombre: Manuel
    Edad: 22




```Java
for(Object objeto:objetos)
    System.out.println(objeto.toString()+"\n------");
```

    NIF: 11111
    Nombre: Manuel
    Edad: 22
    ------
    Hola
    ------
    NIF: 11111
    Nombre: Manuel
    Edad: 22
    ------


Hay que recordar que por defecto el compilador irá a buscar el método toString() de cada objeto.


```Java
for(Object objeto:objetos)
    System.out.println(objeto + "\n------");
```

    NIF: 11111
    Nombre: Manuel
    Edad: 22
    ------
    Hola
    ------
    NIF: 11111
    Nombre: Manuel
    Edad: 22
    ------



```Java

```
