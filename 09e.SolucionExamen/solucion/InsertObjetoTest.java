public class InsertObjetoTest extends Test{
  public InsertObjetoTest(TipoLista tipoLista, size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      lista.add(String.valueOf(i));
    
  }
  
  public void run(int posicion){
    lista.add(posicion, String.valueOf(posicion));
  }

}
