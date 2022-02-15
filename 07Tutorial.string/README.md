# 03. Clase String

https://docs.oracle.com/javase/9/docs/api/java/lang/String.html

La clase String representa cadenas de caracteres. Todas las combinaciones de palabras y caracteres, como “Hola, soy Álex”, o simplemente, “abc”, se implementan con instancias de esta clase.

Los Strings son inmutables, es decir, sus valores no se pueden modificar una vez se crean. Sin embargo, existen otras clases como StringBuffer o StringBuilder que, como veremos más adelante, que sí lo son.

La clase String incluye métodos para examinar caracteres individuales de la cadena, para comparar strings, buscar strings, extraer partes de un string para crear substrings, y para crear una copia exacta de un string poniendo todos sus caracteres como mayúsculas o minúsculas.

Java ofrece una ayuda especial para la concatenación, unión, de strings con el operador (+), que también sirve para la conversión de objetos a strings. 

Es importante destacar que un objeto String creado a partir de un argumento nulo en el constructor provocará un error NullPointerException.


### Definición de objetos String


```Java
String s1 = "Madrid";
String s2 = "Barcelona";
String s3 = "Valencia";
```

### Operaciones básicas


```Java
String concatenacion = s1 + ", " + s2 + ", " + s3;
```


```Java
concatenacion
```




    Madrid, Barcelona, Valencia



### Métodos básicos


```Java
s1
```




    Madrid




```Java
String nuevoString = s3.concat(" Club de Fútbol");
nuevoString
```




    Valencia Club de Fútbol



Devuelve la longitud de la cadena


```Java
s1.length();
```




    6



Devuelve el caracter de la posición indicada (0 a n)


```Java
s1.charAt(4); 
```




    i



Formateo mediante el método de clase


```Java
String.format("%s tiene %d años", "Luis", 22)
```




    Luis tiene 22 años




```Java

```


```Java
String cadena = "Hola esto es un ejemplo";
for(String s:cadena.split(" ")) 
    System.out.println(s);
```

    Hola
    esto
    es
    un
    ejemplo


#### indent(int)


```Java
String cadena = "Hola esto es un ejemplo";
cadena;
```




    Hola esto es un ejemplo




```Java
cadena.indent(2);
```




      Hola esto es un ejemplo





```Java
String cadena = "Hola\nesto\nes\nun\nejemplo";
cadena;
```




    Hola
    esto
    es
    un
    ejemplo




```Java
cadena.indent(2);
```




      Hola
      esto
      es
      un
      ejemplo




#### replace() vs replaceAll()


```Java
String cadena = "Hola esto es 1 ejemplo";
cadena.replace("o", "O")
```




    HOla estO es 1 ejemplO




```Java
cadena.replaceAll("\\s", "_")
```




    Hola_esto_es_1_ejemplo




```Java
cadena.replaceAll("\\d", "_")
```




    Hola esto es _ ejemplo




```Java
cadena.replaceAll("[0-9]", "_")
```




    Hola esto es _ ejemplo



#### Reto
---
Elimina los espacios en blanco de la palabra palabra " hola ", extrae los 3 primeros caracteres, conviértelos a mayúsculas y quédate con el segundo caracter: '


```Java

```
