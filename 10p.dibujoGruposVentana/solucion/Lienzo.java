import java.awt.Canvas;
import java.awt.Graphics;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;


public class Lienzo extends Canvas
{
	private JVentanaDibujo jVentanaDibujo;

	Lienzo(JVentanaDibujo jVentanaDibujo){
		this.jVentanaDibujo = jVentanaDibujo;
	}

	@Override
	public void paint(Graphics g)
	{
		jVentanaDibujo.getDibujo().getFiguras().forEach((figura,grupo)->figura.pintar(g));

	}


	public void mostrarTodo(){
		jVentanaDibujo.getDibujo().setVisibilidad(true);
		this.repaint();
	}
	public void ocultarTodo(){
		jVentanaDibujo.getDibujo().setVisibilidad(false);
		this.repaint();
	}
}
