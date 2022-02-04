public class Concurso{
  private Concursante[] concursantes = new Concursante[30];
  private int numConcursantes = 0;
  
  
  public void addPareja(ConcursanteConPareja c1, ConcursanteConPareja c2){
    this.addConcursante(c1);
    this.addConcursante(c2);
    c1.setPareja(c2);
  }
  public void addConcursante(Concursante c)
  {
    concursantes[numConcursantes] = c;
    numConcursantes +=1;
  }
  
  public void addRelacion(Concursante cSoltero, Concursante c){
    cSoltero.addRelacion(c);
  
  }
  

}
