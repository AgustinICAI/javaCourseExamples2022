package examen;

public class SensorHumedad extends Sensor {
    int valor;
    static String unidad = "%";

    @Override
    boolean seteaValor(String lectura) {
        try {
            int i = Integer.parseInt(lectura);
            if (i <= 100 && i>=0) {
                this.valor = i;
                return true;
            }
            else return false;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
