package examen;

public class SensorTemperatura extends Sensor {
    float valor;
    static String unidad = "ºC";

    boolean seteaValor(String lectura){
        try {
            float f = Float.parseFloat(lectura);
            if (f <= 60 && f>=-40) {
                this.valor  = f;
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
