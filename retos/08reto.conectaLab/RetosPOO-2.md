# Retos de Programación Orientada a Objetos

 ## Reto 2. Benchmarking cálculo del número PI
 
**Objetivo**: Realizar un becnhmarking sobre el cálculo del número PI mediante el Método de Montecarlo que se suministra con distinto número de iteraciones.

**Tipo de trabajo**: Colaborativo en grupos de 4 alumnos.

**Duración**: 15 minutos

**Datos**: Las iteraciones a probar serán desde 1 hasta 10^8, en incrementos de x10.

**Salida del programa**: Mostrar una tabla de resultados que muestre los siguientes valores:

El significado de cada columna es:
```
Valor obtenido de PI, número de iteraciones, tiempo de ejecución, error absoluto obtenido.
```
No será necesario mostrar el encabezado anterior.

```
4.0, 1, 0ms., 858407 error
2.8, 10, 0ms., 341592 error
3.28, 100, 0ms., 138407 error
3.016, 1000, 0ms., 125592 error
3.1628, 10000, 12ms., 21207 error
3.14064, 100000, 113ms., 952 error
3.140548, 1000000, 935ms., 1044 error
3.141434, 10000000, 9971ms., 158 error
```


```Java
class App
{
    static double calculoPIMontecarlo(long iteraciones)
    {
        double x;
        double y;
        int exito = 0;
        for (int i=0;i<iteraciones;i++)
        {
            x = Math.random();
            y = Math.random();
            if ((Math.pow(x, 2) + Math.pow(y, 2)) <= 1)
                exito++;
        }
        return (double) (4*exito)/iteraciones;
    }  
}
```


```Java

```
