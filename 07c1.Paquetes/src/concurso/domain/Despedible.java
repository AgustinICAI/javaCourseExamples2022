package concurso.domain;

public interface Despedible{
  //No hace falta poner abstract, porque todos los métodos de un interface son abstractos
  public abstract float calcularIndemnizacionDespido(float salario, int diasContrato);
  public String calcularUltimoDia(int diasContrato);
  
}
