# Estilo de código
### Ejemplos de estilos que se seguirán en clase

## Recomendaciones en Python (PEP8)

Se utiliza snake_case y con espacios entre elementos.

Estilos:
- snake_case: nombre_persona
- JAVA-> camelCase: nombrePersona
- kebab-case
- l33t: m4d3r4

```python
def getNombre():
	a = 3
	return nombre
```

```python
if a > 99:
	variable_uno = 3
```

## Recomendaciones en Java

```java
getNombre()
{
	a = 3;
	return nombre;
}

if (a > 99)
{
	variableUno = 3
}
``` 

Aunque el lengaje lo soporte, evitaremos las siguientes expresiones:
```java
getNombre()
{
a = 3;return nombre;
}

getNombre(){a = 3;return nombre;}
```