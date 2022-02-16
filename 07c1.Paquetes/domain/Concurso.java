package domain;

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
  
  public void addRelacion(ConcursanteSoltero cSoltero, Concursante c){
    cSoltero.addRelacion(c);
  }
  
  public int buscarConcursante(Concursante c){
    int i = 0;
    while(i < concursantes.length)
    {
      //if(concursantes[i].getNombre().equals(c.getNombre())) ESTO ESTO SE HACIA CUANDO TODAVÍA NO HABÍAMOS EXPLICADO EL EQUALS
      if(concursantes[i].equals(c))
        return i;
      
      i += 1;
    }    
    return -1;
  }
  public boolean eliminarConcursante(Concursante c){
    int pos = this.buscarConcursante(c);
    if(pos == -1)
      return false;
    else{
      concursantes[pos] = null;
      for(int i = pos; i < concursantes.length-1; i++){
        concursantes[i] = concursantes[i+1]; 
      }      
      
      
      return true;
    }
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("LISTADO DE CONCURSANTES\n");
    //String salida = "";
    for(Concursante c : concursantes)
    {
      if (c != null)
        sb.append(c + "\n");
        //salida = salida + c + "\n";
    
    }
    return sb.toString();
  }
  

}
