# Malas prácticas con la HERENCIA
## Esta es una Muy Mala práctica de escribir código
El código siguiente no compila, es pseudocódigo.

```java
class Lienzo
{
	Figura figuras = new Figura[10];

	paint()
	{
		for(Figura f:figuras)
		{
			if(f instanceof Circulo)
			{
				Circulo c = (Circulo) f;
				g.drawCircle(c.getRadio());
			}
			elseif(f instanceof Cuadrado)
			{
				Cuadrado c = (Cuadrado) f;
				g.drawRect(c.getLado());
			}
		}


	}
}
```

## MUY BUENA PRÁCTICA

El código siguiente no compila, es pseudocódigo.
```java
class Lienzo
{
	Figura figuras = new Figura[10];
	paint()
	{
		for(Figura f:figuras)
			f.pintar(g);
	}
}


class Circulo
{
	pintar(Graphics g)
	{
		g.drawCircle(radio);
	}
}
```