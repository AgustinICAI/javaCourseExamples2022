public class IterarObjetoTest extends Test{
  public IterarObjetoTest(TipoLista tipoLista, size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      lista.add(String.valueOf(i));
    
  }
  
  public void run(int int0){
     String x;
        for(String s:lista)
            x = s;

  }

}
