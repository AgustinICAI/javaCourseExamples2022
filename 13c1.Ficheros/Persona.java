public class Persona {
    String nombre;
    String apellido;
    String peliculaFavorita;
    int edad;

    public Persona(String nombre, String apellido, String peliculaFavorita, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peliculaFavorita = peliculaFavorita;
        this.edad = edad;
    }


    public static Persona fromCSV(String linea){
        String [] campos = linea.split(",");
        try {
            return new Persona(quitaComillas(campos[0]),
                    quitaComillas(campos[1]),
                    quitaComillas(campos[3]),
                    Integer.parseInt(quitaComillas(campos[2])));
        }catch (NumberFormatException e){
            return null;
        }
    }

    public String toCSV(){
        return "\""+nombre+"\","+
               "\""+apellido+"\","+
               "\""+edad+"\","+
               "\""+peliculaFavorita+"\"";
    }

    private static String quitaComillas(String cad){
        cad = cad.trim();
        if(cad.substring(0,1).equals("\"") && cad.substring(cad.length()-1).equals("\""))
            cad = cad.substring(1,cad.length()-1);
        return cad;
    }

}
