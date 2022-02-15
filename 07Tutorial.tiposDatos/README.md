# Tipos de datos y Wrappers

## Tipos de datos primitivos

En Java, la tipificación de variables además de restringir los tipos de valores que pueden recibir, sirven para optimizar la cantidad de memoria a utilizar para almacenar los valores pertinentes. 

Cada tipo de dato va a utilizar un número de bits para guardar cada información (precisión). Eso significa que si yo deseo guardar una información como la edad (0 a 120 años), posiblemente con utilizar 8 bits servirá: 2^8 = 256 y no se necesitará emplear más memoria (más adelante veremos que no se pueden emplear todos los bits para almacenar el valor).

| Tipo | Valor por defecto | Precisión | 
| --- | --- | --- |
| boolean | false | 1 bit | 
| byte | 0 | 8 bits | 
| short | 0 | 16 bits | 
| int | 0 | 32 bits | 
| long | 0L | 64 bits | 
| float | 0.0f | 32 bits |
| double | 0.0d | 64 bits |
| char | '\u0000'| 16 bits | 

Podríamos definir variables numéricas de la siguiente forma, sabiendo que el espacio de memoria para cada tipo es diferente, así como los valores máximos a almacenar en ellos, obviamente. Así, el valor máximo a almacenar en un tipo de dato será 2^(n-1)-1 y el mínimo 2^(n-1). El hecho de utilizar el tamaño de cada tipo menos uno, es porque ese bit se emplea para indicar el signo.


```Java
int numero1 = 56; //esta variable podría llegar a almacenar hasta el valor 2.147.483.647: 2^31-1
byte numero2 = 56; //esta variable podría llegar a almacenar hasta el valor 127: 2^7-1
```

Si intentamos asignar valores más altos, Java nos lanzará un mensaje de error, ya que no tiene capacidad para alamcenar esos valores.


```Java
byte b = 128;
```


    |   byte b = 128;

    incompatible types: possible lossy conversion from int to byte

    



```Java
byte b1 = 127;
b1
```




    127




```Java
byte b2 = -128;
b2
```




    -128




```Java
int i = 65;
i
```




    65




```Java
double d = 65.4;
d
```




    65.4




```Java
boolean b = true;
b
```




    true



Ojo, porque hay ciertos valores numéricos que tienen una connotación por defecto. Por ejemplo, un número en coma flotante por defecto es un double. Eso no ocurre con los números enteros. En la siguiente sección se resolverá esta problemática.


```Java
byte b = 65;
b
```




    65




```Java
float f = 65.6; //65.6 por defecto es un double
```


    |   float f = 65.6; //65.6 por defecto es un double

    incompatible types: possible lossy conversion from double to float

    


## Conversiones (Cast)

En Java podemos hacer conversiones de un tipo de dato a otro, sin embargo se debe tener en cuenta en algunos casos se puede perder información en este proceso.

Cuando se produzca está situación deberemos indicar al compilador de manera explícita el tipo al cual queremos convertir nuestro dato. De esta manera le estamos diciendo que "ya sabemos" que se puede perder información. En caso contrario se producirá un error.

Existen dos tipos de conversión:
- Implícita (siempre que no se produzca pérdida de información)
- Explícita (siempre que se produzca o se pueda producir pérdida de información).


### Cast implícito

En estas conversiones no se perderá información porque se almacena una variable de menor precisión en una de mayor. Por ejemplo, si almacenamos un valor de una variable tipo int (16 bits) en una variable tipo long (32), nunca se perderá información, por lo que la conversión se dice que será segura.


```Java
int i = 45; //32 bits
long l = i; //64 bits

System.out.println(i);
System.out.println(l);
```

    45
    45
    

### Cast explícito

En cambio, en el caso inverso, podría haber pérdida de información y así nos lo indica el compilador. El compilador, en este caso, no evalúa el número almacenado en ese momento, si no el que puede llegar a tener en un futuro. Por ello, nos avisará de este posible futuro error.


