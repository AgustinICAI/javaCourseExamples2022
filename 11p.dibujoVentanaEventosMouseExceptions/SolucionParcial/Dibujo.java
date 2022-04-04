import java.util.HashMap;

public class Dibujo {
    private HashMap<Figura,String> figuras = new HashMap<>();

    public void addFigura(Figura figura,String grupo) {
        this.figuras.put(figura,grupo);

    }

    public void ocultar(String grupoOcultar) {
        figuras.keySet().stream().
                filter(figura -> figuras.get(figura).equals(grupoOcultar)).
                forEach( figura-> figura.setVisible(false));
    }

    public HashMap<Figura,String> getFiguras() {
        return figuras;
    }

    public void setVisibilidad(boolean visibilidad){
        figuras.forEach((figura,grupo)->figura.setVisible(visibilidad));
    }

}
