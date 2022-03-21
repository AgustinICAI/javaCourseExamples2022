import java.awt.Canvas;
import java.awt.Graphics;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;


public class Lienzo extends Canvas
{
	private HashMap<Figura,String> figuras;

	public Lienzo()
	{
		 figuras = new HashMap<>();
	}

	public void addFigura(Figura figura,String grupo)
	{
		figuras.put(figura,grupo);
	}

	@Override
	public void paint(Graphics g)
	{
		/*
		figuras.stream().forEach((figura)->{
			figura.pintar(g);
		});*/

		//figuras.forEach(figura-> figura.pintar(g));

		//for(Figura figura:figuras)
		//	figura.pintar(g);

		figuras.forEach((figura,grupo)->figura.pintar(g));

	}

	public void ocultar(String grupoOcultar) {
		figuras.forEach((figura,grupo) -> {
			if(grupo.equals(grupoOcultar))
				figura.setVisible(false);

		});
	}

	public void setVisibilidad(boolean visibilidad){
		figuras.forEach((figura,grupo)->figura.setVisible(visibilidad));
	}

	public void mostrarTodo(){
		this.setVisibilidad(true);
		this.repaint();
	}
	public void ocultarTodo(){
		this.setVisibilidad(false);
		this.repaint();
	}
}
