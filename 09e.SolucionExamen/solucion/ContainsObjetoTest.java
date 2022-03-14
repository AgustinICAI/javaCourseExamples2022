public class ContainsObjetoTest extends Test{
  public ContainsObjetoTest(TipoLista tipoLista, size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      lista.add(String.valueOf(i));
    
  }
  
  public void run(int posicion){
    boolean x = lista.contains(String.valueOf(valor));

  }

}
