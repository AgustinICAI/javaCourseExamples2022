package domain;

class ConcursanteSoltero extends Concursante {
  private Concursante[] relacionesConcurso;
  private int numRelaciones;
  
  ConcursanteSoltero(Sexo sexo, String nombre, int edad)
  {
    super(sexo, nombre, edad);
    relacionesConcurso = new ConcursanteConPareja[10];
    numRelaciones = 0;
  }
  
  void addRelacion(Concursante relacion)
  {
    relacionesConcurso[numRelaciones] = relacion;
    numRelaciones += 1;
  
  }
  
  public String getVilla()
  {
    if (getSexo() == Sexo.MASCULINO)
      return "villa playa";
    else
      return "villa montaña";
  }
  
  public String toString(){
    return super.toString() + " , ES SOLTERO";
  }
  
  public float calcularIndemnizacionDespido(float salario, int diasContrato){
    return salario * 3 + diasContrato/5*salario;  
  }



}
