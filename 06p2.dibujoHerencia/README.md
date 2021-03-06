## Práctica 06p2. POO avanzado. Dibujo de diferentes tipos de figura. 
### Desarrollo de una aplicación gráfica que dibuje varios tipos de figuras basándose en el concepto de herencia.

Fusionar las prácticas 2 (pintar en un dibujo un cuadrado) y 3p1 (figuras en herencia) para que podamos representar cuadrados y circunferencias en un lienzo. Adicionalmente se meterá también la lógica de pintar triángulos. Esta fusión deberá cambiar la forma de pintar los cuadrados de las primeras prácticas. En la práctica 2 la lógica propia de pintar el cuadrado, no la tenía el propio objeto, si no la tenía el Dibujo. Esto va en contra de la filosofía del patrón Experto: cada objeto debe ser el que posea toda su lógica.

A continuación, se muestra un diagrama de secuencia que ayudará a saber el flujo de programa de nuestro código:

![alt text](https://raw.githubusercontent.com/AgustinICAI/javaCourseExamples2022/master/06p2.dibujoHerencia/_diagramaSecuencia.png)

Como ya programamos en la práctica 3, cada figura podrá tener relleno o no y poseerán un color específico, además de tener una posición.

Se investigará en la API del JDK la forma de pintar rectángulos y círculos con y sin relleno (https://docs.oracle.com/javase/9/docs/api/java/awt/Graphics.html).

##### Salida del programa

* AppDibujo01: Crear 1 círculo relleno, un cuadrado relleno, otro cuadrado sin relleno y un tríangulo relleno.
![alt text](https://raw.githubusercontent.com/AgustinICAI/javaCourseExamples2022/master/06p2.dibujoHerencia/output1.png)
* AppDibujo02: Crear 10 triángulos que se vayan pintando con un intervalo de 1 segundo desplazándose en forma diagonal (de arriba a la izquierda hacia abajo a la derecha).
![alt text](https://raw.githubusercontent.com/AgustinICAI/javaCourseExamples2022/master/06p2.dibujoHerencia/output2.png)


```java
//Para pintar el triángulo habrá que investigar
//https://docs.oracle.com/en/java/javase/16/docs/api/java.desktop/java/awt/Graphics.html#drawPolygon(java.awt.Polygon)
public void drawPolygon​(Polygon p)

//https://docs.oracle.com/en/java/javase/16/docs/api/java.desktop/java/awt/Polygon.html
Polygon​(int[] xpoints, int[] ypoints, int npoints)


```
