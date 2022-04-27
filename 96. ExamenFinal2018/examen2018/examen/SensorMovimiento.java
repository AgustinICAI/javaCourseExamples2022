package examen;

public class SensorMovimiento extends Sensor {
    boolean valor;
    static String unidad = "";

    @Override
    boolean seteaValor(String lectura) {
        if(lectura.equals("si")) {
            this.valor = true;
            return true;
        }
        else if(lectura.equals("no")) {
            this.valor = false;
            return true;
        }
        else
            return false;
    }
}
