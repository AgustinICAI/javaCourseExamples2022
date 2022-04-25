# JAR
- Un archivo JAR (por sus siglas en inglés, en inglés Java ARchive) es un tipo de archivo que permite ejecutar aplicaciones y herramientas escritas en el lenguaje Java.
- Los archivos JAR están comprimidos con el formato ZIP y cambiada su extensión a .jar. 
- Los ficheros JAR por tanto contienen los bytecodes (classes) generados en el paso de compilación así como su estructura de paquetes. Para correr un jar al cual no se le ha definido una clase main:
    ```
    java -cp ventana.jar es.icai.poo.clasejar.app
    ```

- Es opcional que tengan un META-INF/MANIFEST.MF en su interior. En este fichero es donde se indica la clase principal (**Main-Class**) del JAR, aunque puede haber otros campos como **Author**, **Version** o **ClassPath** externos a utilizar.
    ```
    java -jar ventana.jar
    :: Teniendo ventana.jar un fichero META-INF/MANIFEST.MF con una linea Main-Class: es.icai.poo.clasejar.app
    ```

- La carpeta y fichero META-INF/MANIFEST.MF se pueden generar de forma manual, o se puede usar el comando **jar** para que genere el .jar con el manifest apunto ya a un Main-Class concreto:
```
::Primero hay que posicionarse donde se encuentren los paquetes y el bytecode
jar cfe ventana.jar es.icai.poo.clasejar.app .
```

- Un jar NO puede tener otros jar dentro. Para ello, es necesario:
    * O descomprimir estas librerías externas y meterlas en el JAR original.
    * O ejecutar el JAR haciendo un -cp para las librerías externas.
    * O en el fichero MANISFEST-MF incluir un linea adicional indicando todas los classpath necesarios en "Class-Path: MyUtils.jar".

# ClassPath
- Indica un path que puede ser un fichero (.class o .jar) o una carpeta (conjunto de .class o un grupo de jars)

- En la compilación puede ser necesario que se utilice javac -cp para indicar clases que están en nuestro import, pero que se encuentren fuera de nuestra estructura de paquetes definida. Esto pasa por ejemplo a la hora al compilar nuestro código, si hemos utilizado librerías externas, tendremos que especificarle el classpath. Un ejemplo:
    * En este ejemplo estamos diciendo que para compilar tenga encuenta lo que hay en la carpeta libs -> ".;./lib/*" Es importante indicar que el punto inicial (que indica la ruta actual) no siempre es necesario pero es recomendable para minizar los errores.
    ```java
        //código java de ejemplo
        package es.icai.coronaSample;
        import org.apache.commons.csv.CSVFormat;
        import org.jxmapviewer.JXMapKit;
    ```

    ```
    ::Compilación
    ::LINUX MAC
    javac -cp ".:./lib/*" ./src/es/icai/coronaSample/*.java -d "dist"
    ::WINDOWS
    javac -cp ".;./lib/*" .\src\es\icai\coronaSample\*.java -d "dist"
    ```
    * En este ejemplo en vez de hacer un directorio lib que contiene las librerías, directamente indicamos que las librerías externas se encuentra en la ruta actual
    ```java
        //código java de ejemplo
        package covid19;
        import org.jsoup.Jsoup;
    ```
    ```
    ::Compilación
    ::WINDOWS
    javac -cp .;jcommon-1.0.23.jar;jfreechart-1.0.19.jar;jsoup-1.13.1.jar covid19\JVentana.java 
    ```

- En la ejecución igual que la compilación puede ser necesaria la referencia a los class path para el correcto funcionamiento de las clases. Adicionalmente de cara a la ejecución, también será necesario meter dentro del classpath el directorio donde se encuentre nuestra estructura de paquetes compilada.
    * Ej1: nuestro código compilado se encuentra en una carpeta separada dist
    ```
    ::LINUX MAC
    java -cp ./lib/*:./dist/ es.icai.coronaSample.JCoronaWindow coronacases_20200330.csv 
    ::WINDOWS
    java -cp .\lib\*:.\dist\ es.icai.coronaSample.JCoronaWindow coronacases_20200330.csv 
    ```

    * Ej2: nuestro código compilado se encuentra en las mismas carpetas que nuestro source.
    ```
    ::WINDOWS
    java -cp .;jcommon-1.0.23.jar;jfreechart-1.0.19.jar;jsoup-1.13.1.jar covid19.JVentana 
    ```


### Ejecución
```java
//LINUX MAC
java -cp ".:./dist/:./libs/*" es.icai.ioExample.AppVentana
//WINDOWS
java -cp ".;.\dist\;C:\Program Files\Java\javafx-sdk-11.0.2\lib\*" es.icai.ioExample.AppVentana
```

# Ejemplo código 11a.jar
### Compilación y ejecución
```
::APP1
javac src/es/icai/poo/clasejar/app/*.java src/es/icai/poo/clasejar/ui/*.java -d dist
java -cp ".:dist" es.icai.poo.clasejar.app.App
```
```
::APP2
javac src/es/icai/poo/clasejar/app/*.java src/es/icai/poo/clasejar/ui/*.java -d dist
::Copia la imagen de src a dist
cp src/es/icai/poo/clasejar/app/fine.jpeg dist/es/icai/poo/clasejar/app/fine.jpeg 

java -cp ".:dist" es.icai.poo.clasejar.app.App
```

### Generación y ejecución del JAR
Ej1:
1. Copiar todo el contenido de dentro de dist un zip, cambiar la extensión a jar y ejecutar (en la misma ruta donde ejecutemos tiene que estar la carpeta resources):
2. java -cp ventana.jar es.icai.poo.clasejar.app.App

Ej2:
1. Copiar todo el contenido de dentro de dist un zip, generar un META-INF/MANIFEST.MF con:
```
Main-Class: es.icai.poo.clasejar.app
<-Recordar meted salto de linea
```
2. Cambiar la extensión a jar y ejecutar (en la misma ruta donde ejecutemos tiene que estar la carpeta resources):
3. java -jar ventana.jar 

Ej3:
2. java -cp ventana.jar es.icai.poo.clasejar.app.App2
