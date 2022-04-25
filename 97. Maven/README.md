[Link referencia](http://tutorials.jenkov.com/maven/maven-tutorial.html)


# Instalación
Añadir al path de de windows/linux el directorio bin de la descarga de maven
http://maven.apache.org/download.cgi


# Conceptos principales
## Fichero POM
- El fichero POM (Project Object Model) es la representación del proyecto.
- Escrito en XML
- Se definen de los recursos del proyecto: código fuente, código de prueba, las dependencias, si se utilizan JAR externos, etc. 
- El POM contiene referencias a todos estos recursos.
- El archivo POM debe ubicarse en el directorio raíz del proyecto al que pertenece.

## Build Life Cycles, Phases y Goals

- El proceso de construcción en Maven se divide en Build Life Cycles, Phases(fases) y Goals. Un **Life cycle** de construcción consiste en una secuencia de **Phases** de construcción, y cada Phase construcción consiste en una secuencia de **Goals**. 
- Cuando ejecutas Maven, le pasas un comando a Maven. Este comando es el nombre de un Build Life Cycle, Phase o Goal. 
    - Si se solicita la ejecución de un life cycle, se ejecutan todas las fases de construcción en ese life cycle. 
    - Si se solicita que se ejecute una fase, también se ejecutan todas las fases anteriores en la secuencia predefinida.

## Dependencies and Repositories

- Uno de los principales objetivos por los que se usa Maven es para definir las dependencias que necesita un proyecto. Las dependencias son archivos JAR externos que utiliza el proyecto. 
- Si las dependencias no se encuentran en el repositorio local de Maven, Maven las descarga de un repositorio central de Maven y las coloca en el repositorio local del equipo. Tanto los directorios remotos como los directorios locales son configurables.

# Maven POM Files

- El archivo POM describe qué construir pero no cómo construirlo.
- Cómo construirlo depende de las fases y goals de construcción de Maven. También se puden introducir goals personalizados si es necesario.
- Cada proyecto tiene un archivo POM. El archivo POM se llama pom.xml y debe ubicarse en el directorio raíz de su proyecto. 
- Un proyecto dividido en subproyectos generalmente tendrá un archivo POM para el proyecto principal y un archivo POM para cada subproyecto. 
- Esta estructura permite que el proyecto total se construya en un solo paso, o que cualquiera de los subproyectos se construya por separado.

Referencia completa del archivo POM, [POM de Maven](http://maven.apache.org/pom.html).

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>es.icai</groupId>
    <artifactId>hello-world</artifactId>
    <version>1.0.0</version>
</project>
```

- modelVersion establece qué versión del modelo POM está utilizando. La versión 4.0.0 coincide con las versiones 2 y 3 de Maven.

- El elemento groupId es un ID único para una organización o un proyecto de código abierto. La mayoría de las veces usará una ID de grupo que sea similar al nombre del paquete raíz de Java del proyecto. El ID de grupo es.icai se ubicará en un directorio MAVEN_REPO / es / icai. La parte MAVEN_REPO del nombre del directorio se reemplazará con la ruta del directorio del repositorio Maven.

- El elemento artifactId contiene el nombre del proyecto que está creando. En el caso de este proyecto hello-world, la identificación del artefacto es hello-world. La ID de artefacto se usa como nombre para un subdirectorio en el directorio de ID de grupo en el repositorio de Maven. La identificación del artefacto también se usa como parte del nombre del archivo JAR producido al construir el proyecto. La salida del proceso de compilación, generará un artefacto en Maven. Muy a menudo es un archivo JAR, WAR o EAR, pero también podría ser otra cosa.

- El elemento versionId contiene el número de versión del proyecto. Si el proyecto se ha lanzado en diferentes versiones, por ejemplo, una API de código abierto, entonces es útil versionar las compilaciones. De esa forma, los usuarios de el proyecto pueden consultar una versión específica de el proyecto. El número de versión se utiliza como nombre para un subdirectorio en el directorio de ID de artefacto. El número de versión también se usa como parte del nombre del artefacto construido.

Los elementos groupId, artifactId y version anteriores darían como resultado que se construya un archivo JAR y se coloque en el repositorio local de Maven en la siguiente ruta (directorio y nombre de archivo):

```
MAVEN_REPO/es/icai/hello-world/1.0.0/hello-world-1.0.0.jar
```

Si el proyecto usa la estructura de directorios de Maven y el proyecto no tiene dependencias externas, entonces el archivo POM mínimo anterior es todo lo que se necesita para construir el proyecto.

Si el proyecto no sigue la estructura de directorios estándar, tiene dependencias externas o necesita acciones especiales durante la construcción, se tienen que agregar más elementos al archivo POM. 

# Fichero de configuración de MAVEN
- Maven tiene dos archivos de configuración. En los archivos de configuración, puede configurar ajustes para Maven en todos los archivos POM de Maven. Por ejemplo, puede configurar: Ubicación del repositorio local, Perfil de compilación activo, Etc.

- Los archivos de configuración se denominan settings.xml. Los dos archivos de configuración se encuentran en:

- El directorio de instalación de Maven: $ M2_HOME / conf / settings.xml
- El directorio de del usuario: $ {user.home} /. M2 / settings.xml

Ambos archivos son opcionales. Si ambos archivos están presentes, los valores en el archivo de configuración de inicio del usuario anula los valores en el archivo de configuración de instalación de Maven.

Más sobre los archivos de configuración de Maven en la Referencia de [configuración de Maven](http://maven.apache.org/settings.html). 

# Estructura de Maven

Maven usa una estructura de directorio estándar. Si sigue esta estructura de directorios, no es necesario especificar los directorios en el fichero POM del código fuente, tests, etc.

Más sobre la estructura de directorios [estructura directorios Maven](http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

Estos son los directorios más importantes:
```
- src
  - main
    - java
    - resources
    - webapp
  - test
    - java
    - resources

- target
```

- El directorio src es el directorio raíz del código fuente y código de los test.
- El directorio main es el directorio raíz del código fuente relacionado con la aplicación en sí (no el código de los test). 
- El directorio de test contiene el código fuente de los test.

# Dependencias Maven
Si se trata de un proyecto grande o de empresa, es posible que se necesiten librerías externas Java. Estos archivos JAR son necesarios en el classpath cuando se compila el código del proyecto.

Es muy importante mantener el proyecto actualizado con las versiones correctas de estos archivos JAR externos. Cada JAR externo también puede necesitar otros archivos JAR externos, dependencias... Maven tiene una gestión de dependencias incorporada. Se especifica en el archivo POM de qué librerias externas dependen del proyecto y de qué versión, y luego Maven las descarga y las coloca en su repositorio local de Maven. Si alguna de estas librerias externas necesita otras librerias, estas otras librerias también se descargan en su repositorio local de Maven.

Estas dependencias se definen en el archivo POM. Ejemplo:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
   http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>es.icai</groupId>
    <artifactId>hello-world</artifactId>
    <version>1.0.0</version>
<!-- Aquí van las dependencias -->    
      <dependencies>

        <dependency>
          <groupId>org.jsoup</groupId>
          <artifactId>jsoup</artifactId>
          <version>1.7.1</version>
        </dependency>

        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.8.1</version>
          <scope>test</scope>
        </dependency>

      </dependencies>

    <build>
    </build>

</project>
``` 
Las dos dependencias anteriores se descargarán en los siguientes subdirectorios:
```
MAVEN_REPOSITORY_ROOT/junit/junit/4.8.1
```
```
MAVEN_REPOSITORY_ROOT/org/jsoup/jsoup/1.7.1
```

# Dependencias Externas

```xml
<dependency>
  <groupId>mydependency</groupId>
  <artifactId>mydependency</artifactId>
  <scope>system</scope>
  <version>1.0</version>
  <systemPath>${basedir}\war\WEB-INF\lib\mydependency.jar</systemPath>
</dependency>
```

# Repositorios Maven
Más sobre los repositorios maven [repos Maven](http://maven.apache.org/guides/introduction/introduction-to-repositories.html)

<p align="left">
  <img src="http://tutorials.jenkov.com/images/maven/maven-repositories.png" width="700">
</p>

### Local Repository
Un repositorio local está en el equipo del desarrollador. Este repositorio contendrá todas las dependencias que descarga Maven. Por defecto se utiliza el M2 de la carpeta de usuario.

### Central Repository
- El repositorio central de Maven es un repositorio proporcionado por la comunidad de Maven. 
- Por defecto, Maven busca en este repositorio central cualquier dependencia necesaria que no encuentre en su repositorio local. 
- Maven descarga estas dependencias al repositorio local. 

### Remote Repository
Un repositorio remoto es un repositorio en un servidor web desde el cual Maven puede descargar dependencias, al igual que el repositorio central. Un repositorio remoto puede estar en cualquier lugar de Internet o dentro de una red local.


# Ejecutando Maven
La ejecución de Maven se realiza con comando **mvn**. Al ejecutar el comando mvn, le pasa el nombre del life-cycle, fase o goal, el cual Maven  ejecuta. Aquí hay un ejemplo:
```
mvn install
```

Este comando ejecuta la fase **install** (parte del life-cycle default):
- Compila el proyecto
- Copia el archivo JAR empaquetado en el repositorio local de Maven. 

Este comando ejecuta todas las fases de compilación antes de instalar (install).

[Información sobre los lifecycle](http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

El lifecycle default, abarca las siguientes fases:

| Phase | Acción |
| ---      | --- |
| validate | validate the project is correct and all necessary information is available |
| compile  | compile the source code of the project |
| test     | test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed |
| package  | take the compiled code and package it in its distributable format, such as a JAR. |
| verify   | run any checks on results of integration tests to ensure quality criteria are met |
| install  | install the package into the local repository, for use as a dependency in other projects locally |
| deploy   | done in the build environment, copies the final package to the remote repository for sharing with other developers and projects |


## Maven Build Profiles
Permiten construir el proyecto utilizando diferentes configuraciones. En lugar de crear dos archivos POM separados, se pueden especificar perfiles con la configuración de compilación diferente.
[Maven Build Profiles](http://maven.apache.org/pom.html#Profiles)


## Maven Plugins
Permiten agregar sus propias acciones al proceso de compilación. Lo hace creando una clase Java simple que extiende una clase especial de Maven y luego crea un POM para el proyecto. El plugin debe ubicarse en su propio proyecto.
[Maven plugins](http://maven.apache.org/plugin-developers/index.html)


# Ejercicio propuesto
- A partir de los poms explicados, generar:
  - Artefacto con una clase holamundo
  - Artefacto con una clase holamundo y una dependencia de una librería de la comunidad.

- tips:
```xml
<!--Hacer maven compatible con java 8 y no se queje de la codificación -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
    </properties>
```