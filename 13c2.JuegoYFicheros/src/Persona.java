import java.awt.*;
import java.util.Random;

public class Persona extends Sprite {
    String nombre;
    String apellido;
    String peliculaFavorita;
    int edad;

    public Persona(String nombre, String apellido, String peliculaFavorita, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peliculaFavorita = peliculaFavorita;
        this.edad = edad;
        Random r = new Random();
        y = r.nextInt(PanelJuego.ALTURA-100) + 40;//para que sea disparable +-100 y no salgan muy pegados a los extremos
        x = PanelJuego.ANCHURA;
        velocidad = 100;
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

    int anchoPersona;
    int altoPersona = 20;
    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        g.setFont(new Font("Courier",Font.BOLD,altoPersona));
        anchoPersona = g.getFontMetrics().stringWidth(this.nombre);
        g.drawString(this.nombre,(int)x,(int)y);

    }
    //Pixeles por segundo

    public void actualizarPosicion() {
        this.x -= velocidad /PanelJuego.FPS;
    }

    @Override
    public Rectangle getCollisionArea() {
        return new Rectangle((int) x, (int) y-altoPersona, anchoPersona, altoPersona);
    }
}
