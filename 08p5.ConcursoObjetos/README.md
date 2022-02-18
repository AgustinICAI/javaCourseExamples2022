En esta práctica, se simulará el concurso sobre el que se ha trabajado en las últimas clases. En la edición inventada por el alumno, entrarán 5 parejas, 5 solteros y 5 solteras con nombres fictios.

Recordando la lógica del concurso, algunas parejas están consolidadas de años, otras son de pocos meses, por lo que hay que almacenar el día que comenzaron la relación las parejas. Otro parámetro a poder calcular, es el factor estabilidad de la pareja, la cual se calculará en base al número de días que llevan juntos multiplicado por la edad media de ambos, y un factor que dependerá del tipo de relación: Conocidos de forma natural fuera del programa (1), Conocidos de forma natural en otro concurso (5) o Sin conocerse relación previa pero se han unido para el concurso (3), y si ha habido infidelidad previa, esto se multiplará por 5.

Es necesario simular la lógica del concurso durante 30 días.

Cada vez que se celebre una hoguera (una vez a la semana), 2 solteros (1 chico y 1 chica) serán expulsados. Para simular la expulsión será necesario usar la clase Ramdom (https://docs.oracle.com/javase/8/docs/api/java/util/Random.html).

Por cada día que pase también hay posibilidades de que las parejas se rompan por culpa de algún soltero, y por tanto también abandonarían el concurso. Para ello, cada soltero/a tiene un factor tentador que se comporta de forma normal de -10000 a 10000 (revisar también la clase ramdom y el comportamiento gaussiano). Si el soltero/a al tentar, si su factor tentador aleatorio  supera el factor del la pareja que está tentando, esa pareja será expulsada ese día.

Es necesario pasados 30 días, mostrar las parejas quedan finalmente en el concurso. El concurso empezará el 18 de febrero de 2022 y finalizará pasados 30 días.
También es necesario mostrar por pantalla todas las relaciones que ha habido que han hecho que se tuvieran que ir las parejas.

Adicionalmente a lo anterior, se pide:
- Realizar el diagrama de clases.
- Realizar un diagrama de paquetes.
- Programar los casos de uso anterior descritos.


Especificaciones técnicas:
- Es recomendable usar la clase LocalDateTime, aunque también se puede usar la clase Calendar vista en clase. Para obtener diferencia de dias, se puede realizar mediante la clase Duration. *De cara al examen no hay que conocer estas clases, pero lo que si hay que saber es mirar la documentación JAVADOC*
- Hay que trabajar utilizando *enums* donde sea necesario.
- Crear expresamente un método ConcursanteSoltero getConcursanteRamdom() que devuelva un ConcursanteSoltero que se utilizado en las hogueras.
- Crear expresamente un método Pareja[] getParejasRotas() que vuelva un array de parejas rotas por cada día.
- Instance of/downncasting
  Se trabajará con la nueva forma de hacer downcasting en un paso:
  ```java
  if(o instanceof Concursante concursante)
    return concursante.getNombre().equals(this.getNombre());
  else
    return false;
  ```

- Codicionales unarios

Se probará a trabajar con expresiones condicionales unarias en Java, muy parecidas a las que define Python:

##### Python

```python
>>> nombre = None
>>> nombreUpper = nombre.upper() if nombre != None else "UNNAMED"
>>> nombreUpper
'UNNAMED'
>>> nombre = "Luis"
>>> nombreUpper = nombre.upper() if nombre != None else "UNNAMED"
>>> nombreUpper
'LUIS'
```

##### Java
```java
String nombre = (nombre != null)?nombre.toUpperCase():"UNNAMED";

jshell> String nombre;
jshell> String nombreUpper = (nombre != null)?nombre.toUpperCase():"UNNAMED";
nombre ==> "UNNAMED"
jshell> nombre = "Luis";
jshell> String nombreUpper = (nombre != null)?nombre.toUpperCase():"UNNAMED";
nombre ==> "LUIS"
```