```Java
long l = 45; //64 bits
int i = l; //32 bits - se perderían 32 bits
```


    |   int i = l; //32 bits - se perderían 32 bits

    incompatible types: possible lossy conversion from long to int

    


Para indicar al compilador que estamos asumiendo esta posible pérdida de información, pondremos entre paréntesis el tipo de dato al que queremos convertir, lo que se conoce como cast explícito.


```Java
long l = 45;
int i = (int) l; //Le decimos que somos conscientes de la posible pérdida de información

System.out.println(i);
System.out.println(l);
```

    45
    45
    

Por defecto un número en coma flotante es un _double_


```Java
double d = 45.56;
```

Por ese motivo, la siguiente línea dará un error al poder perder información en el paso de un double a float, como vimos anteriormente.


```Java
float f = 45.56; //Conversión de double a float
```


    |   float f = 45.56; //Conversión de double a float

    incompatible types: possible lossy conversion from double to float

    


Para solucionar esta asignación básica, se podrán plantear distintas soluciones:


```Java
float f = (float) 45.56;
float f = 45.56F;
float f = 45.56f;
```

### Ejemplo de conversiones de tipos primitivos


```Java
byte b = 45;
```


```Java
int i = b;
```


```Java
byte b2 = i;
```


    |   byte b2 = i;

    incompatible types: possible lossy conversion from int to byte

    



```Java
float f0 = 45.7;
```


    |   float f0 = 45.7;

    incompatible types: possible lossy conversion from double to float

    



```Java
float f1 = 45.7F;
```


```Java
float f2 = (float) 45.7;
```


```Java
float f3 = 45.7;
```


    |   float f3 = 45.7;

    incompatible types: possible lossy conversion from double to float

    



```Java
int i2 = 56; 
```


```Java
float f4 = i2;
```

## Caracteres

Los caracteres se almacenan internamente como números sin el bit del signo, por lo que la resolución es de 2^16.

Existe varias formas de crear un carácter:
```java
'a' //--> Carácter: Siempre utilizando la comilla simple.
'\t' //--> Secuencia de escape: Tabulador.
'\u????' //--> Carácter UNICODE en hexadecimal:La representación del carácter ‘A’ será ‘\u0041’.
65 //--> Entero: Representación ASCII del carácter ‘A’.
```





```Java
char c1 = 65; //En binario 0100 0001
char c2 = '\u0041'; //Representación UNICODE. En hexadecimal 0100 -> 4; 0001 -> 1 = 41
char c3 = 'A'; 
String s1 = "A"; //Es lo que diferencia a un char 'A' de un String "A"
System.out.println(c1 + " - " + c2 + " - " + c3 );
```

    A - A - A


Los caracteres se comportan internamente como valores numéricos, por lo que se puede hacer operaciones con ellos. 


```Java
int i = 'A';
i
```




    65




```Java
char c4 = (i + 1);
```


    |   char c4 = (i + 1);

    incompatible types: possible lossy conversion from int to char

    


Se debe hacer un cast explícito en la conversión de un int a char, porque aunque posean más bits de precisión, se pierde el bit del signo.


```Java
char c = (char) (i + 1);
c
```




    B



El siguiente código mostraría toda la tabla de equivalencias de los caracteres a su número


