public class AppDibujo021 {
	public static void main(String[] args) {
		Dibujo dibujo = new Dibujo();

		Cuadrado.setRELLENO(false);

		Cuadrado[] cuadrados = new Cuadrado[3];
		dibujo.setCuadrados(cuadrados);

		cuadrados[0] = new Cuadrado(500, 50, 50);
		dibujo.actualizaContenido();
		Util.wait(1);
		cuadrados[1] = new Cuadrado(300, 300, 100);
		dibujo.actualizaContenido();
		Util.wait(1);
		cuadrados[2] = new Cuadrado(10, 10, 200);
		dibujo.actualizaContenido();
	}
}
