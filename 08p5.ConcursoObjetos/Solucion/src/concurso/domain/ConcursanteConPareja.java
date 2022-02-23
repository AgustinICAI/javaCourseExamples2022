package concurso.domain;

public class ConcursanteConPareja extends Concursante {

  private ConcursanteConPareja pareja;
  private boolean infidelidadPrevia;

  public ConcursanteConPareja(Concursante.Sexo sexo, String nombre, int edad, boolean infidelidadPrevia){
    super(sexo, nombre, edad);
    this.infidelidadPrevia = infidelidadPrevia;
  }

  public ConcursanteConPareja(Sexo sexo, String nombre, int edad, boolean infidelidadPrevia, ConcursanteConPareja pareja){
    this(sexo, nombre, edad, infidelidadPrevia);
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

  public String getVilla()
  {
    if (getSexo() == Sexo.FEMENINO)
      return "villa playa";
    else
      return "villa montaña";
  }

  public String toString(){
    return "[CONCURSANTE CON PAREJA] " + super.toString() + " , PAREJA: " + pareja.getNombre();
  }



}