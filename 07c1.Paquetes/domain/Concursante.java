package domain;

abstract class Concursante implements Despedible{
  private Sexo sexo;
  private String nombre;
  private int edad;
  private int edicionConcurso;
  
//  static int MASCULINO = 0;
//  static int FEMENINO = 1;
  
  enum Sexo{
    MASCULINO, FEMENINO;
  }
  
  
  Concursante(Sexo sexo, String nombre, int edad)
  {
    this.sexo = sexo;
    this.nombre = nombre;
    this.edad = edad;
  }
  
  public Sexo getSexo(){
    return this.sexo;
  }
  
  public String toString(){
    return "nombre: " + nombre + ", sexo: " + sexo + ", edad: " + edad; 
  }
  
  public String getNombre(){
    return this.nombre;
  }
  public int getEdad(){
    return this.edad;
  }
  
  public abstract String getVilla();
 
  public String calcularUltimoDia(int diasContrato){
    return "Día Siguiente"; 
  }
  
  public boolean equals(Object o){
    if(!(o instanceof Concursante))
      return false;
    Concursante c = (Concursante)o;
    if (this.getNombre().equals(c.getNombre()) && this.edad == c.getEdad())
      return true;
    else
      return false;
    
  }

}




