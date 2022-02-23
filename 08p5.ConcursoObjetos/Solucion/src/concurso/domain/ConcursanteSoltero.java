package concurso.domain;

import java.util.Random;

public class ConcursanteSoltero extends Concursante {
  private Concursante[] relacionesConcurso;
  private int numRelaciones;
  private static int MEDIA_TENTADOR = 30000;
  private static int DESVIACION_TIPICA_TENTADOR = 15000;
  public ConcursanteSoltero(Sexo sexo, String nombre, int edad)
  {
    super(sexo, nombre, edad);
    relacionesConcurso = new ConcursanteConPareja[Concurso.NUM_PAREJAS];
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
    String strRelacionesConcurso = "";
    for(Concursante c : this.relacionesConcurso)
      if(c!=null)
        strRelacionesConcurso = strRelacionesConcurso + c.getNombre() + ", ";

    return (this.getSexo()==Sexo.MASCULINO?"[SOLTERO]":"[SOLTERA]") +" "+ super.toString() + " , RELACIONES: " + strRelacionesConcurso;
  }


  public double getFactorTentadorNormalRamdom() {
    Random r = new Random();
    return r.nextGaussian()*DESVIACION_TIPICA_TENTADOR + MEDIA_TENTADOR;

  }
}
