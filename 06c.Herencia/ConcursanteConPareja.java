class ConcursanteConPareja extends Concursante {
  
  private ConcursanteConPareja pareja;
  private int mesesRelacion;
  private boolean infidelidadPrevia;
  
  ConcursanteConPareja(int sexo, String nombre, int edad, int mesesRelacion, boolean infidelidadPrevia){
    super(sexo, nombre, edad);
    this.mesesRelacion = mesesRelacion;
    this.infidelidadPrevia = infidelidadPrevia; 
  }
  
  ConcursanteConPareja(int sexo, String nombre, int edad, boolean infidelidadPrevia, ConcursanteConPareja pareja){
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

  String getVilla()
  {
    if (getSexo() == FEMENINO)
      return "villa playa";
    else
      return "villa montaña";
  }
  
  public String toString(){
    return super.toString() + " , PAREJA: " + pareja.getNombre();
  }



}
