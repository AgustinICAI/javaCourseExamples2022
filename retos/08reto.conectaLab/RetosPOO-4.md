# Retos de Programación Orientada a Objetos

 ## Reto 4. Modificadores de acceso

**Objetivo**: Dado el siguiente programa, establecer los modificadores de acceso **más restrictivos posibles** para que siga un diseño correcto y además, funcione el programa.

**Tipo de trabajo**: Colaborativo en grupos de 4 alumnos.

**Duración**: 5 minutos

```java

package dominio;

class A
{

    int a;

    A(int a){....}

    int getA(){....}

    void setA(int a){....}

    int m()
    {
        int x = this.m2() + this.m3();
    }

    int m2(){....}

    int m3(){....}

    String toString(){....}
}

package otroDominio;

class B extends A
{
    int b;

    B(int a, int b){....}

    int getB(){....}

    void setB(int b){....}

    int m()
    {
        int x = this.m2() + this.m4();
    }

    int m4(){....}

    String toString(){....}

}

package ui;

class App
{
    static void main(String args[])
    {
        A a1 = new A(1);
        B b1 = new B(1, 1);
        a1.m();
        b1.m();
    }
}

```
