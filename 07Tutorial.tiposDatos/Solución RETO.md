## Solución del Reto

Realizar las siguientes conversiones: 
54.6 --> float --> char --> Character --> String --> Integer --> int --> float


```Java
double d = 54.6;
float f = (float) d;
char c = (char) f;
c
```




    6




```Java
(int) c; //Cast a entero. El valor ASCII 54 representa el caracter '6'
```




    54




```Java
//Character ch = new Character(c) //DEPRECATED
Character ch = Character.valueOf(c);
String s = ch.toString();
Integer integer1 = Integer.valueOf(s); //Ojo la diferencia con este método: int i = Integer.parseInt(s);
int i = integer1.intValue(); //Ojo con la diferencia con el AUTOBOXING: int i = Integer.valueOf(s); 
float f = i;
f
```




    6.0


