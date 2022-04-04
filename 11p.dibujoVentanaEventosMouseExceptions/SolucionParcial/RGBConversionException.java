public class RGBConversionException extends IllegalArgumentException  {
    enum Color{
        R("Rojo"),G("Verde"),B("Azul");
        String color;
        Color(String c){
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    RGBConversionException.Color colorProblematico;

    public RGBConversionException(RGBConversionException.Color colorProblematico, int numProblematico){
        super("El color " + colorProblematico.getColor() + "no puede tener el valor "+ numProblematico+ " Valor válido: [0-255]");
    }

}
