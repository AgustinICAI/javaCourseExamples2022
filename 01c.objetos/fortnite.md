# Ejemplo de definición de objetos y lanzamiento de mensajes

### Objetos del tipo Arbol
#### atributos
```java
madera
calidad
```
#### métodos
```java
getMadera()
{
  	return madera;
}

getCalidad()
{
	return calidad;  
}
```

### Definición Objetos del tipo Personaje
#### atributos
```java
vida
armas
madera
```
#### métodos

```java
getVida()
{
	return vida;  
}

getArmas()
{
	return armas;  
}

getMadera()
{
	return madera;  
}

setVida(nuevaVida)
{
  if(nuevaVida <= 100)
  {
  	vida = nuevaVida;
  }
}

setArmas(nuevasArmas)
{
  armas = nuevasArmas;
}

restaVida(decremento)
{
  vida = vida - decremento;
  //vida -= decremento;
}

modificaVida(valor)
{
      vida = vida + valor;
      //vida += valor;
}

picar(unArbol)
{
  //Todo
}

disparar(otroPersonaje)
{
  //Todo
}
```

### Dar vida a los objetos mediante mensajes
#### Mensaje = objeto.método()

```java
personaje1 = new Personaje(100, "escopeta", 30);
personaje2 = new Personaje(50, "rifle", 9999);

vidaPersonaje1 = personaje1.getVida();
vidaPersonaje2 = personaje2.getVida();

if (vidaPersonaje1 > vidaPersonaje2)
{
  System.out.println("El personaje 2 tiene más vida que el 1");
}


vida1 = personaje2.getVida();
personaje2.setVida(333);
vida2 = personaje2.getVida();

System.out.println(vida2 == vida1); //Resultado true


personaje1.setVida(50);
personaje2.restaVida(30);
personaje2.modificaVida(-30);


arbol1 = new Arbol(100, "PREMIUM");
arbol2 = new Arbol(40, "BASICO");

//RETO: ¿Te atreverías a implementar la funcionalidad de estos métodos de personaje?
personaje1.picar(arbol1);
personaje1.disparar(personaje2);

```