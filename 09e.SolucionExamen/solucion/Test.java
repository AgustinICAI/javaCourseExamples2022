public abstract test{
  
  private List<String> lista;
  private int size;
  
  public void init(TipoLista tipolista, int size){
      switch(tipoLista){
      case ARRAYLIST:
        lista = new ArrayList();
        break;
      case LINKEDLIST:
        lista = new LinkedList();
        break;
        
      //Otra opcion
      lista = tipoLista.getLista();
        
    }
    this.size = size;
  
  }
  
  public abstract void run(int int0);



}
