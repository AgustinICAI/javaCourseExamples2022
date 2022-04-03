import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
	Facilita la representación gráfica de objetos creados por el alumno mediante una ventana gráfica y un lienzo 
*/
public class JVentanaDibujo extends JFrame
{

	public static void main (String argv[]){
		new JVentanaDibujo();
	}
	private Dibujo dibujo;
	private Lienzo lienzo;
	private JButton btnCirculo,btnCuadrado;
	private JTextField txtX,txtY,txtLado;

	public JVentanaDibujo()
	{
		super("Dibujo");
		lienzo = new Lienzo(this);
		dibujo = new Dibujo();
		initComponents();

		btnCirculo.addActionListener(e ->  {
			pintar(new Circulo(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()), true, Color.RED, Integer.parseInt(txtLado.getText())),"GRUPO CUALQUIERA");

		});
		btnCuadrado.addActionListener(e ->  {
			JVentanaDibujo.this.pintar(new Cuadrado(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()), true, Color.RED, Integer.parseInt(txtLado.getText())),"GRUPO CUALQUIERA");

		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	private void initComponents() {
		lienzo.setSize(800,600);
		//this.add(lienzo, BorderLayout.CENTER);
		this.add(lienzo);

		JPanel pnlNorth = new JPanel();
		txtX = new JTextField(5);
		txtY = new JTextField(5);
		txtLado = new JTextField(5);
		btnCirculo = new JButton("Añadir Círculo");
		btnCuadrado = new JButton("Añadir Cuadrado");
		pnlNorth.add(new JLabel("x:"));
		pnlNorth.add(txtX);
		pnlNorth.add(new JLabel("y:"));
		pnlNorth.add(txtY);
		pnlNorth.add(new JLabel("lado/radio:"));
		pnlNorth.add(txtLado);
		pnlNorth.add(btnCirculo);
		pnlNorth.add(btnCuadrado);
		this.add(pnlNorth, BorderLayout.NORTH);

	}


	public void pintar(Figura figura,String grupo)
	{
		dibujo.addFigura(figura,grupo);
		lienzo.repaint();
	}

	public void ocultar(String grupo) {
		dibujo.ocultar(grupo);
		lienzo.repaint();
	}


	public Dibujo getDibujo() {
		return dibujo;
	}
}