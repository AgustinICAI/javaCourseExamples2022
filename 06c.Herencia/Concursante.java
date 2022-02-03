class Concursante{
  private int sexo;
  private String nombre;
  private int edad;
  private int edicionConcurso;
  
  static int MASCULINO = 0;
  static int FEMENINO = 1;
  
  
  Concursante(int sexo, String nombre, int edad)
  {
    this.sexo = sexo;
    this.nombre = nombre;
    this.edad = edad;
  }
  
  public int getSexo(){
    return this.sexo;
  }
  
  public String toString(){
    return "nombre: " + nombre + ", sexo: " + sexo + ", edad: " + edad; 
  }
  
  public String getNombre(){
    return this.nombre;
  }
 

}




