package dominio;
//Es usado desde una clase de otro paquete
public class A
{
    //Atributos siempre privados, salvo que sean ATRIBUTOS DE CLASE
    private int a;
    //Es usado desde una clase de otro paquete
    public A(int a){....}
    //Sin información sufiente para definirlo, siendo un getter, no habría problema que fuera public
    int getA(){....}
    //Sin información sufiente para definirlo, siendo un setter, habría que entender que se setea.
    void setA(int a){....}

    //Es usado desde una clase de otro paquete
    public int m()
    {
        int x = this.m2() + this.m3();
    }
    //Es usado también por la clase hija, por lo que tiene que ser protected
    protected int m2(){....}
    //Sólo es usado por el método m
    private int m3(){....}
    //El public se hereda, un método hijo no puede ser más restrictivo que el padre
    public String toString(){....}
}

package otroDominio;
//Es usado desde una clase de otro paquete
public class B extends A
{
    //Atributos siempre privados, salvo que sean ATRIBUTOS DE CLASE
    private int b;

    public B(int a, int b){....}

    int getB(){....}

    void setB(int b){....}

    public int m()
    {
        int x = this.m2() + this.m4();
    }

    private int m4(){....}

    public String toString(){....}

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