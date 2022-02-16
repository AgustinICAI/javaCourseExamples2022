package domain;

class ConcursanteConPareja extends Concursante {
  
  private ConcursanteConPareja pareja;
  private int mesesRelacion;
  private boolean infidelidadPrevia;
  
  ConcursanteConPareja(Concursante.Sexo sexo, String nombre, int edad, int mesesRelacion, boolean infidelidadPrevia){
    super(sexo, nombre, edad);
    this.mesesRelacion = mesesRelacion;
    this.infidelidadPrevia = infidelidadPrevia; 
  }
  
  ConcursanteConPareja(Sexo sexo, String nombre, int edad, boolean infidelidadPrevia, ConcursanteConPareja pareja){
    this(sexo, nombre, edad, pareja.getMesesRelacion(), infidelidadPrevia);
    this.setPareja(pareja);
  }  
  public ConcursanteConPareja getPareja(){
    return this.pareja;
  }
  
  public void setPareja(ConcursanteConPareja pareja){
    this.pareja = pareja;
    if (pareja.getPareja() == null)
      pareja.setPareja(this);
  }
  
  public int getMesesRelacion(){
    return mesesRelacion;
  }

  public String getVilla()
  {
    if (getSexo() == Sexo.FEMENINO)
      return "villa playa";
    else
      return "villa montaña";
  }
  
  public String toString(){
    return super.toString() + " , PAREJA: " + pareja.getNombre();
  }
  
  public float calcularIndemnizacionDespido(float salario, int diasContrato){
    return salario * 3 + diasContrato;  
  }


}
