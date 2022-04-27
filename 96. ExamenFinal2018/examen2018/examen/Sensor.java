package examen;

public abstract class Sensor implements Comparable{
    String id;
    String ubicacion;
    Calendar fecha;

    public String getId() {
        return id;
    }
    abstract boolean seteaValor(String valor);

    @Override
    int compareTo(Object o)
    {
        //Aqui comparar en base a la fecha y nombre del evento
    }

}
