class Concursante{
  private String sexo;
  private String nombre;
  private int edad;
  private boolean soltero;
  private int edicionConcurso;
  
  Concursante(String sexo, String nombre, int edad, boolean soltero)
  {
    this.sexo = sexo;
    this.nombre = nombre;

    this.edad = edad;
    this.soltero = soltero;
  }
  
  String getVilla()
  {
    if (sexo.equals("masculino") && soltero == true)
      return "villa playa";
    else
      return "villa montaña";
    
  }


}




