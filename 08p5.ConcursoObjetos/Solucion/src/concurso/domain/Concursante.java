package concurso.domain;

public abstract class Concursante {

  private Sexo sexo;
  private String nombre;
  private int edad;


  public enum Sexo{
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

  public boolean equals(Object o){
    if(o instanceof Concursante concursante)
      return concursante.getNombre().equals(this.getNombre());
    else
      return false;
  }


}




