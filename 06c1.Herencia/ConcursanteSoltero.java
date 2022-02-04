class ConcursanteSoltero extends Concursante {
  private Concursante[] relacionesConcurso;
  private int numRelaciones;
  
  ConcursanteSoltero(int sexo, String nombre, int edad)
  {
    super(sexo, nombre, edad);
    relacionesConcurso = new Concursante[10];
    numRelaciones = 0;
  }
  
  void addRelacion(ConcursanteConPareja relacion)
  {
    relacionesConcurso[numRelaciones] = relacion;
    numRelaciones += 1;
  
  }
  
  String getVilla()
  {
    if (getSexo() == MASCULINO)
      return "villa playa";
    else
      return "villa montaña";
  }
  
  public String toString(){
    return super.toString() + " , ES SOLTERO";
  }


}
