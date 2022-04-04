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
	private JTextField txtRojo,txtVerde,txtAzul;

	public JVentanaDibujo()
	{
		super("Dibujo");
		lienzo = new Lienzo(this);
		dibujo = new Dibujo();
		initComponents();

		btnCirculo.addActionListener(e ->  {
			try {
				Circulo circulo = new Circulo(
						(int) (Math.random() * lienzo.getWidth()),
						(int) (Math.random() * lienzo.getHeight()),
						true,
						Util.rgbToColor(Integer.parseInt(txtRojo.getText()),
								Integer.parseInt(txtVerde.getText()),
								Integer.parseInt(txtAzul.getText())),
						(int) (Math.random() * 50));
				pintar(circulo,"GRUPO CUALQUIERA");
			}catch (NumberFormatException ex){
				System.err.println("El usuario no ha metido correctamente los numeros");
				JOptionPane.showMessageDialog(JVentanaDibujo.this,"El color tiene que ser un numero");
			}catch (RGBConversionException ex){
				System.err.println("El usuario no ha metido correctamente los colores");
				JOptionPane.showMessageDialog(JVentanaDibujo.this,"El color no puede tener valor");
			}

		});
		btnCuadrado.addActionListener(e ->  {
			try {
				Cuadrado cuadrado = new Cuadrado(
						(int) (Math.random() * lienzo.getWidth()),
						(int) (Math.random() * lienzo.getHeight()),
						true,
						Util.rgbToColor(Integer.parseInt(txtRojo.getText()),
								Integer.parseInt(txtVerde.getText()),
								Integer.parseInt(txtAzul.getText())),
						(int) (Math.random() * 50));
				pintar(cuadrado,"GRUPO CUALQUIERA");
			}catch (NumberFormatException ex){
				System.err.println("El usuario no ha metido correctamente los numeros");
				JOptionPane.showMessageDialog(JVentanaDibujo.this,"El color tiene que ser un numero");
			}catch (RGBConversionException ex){
				System.err.println("El usuario no ha metido correctamente los colores");
				JOptionPane.showMessageDialog(JVentanaDibujo.this,ex.getMessage());
			}
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