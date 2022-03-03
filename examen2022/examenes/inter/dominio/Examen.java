public class Examen implements Comparable{
  private String nombre;
  private double dificultadInicial;
  
  public Examen(String nombre, double dificultadInicial){
  ....
  }
  
  
  public Examen(double dificultadInicial){
    this.dificultadInicial = dificultadInicial;
  }
  
  
  public String getAbreviatura(){
     String[] palabras = this.nombre.toUpperCase().split(" ");
     
     if(palabras.length == 1)
      return palabras[0].subString(0,1);
     else if (palabras.length == 2)
      return palabras[0].subString(0,1) + palabras[1].subString(0,1);
     else
      return palabras[0].subString(0,1) + palabras[1].subString(0,1) + palabras[palabras.length -1].subString(0,1); 

  }
  
  
  
  public double calcularDificultad(){return 0};
  
  
  public int compareTo(Object o){
    if (o instanceof Examen e){
      return Double.valueOf(this.calcularDificultad()).compareTo(e.calcularDificultad());
    
    }else return -1;
  }
  

}