```Java
for(int j=65;j<179;j++)
    System.out.println("Char: " + (char)j + " Valor UTF-16: " + j);

```

    Char: A Valor UTF-16: 65
    Char: B Valor UTF-16: 66
    Char: C Valor UTF-16: 67
    Char: D Valor UTF-16: 68
    Char: E Valor UTF-16: 69
    Char: F Valor UTF-16: 70
    Char: G Valor UTF-16: 71
    Char: H Valor UTF-16: 72
    Char: I Valor UTF-16: 73
    Char: J Valor UTF-16: 74
    Char: K Valor UTF-16: 75
    Char: L Valor UTF-16: 76
    Char: M Valor UTF-16: 77
    Char: N Valor UTF-16: 78
    Char: O Valor UTF-16: 79
    Char: P Valor UTF-16: 80
    Char: Q Valor UTF-16: 81
    Char: R Valor UTF-16: 82
    Char: S Valor UTF-16: 83
    Char: T Valor UTF-16: 84
    Char: U Valor UTF-16: 85
    Char: V Valor UTF-16: 86
    Char: W Valor UTF-16: 87
    Char: X Valor UTF-16: 88
    Char: Y Valor UTF-16: 89
    Char: Z Valor UTF-16: 90
    Char: [ Valor UTF-16: 91
    Char: \ Valor UTF-16: 92
    Char: ] Valor UTF-16: 93
    Char: ^ Valor UTF-16: 94
    Char: _ Valor UTF-16: 95
    Char: ` Valor UTF-16: 96
    Char: a Valor UTF-16: 97
    Char: b Valor UTF-16: 98
    Char: c Valor UTF-16: 99
    Char: d Valor UTF-16: 100
    Char: e Valor UTF-16: 101
    Char: f Valor UTF-16: 102
    Char: g Valor UTF-16: 103
    Char: h Valor UTF-16: 104
    Char: i Valor UTF-16: 105
    Char: j Valor UTF-16: 106
    Char: k Valor UTF-16: 107
    Char: l Valor UTF-16: 108
    Char: m Valor UTF-16: 109
    Char: n Valor UTF-16: 110
    Char: o Valor UTF-16: 111
    Char: p Valor UTF-16: 112
    Char: q Valor UTF-16: 113
    Char: r Valor UTF-16: 114
    Char: s Valor UTF-16: 115
    Char: t Valor UTF-16: 116
    Char: u Valor UTF-16: 117
    Char: v Valor UTF-16: 118
    Char: w Valor UTF-16: 119
    Char: x Valor UTF-16: 120
    Char: y Valor UTF-16: 121
    Char: z Valor UTF-16: 122
    Char: { Valor UTF-16: 123
    Char: | Valor UTF-16: 124
    Char: } Valor UTF-16: 125
    Char: ~ Valor UTF-16: 126
    Char:  Valor UTF-16: 127
    Char:  Valor UTF-16: 128
    Char:  Valor UTF-16: 129
    Char:  Valor UTF-16: 130
    Char:  Valor UTF-16: 131
    Char:  Valor UTF-16: 132
    Char:  Valor UTF-16: 133
    Char:  Valor UTF-16: 134
    Char:  Valor UTF-16: 135
    Char:  Valor UTF-16: 136
    Char:  Valor UTF-16: 137
    Char:  Valor UTF-16: 138
    Char:  Valor UTF-16: 139
    Char:  Valor UTF-16: 140
    Char:  Valor UTF-16: 141
    Char:  Valor UTF-16: 142
    Char:  Valor UTF-16: 143
    Char:  Valor UTF-16: 144
    Char:  Valor UTF-16: 145
    Char:  Valor UTF-16: 146
    Char:  Valor UTF-16: 147
    Char:  Valor UTF-16: 148
    Char:  Valor UTF-16: 149
    Char:  Valor UTF-16: 150
    Char:  Valor UTF-16: 151
    Char:  Valor UTF-16: 152
    Char:  Valor UTF-16: 153
    Char:  Valor UTF-16: 154
    Char:  Valor UTF-16: 155
    Char:  Valor UTF-16: 156
    Char:  Valor UTF-16: 157
    Char:  Valor UTF-16: 158
    Char:  Valor UTF-16: 159
    Char:   Valor UTF-16: 160
    Char: ¡ Valor UTF-16: 161
    Char: ¢ Valor UTF-16: 162
    Char: £ Valor UTF-16: 163
    Char: ¤ Valor UTF-16: 164
    Char: ¥ Valor UTF-16: 165
    Char: ¦ Valor UTF-16: 166
    Char: § Valor UTF-16: 167
    Char: ¨ Valor UTF-16: 168
    Char: © Valor UTF-16: 169
    Char: ª Valor UTF-16: 170
    Char: « Valor UTF-16: 171
    Char: ¬ Valor UTF-16: 172
    Char: ­ Valor UTF-16: 173
    Char: ® Valor UTF-16: 174
    Char: ¯ Valor UTF-16: 175
    Char: ° Valor UTF-16: 176
    Char: ± Valor UTF-16: 177
    Char: ² Valor UTF-16: 178
    

Los caracteres poseen total compatibilidad con los tipos enteros:


```Java
char c='A';
c
```




    A




```Java
int a = c;
a
```




    65




```Java
a = a + 1;
a
```




    66




```Java
char c2 = (char) a;
c2
```




    B



Tabla de secuencias de escape:
'\n' Nueva línea
'\t' tabulación
'\b' retorno
'\r' salto de carro
'\f' salto de hoja
'\'' comilla simple
'\"' doble comilla
'\\' barra invertida

## Wrappers

https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Integer.html

En Java tenemos un conjunto de clases que permiten trabajar con tipos de datos como si fuesen objetos.A estas clases se las denomina envoltorios o wrappers. Utilizaremos estas clases cuando tengamos que trabajar obligatoriamente con objetos. La correspondencia entre tipos y objetos se define a continuación:

| Tipo | Valor por defecto | Precisión | Wrapper |
| --- | --- | --- | --- |
| boolean | false | 1 bit | Boolean |
| byte | 0 | 8 bits | Byte |
| short | 0 | 16 bits | Short |
| int | 0 | 32 bits | Integer |
| long | 0L | 64 bits | Long |
| float | 0.0f | 32 bits | Float |
| double | 0.0d | 64 bits | Double |
| char | '\u0000'| 16 bits | Character |

### Conversiones de tipo primitivo a Objeto:

La forma de encapsular un tipo como un Wrapper siempre será mediante los métodos estáticos sobrecargados valueOf(....):
- int a Integer: Integer.valueOf(int a)
- double a Double: Double.valueOf(double a)
- long a Long: Long.valueOf(long a)
- ...


```Java
int i = 65;
Integer miInt = Integer.valueOf(i);
miInt
```




    65



Al estar sobrecargados estos métodos, nos permitirá otro tipo de conversiones:


```Java
Integer.valueOf("65")
```




    65



### Conversiones de Objeto a tipo primitivo

Se utilizarán los métodos tipoValue() de cada clase:
- Integer a int: int intValue()
- Double a double: double doubleValue()
- Long a long: long longValue()
- ...


```Java
int i = miInt.intValue();
i
```




    65



### Conversiones entre diferentes tipos de datos básicos

Para hacer otras conversiones hay que utilizar las clases Wrapper del tipo destino a convertir:

- Objeto a String: String toString()
- String a Integer: static Integer valueOf(String s)
- String a Float : static Float valueOf(String s)
- String a int (en Integer): static int parseInt(String s)
- String a float (en Float): static float parseFloat(String s)


```Java
String s = "34";
Long miLong = Long.valueOf(s);
miLong
```




    34



Si se desea convertir a int, busco en Integer.


```Java
String s = "7";
int a = Integer.parseInt(s);
s = String.valueOf(a);

System.out.println(s);
```

    7
    


```Java
char c;
Character ch= new Character('x');
c=ch.charValue();

System.out.println(c);
```

    x
    

## Autoboxing

A partir de la versión 1.5 Java introduce el concepto de Autoboxing: permite asignaciones directas entre tipos y sus Wrappers. Ojo, es obligatorio conocer este hecho ya que no tendrá sentido utilizar Wrappers en operaciones artiméticas o como atributos, aunque Java permita esta asignación.

En el siguiente caso la sentencia...


```Java
Integer miInteger = Integer.valueOf(34);
```

 ...se podría simplificar por...


```Java
Integer miInteger = 34;
```

En el proceso de desencapsulado (unboxing) funcionaría igual.


```Java
int i = miInteger.intValue()
```

...se podría simplificar por...


```Java
int i = miInteger;
i
```




    34



## Reto

Realizar las siguientes conversiones: 
54.6 --> float --> char --> Character --> String --> Integer --> int --> float
