# Reto 4. Atributos de clase para la variabilidad de valores de los atributos

En el código que se suministra se trabajan con atributos de clase para recoger esta variabilidad, pero hay cosas que no me terminan de gustar.

### Refactorización de código 1º:
Ante el siguiente código:

```java
Casa casa = new Casa(100, Casa.LADRILLO); //Picará correctamente.
System.out.println("Info de la casa:\n" + casa.getInfo());
```

La salida es:
```
Info de la casa:
Cantidad de Material: 80 Material: 0
```

Mostrará como material 0, en lugar del material "LADRILLO". Muestra el valor traducido.

### Refactorización de código 2º:
Ante el siguiente código:

```java
casa.setMaterial(444);
System.out.println("Info de la casa:\n" + casa.getInfo());
```

La salida es:
```
Info de la casa:
Cantidad de Material: 80 Material: 444
```

El programador podrá saltarse el uso del los atributos y tener valores extraños. Filtra los posibles valores.

### Refactorización de código 3º:
¿Cómo optimizarías la implementación de picar() de Casa?

Pista: aprovechando que el valor que guarda el material es entero...
```java
	public final static int LADRILLO = 0;
	public final static int MADERA = 1;
	public final static int OTROS = 2;
```
